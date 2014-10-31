package com.somnus.mongo;

import java.net.UnknownHostException;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class MongoDbUtil {
	private static Mongo mongo;
	//使用线程局部模式
	private static ThreadLocal<DB> threadLocal = new ThreadLocal<DB>();
	static{
		try {
			mongo = new Mongo("127.0.0.1:27017");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	public static DB getCurrentDb(String dbname){
		DB db=threadLocal.get();
		//判断是否得到
		if(db==null){
			db=mongo.getDB(dbname);
			//把DB对象设置到 threadLocal,相当于该DB已经和线程绑定
			threadLocal.set(db);
		}
		return db;
	}
	
	public static DBCollection getDBCollection(String collectionName)
	{
		return MongoDbUtil.getCurrentDb("demo").getCollection(collectionName);
	}
	
}
