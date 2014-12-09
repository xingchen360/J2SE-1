package com.somnus.apache;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

public class CommonsLang {
	public static void main(String[] args) throws Exception {
		// 将两个数组合并为一个数组
		String[] s1 = new String[] { "1", "2", "3" };
		String[] s2 = new String[] { "a", "b", "c" };
		String[] s = (String[]) ArrayUtils.addAll(s1, s2);
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
		String str = ArrayUtils.toString(s);
		str = str.substring(1, str.length() - 1);
		System.out.println(str + ">>" + str.length());
		System.out.println("********************************ArrayUtils***************************************");
		// 取得类名
		System.out.println(ClassUtils.getShortClassName(CommonsLang.class));
		// 取得其包名
		System.out.println(ClassUtils.getPackageName(CommonsLang.class));
		// 五位的随机字母和数字 
		System.out.println(RandomStringUtils.randomAlphanumeric(5));
		System.out.println("********************************ClassUtils***************************************");
		System.out.println(StringEscapeUtils.escapeHtml("<html>"));
		// 输出结果为&lt;html&gt;
		System.out.println(StringEscapeUtils.escapeJava("String"));
		System.out.println("********************************StringEscapeUtils***************************************");
		// 截取从from开始字符串
		System.out.println(StringUtils.substringAfter("SELECT * FROM PERSON " , "FROM"));
		// 判断该字符串是不是为数字(0~9)组成，如果是，返回true 但该方法不识别有小数点和请注意
		System.out.println(StringUtils.isNumeric("454534"));// 返回true
		// StringUtils,判断是否是空格字符
		System.out.println(StringUtils.isBlank("   "));
		// StringUtils,判断是否是null 或""
		System.out.println(StringUtils.isNotEmpty(""));
		// 将数组中的内容以,分隔
		System.out.println(StringUtils.join(new String[] { "1", "2", "3" }, ","));
		// 在右边加下字符,使之总长度为6
		System.out.println(StringUtils.rightPad("abc", 6, 'T'));
		// 首字母大写 
		System.out.println(StringUtils.capitalize("abc"));
		// Deletes all whitespaces from a String 删除所有空格
		System.out.println(StringUtils.deleteWhitespace("   ab  c  "));
		// 判断是否包含这个字符 
		System.out.println(StringUtils.contains("abc", "ba"));
		// 表示左边两个字符 
		System.out.println(StringUtils.left("abc", 2));
		System.out.println("********************************StringUtils***************************************");
		System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		//直接将日期格式化为内置的固定格式
		System.out.println(DateFormatUtils.ISO_DATE_FORMAT.format(new Date()));
		//字符型日期转化为Date
		System.out.println(DateUtils.parseDate("2014-11-11 11:11:11", new String[] { "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM-dd", "yyyy/MM/dd" }));
		//日期舍入与截整
		System.out.println(DateUtils.truncate(new Date(), Calendar.DATE));
		//判断是否是同一天
		System.out.println(DateUtils.isSameDay(new Date(), new Date()));
		//加天数
		System.out.println(DateUtils.addDays(new Date(), 10));
		System.out.println("********************************DateUtils***************************************");
	}
}
