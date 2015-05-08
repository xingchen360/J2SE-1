package com.somnus.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InsertDataByThread {
	
	/**
	 * 插入数据
	 * @param datas 
	 * 					取得数据库大量数据
	 * @throws Exception
	 */
	public void insertDatToDB(List<Map<String, Object>> datas) throws Exception {
		// 定义一个临时集合，用于存放数据信息
		List<Map<String, Object>> tempDatas = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < datas.size(); i++){
			tempDatas.add(datas.get(i));
			if (i != 0 && i % 5000 == 0){
				createThread(tempDatas, i);
				// 重新生成一个新的临时数据集合。
				tempDatas = new ArrayList<Map<String, Object>>();
			}
		}
		createThread(tempDatas, datas.size());
	}
	
	/**
	 * 
	 * @param tempDatas
	 * 					单次线程临时数据
	 * @param i
	 * 					线程名字
	 */
	public void createThread(final List<Map<String, Object>> tempDatas, final int i){
		Thread logThread = new Thread(new Runnable(){
			public void run() {
				System.out.println("当前线程：" + Thread.currentThread().getName());
				try{
					/*往数据库插入数据的方法*/
					insert(tempDatas);
				} 
				catch (Exception e){
					e.printStackTrace();
				}
			}
		});
		logThread.setName("thread-"+i);
		logThread.start();
	}
	/**
	 * 仿入库方法
	 * @param datas
	 */
	public void insert(List<Map<String, Object>> datas)
	{
		System.out.println("插入数据");
	}
}
