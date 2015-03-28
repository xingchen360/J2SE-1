package com.somnus.mongo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.bson.types.ObjectId;
import org.junit.Test;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class MongoDemo {
	@Test
	public void createCollection()
	{
		MongoDbUtil.getCurrentDb("somnus").createCollection("xx", new BasicDBObject());
	}
	
	@Test
	public void insertOne()
	{
		//1.得到集合
		DBCollection coll = MongoDbUtil.getDBCollection("persons");
		
		DBObject dbo = new BasicDBObject();
		dbo.put("name", "uspcat.com");
		dbo.put("age", 2);
		List<String>  books = new ArrayList<String>();
		books.add("EXTJS");
		books.add("MONGODB");
		dbo.put("books", books);		
		
		//2.插入操作
		System.out.println(coll.insert(dbo));
	}
	
	@Test
	public void insertBatch()
	{
		//1.得到集合
		DBCollection coll = MongoDbUtil.getDBCollection("persons");
		
		List<DBObject> dbObjects = new ArrayList<DBObject>();
		DBObject dbo1 = new BasicDBObject("name","jim");
		DBObject dbo2 = new BasicDBObject("name","lisi");
		dbObjects.add(dbo1);
		dbObjects.add(dbo2);	
		
		//2.插入操作
		System.out.println(coll.insert(dbObjects).getN());
	}
	
	@Test
	public void remove()
	{
		DBCollection coll = MongoDbUtil.getDBCollection("persons");
				
		DBObject dbo = new BasicDBObject("_id", new ObjectId("53200aeedb42a37bd666c75e"));
		
		System.out.println(coll.remove(dbo).getN());
	}
	
	@Test
	public void remove2()
	{
		DBCollection coll = MongoDbUtil.getDBCollection("persons");
		
		DBObject dbo = new BasicDBObject();
		dbo.put("name", "lisi");
		
		System.out.println(coll.remove(dbo).getN());
	}
	
	@Test
	public void update()
	{
		DBCollection coll = MongoDbUtil.getDBCollection("persons");
		
		DBObject update = new BasicDBObject();
		update.put("$set", new BasicDBObject("email","uspcat@126.com"));
		/*
		 * db.users.update({age: 25}, {$set: {email: 'uspcat@126.com'}}, false, true);
 		 *	相当于：update person set email = 'uspcat@126.com’ where age = 25;
		 */
		System.out.println(coll.update(new BasicDBObject("age",25), update, false, true).getN());
		//update的第三个参数设置为true，存在则更新，不存在则插入。
		//update的第四个参数设置为true，则批量更新搜索到的所有记录
	}
	
	@Test
	public void find()//查询出persons集合中的name和age
	{
		DBCollection coll = MongoDbUtil.getDBCollection("persons");
		
		DBObject keys = new BasicDBObject();
		keys.put("_id", false);
		keys.put("name", true);
		keys.put("age", true);
		keys.put("email", true);
		
		DBCursor cursor = coll.find(null, keys).sort(new BasicDBObject("age",-1));
	    while (cursor.hasNext()) 
	    {
		    DBObject object = cursor.next();
		    System.out.println(object.get("name"));
		    System.out.println(object.get("age"));
		    System.out.println(object.get("email"));
		    System.out.println("-------------------------");
	    }
	}
	
	@Test
	public void find2()
	{
		DBCollection coll = MongoDbUtil.getDBCollection("persons");
		
		/*
		 * 查询age = 25的记录
		 * db.persons.find({"age": 25});
		 */
	    DBObject query1 = new BasicDBObject("age",25);
		DBCursor cursor1 = coll.find(query1, null);
	    while (cursor1.hasNext()) 
	    {
		    DBObject object = cursor1.next();
		    System.out.print(object.get("name")+"-->");
		    System.out.print(object.get("age")+"-->");
		    System.out.println(object.get("e"));
		    System.out.println("-------------------------");
	    }
	    System.out.println("*******************************查询age = 25的记录*****************************************");
	    /*
	     * 查询age > 25的记录
	     * db.persons.find({age: {$gt: 22}});
	     */
	    DBObject query2 = new BasicDBObject();
	    query2.put("age", new BasicDBObject("$gt",25));//$lt[<]  $gte[>=]  $lte[<=]
		DBCursor cursor2 = coll.find(query2, null);
	    while (cursor2.hasNext()) 
	    {
		    DBObject object = cursor2.next();
		    System.out.print(object.get("name")+"-->");
		    System.out.print(object.get("age")+"-->");
		    System.out.println(object.get("e"));
		    System.out.println("-------------------------");
	    }
	    System.out.println("****************************查询age > 25的记录********************************************");
	    /*
	     * 查询age >= 23 并且 age <= 26 并且英语成绩及格
	     * db.persons.find({age: {$gte: 23, $lte: 26},e:{$gte:60}});
	     */
	    BasicDBObject result = new BasicDBObject();
	    result.put("$gte", 23);
	    result.put("$lte", 26);
        BasicDBObject query22 = new BasicDBObject();
        query22.put("age", result);
        query22.put("e", new BasicDBObject("$gte",60));
		DBCursor cursor22 = coll.find(query22, null);
	    while (cursor22.hasNext()) 
	    {
		    DBObject object = cursor22.next();
		    System.out.print(object.get("name")+"-->");
		    System.out.print(object.get("age")+"-->");
		    System.out.println(object.get("e"));
		    System.out.println("-------------------------");
	    }
	    System.out.println("*******************************查询age >= 23 并且 age <= 26 并且英语成绩及格*****************************************");
	    /*
	     * 查询age < 25 或者 age >= 27
	     * db.persons.find({$or: [{age: 27}, {age: 25}]});
	     */
	    BasicDBObject result1 = new BasicDBObject("age",new BasicDBObject("$gte",27));
	    BasicDBObject result2 = new BasicDBObject("age",new BasicDBObject("$lt",25));
	    BasicDBList values = new BasicDBList();  
	    values.add(result1);
	    values.add(result2);
        BasicDBObject query33 = new BasicDBObject();
        query33.put("$or", values);
		DBCursor cursor33 = coll.find(query33, null);
	    while (cursor33.hasNext()) 
	    {
		    DBObject object = cursor33.next();
		    System.out.print(object.get("name")+"-->");
		    System.out.print(object.get("age")+"-->");
		    System.out.println(object.get("e"));
		    System.out.println("-------------------------");
	    }
	    System.out.println("****************************** 查询age < 25 或者 age >= 27******************************************");
	    /*
		 * 查询name中以zh开头的数据
		 * db.persons.find({name: /li/});
		 */
	    DBObject query3 = new BasicDBObject();
	    Pattern pattern = Pattern.compile("^zh", Pattern.CASE_INSENSITIVE);
	    query3.put("name", pattern);
		DBCursor cursor3 = coll.find(query3, null);
	    while (cursor3.hasNext()) 
	    {
		    DBObject object = cursor3.next();
		    System.out.print(object.get("name")+"-->");
		    System.out.print(object.get("age")+"-->");
		    System.out.println(object.get("e"));
		    System.out.println("-------------------------");
	    }
	    System.out.println("*****************************查询name中以zh开头的数据*******************************************");
	    /*
	     * 查询name = zhangsan, age > 22的数据
	     * db.persons.find({name: 'zhangsan', age: {$gt: 22}});
	     */
	    DBObject query4 = new BasicDBObject();
	    query4.put("age", new BasicDBObject("$gt",22));
	    query4.put("name", "jim");
		DBCursor cursor4 = coll.find(query4, null);
	    while (cursor4.hasNext()) 
	    {
		    DBObject object = cursor4.next();
		    System.out.print(object.get("name")+"-->");
		    System.out.print(object.get("age")+"-->");
		    System.out.println(object.get("e"));
		    System.out.println("-------------------------");
	    }
	    System.out.println("***************************查询name = zhangsan, age > 22的数据*********************************************");
	    
	}
	
	@Test
	public void findByPage()
	{
		DBCollection coll = MongoDbUtil.getDBCollection("persons");
		/*
		 * 查询前5条数据
		 * db.persons.find().limit(5);
		 * 查询10条以后的数据
		 * db.persons.find().skip(10);
		 * 查询在5-10之间的数据
		 * db.persons.find().limit(10).skip(5);
		 * limit是pageSize，skip是(N页)*pageSize
		 */
		DBCursor cursor = coll.find(null, null).limit(5).skip(0);
		System.out.println(coll.find(null, null).length());
	    while (cursor.hasNext()) 
	    {
	    	DBObject object = cursor.next();
		    System.out.println(object.get("name"));
		    System.out.println(object.get("age"));
		    System.out.println(object.get("email"));
		    System.out.println("-------------------------");
	    }
	}
	
}






