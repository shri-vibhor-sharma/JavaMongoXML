package com.db.connection;

import java.net.UnknownHostException;
import java.util.Date;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteResult;

public class MongoCRUD {

	public static void main(String[] args) {
		try {

			MongoClient mongo = getConnection();
			if (mongo != null) {
				System.out.println("Connected to the DB yiee!!");
				DB db = mongo.getDB("mycustomers");
				DBCollection table = db.getCollection("customers");
				/* Create a search Query and search for a document with a key */
				BasicDBObject searchQuery = new BasicDBObject();
				searchQuery.put("first_name", "meghna");
				/* Create a DBCursor to loop thru the resultset and print it out */
				DBCursor cursor = table.find(searchQuery);
				while (cursor.hasNext()) {
					System.out.println(cursor.next());
				}
				// update the Object
				WriteResult myresult = UpdateData(table);
				System.out.println(myresult.toString());
			}
		} catch (MongoException e) {
			e.printStackTrace();
		}
	}

	public static MongoClient getConnection() {
		MongoClient mongo = null;
		try {
			/* create a mongo client and connect to mongo server */
			mongo = new MongoClient("localhost", 27017);

			return mongo;

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("Cant connect to a DB");
			e.printStackTrace();

		}
		return mongo;
	}

	public static WriteResult UpdateData(DBCollection table) {
		WriteResult result = null;
		try {
			BasicDBObject query = new BasicDBObject();
			query.put("first_name", "vibhor");

			BasicDBObject newDocument = new BasicDBObject();
			newDocument.put("first_name", "vibhor-updated");

			BasicDBObject updateObj = new BasicDBObject();
			updateObj.put("$set", newDocument);

			result = table.update(query, updateObj);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
