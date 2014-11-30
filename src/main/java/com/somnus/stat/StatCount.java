package com.somnus.stat;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StatCount<T extends Base> {

	/**
	 * @description 给list中的数据，统计每列的总数，并给没有数据的初始化
	 *              比如8月份没数据，要实例化一个8月份的数据，并给所有的数据默认初始化，如0
	 * @param arr
	 *            统计的集合 例如 一年中的月份（12），一个月中的天数（30） new String
	 *            {"01月","02月","03月","04月" ,"05月","06月","07月","08月","09月","10月","11月","12月"}
	 * @param statlist
	 *            	需要重新组装的数据
	 * @return 新组装的数据
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<T> reStatCount(String[] arr, List<T> statlist) throws Exception {
		if (arr.length < 1) {
			throw new RuntimeException("arr is not allowed to empty");
		}
		List<T> relist = new ArrayList<T>();
		Class<T> clazz = (Class<T>) statlist.get(0).getClass();
		Map<String, T> datamap = new TreeMap<String, T>();
		for (int i = 0; i < arr.length; i++) {
			datamap.put(arr[i], clazz.newInstance());
		}
		for (int i = 0; i < statlist.size(); i++) {
			T object = statlist.get(i);
			String value = object.getName();
			for (String data : datamap.keySet()) {
				if (data.equals(value)) {
					datamap.put(data, object);
				}
			}
		}
		Field[] fields = clazz.getDeclaredFields();
		T total = clazz.newInstance();
		total.setName("合计");
		// 合计用，初始化一个sum值
		Map<String, Object> summap = new HashMap<String, Object>();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			String type = field.getType().toString();
			if (type.length() > 10) {
				type = type.substring(16);
			}
			if (type.equals("BigDecimal")) {
				summap.put(field.getName(), BigDecimal.ZERO);
			}
		}
		// sum = sum + value
		for (String data : datamap.keySet()) {
			T object = datamap.get(data);
			String value = object.getName();
			//如果某个对象对应的属性为空，则给name赋值，如“10月”
			if (value == null) {
				object.setName(data);
			}
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				String fieldName = field.getName();
				String firstLetter = fieldName.substring(0, 1).toUpperCase();

				String getMethodName = "get" + firstLetter+ fieldName.substring(1);
				Method getMethod = clazz.getMethod(getMethodName,new Class[] {});

				String setMethodName = "set" + firstLetter+ fieldName.substring(1);
				Method setMethod = clazz.getMethod(setMethodName,new Class[] { field.getType() });

				String type = field.getType().toString();
				if (type.length() > 10) {
					type = type.substring(16);
				}
				for (String sum : summap.keySet()) {
					if (sum.equals(fieldName) && type.equals("BigDecimal")) {
						BigDecimal getValue = (BigDecimal) getMethod.invoke(object, new Object[] {});
						BigDecimal totalValue = (BigDecimal) summap.get(sum);
						summap.put(sum, totalValue.add(getValue));
						setMethod.invoke(total,new Object[] { (BigDecimal) summap.get(sum) });
					}
				}
			}
			relist.add(object);
		}
		relist.add(total);
		return relist;
	}

	public static void main(String[] args) throws Exception {
		StatCount<Example> stat = new StatCount<Example>();
		List<Example> list = new ArrayList<Example>();
		Example e = new Example();
		e.setId("01");
		e.setName("01月");
		e.setValue(new BigDecimal(10));
		e.setValue2(new BigDecimal(20));
		e.setValue3(new BigDecimal(30));
		Example e2 = new Example();
		e2.setId("02");
		e2.setName("02月");
		e2.setValue(new BigDecimal(10));
		e2.setValue2(new BigDecimal(20));
		e2.setValue3(new BigDecimal(30));
		Example e12 = new Example();
		e12.setId("12");
		e12.setName("12月");
		e12.setValue(new BigDecimal(10));
		e12.setValue2(new BigDecimal(20));
		e12.setValue3(new BigDecimal(30));
		list.add(e);
		list.add(e2);
		list.add(e12);
		List<Example> rlist = stat.reStatCount(new String[] { "01月", "02月",
				"03月", "04月", "05月", "06月", "07月", "08月", "09月", "10月", "11月",
				"12月" }, list);
		for (Example data : rlist) {
			System.out.println(data.getName());
			System.out.println(data.getValue());
			System.out.println(data.getValue2());
			System.out.println(data.getValue3());
			System.out.println("***********************");
		}
	}

}
