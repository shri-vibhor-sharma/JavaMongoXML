package com.run;
import com.db.connection.*;
import com.integration.XMLRead.*;

public class App {

	public static void main(String[] args) {
		MongoCRUD mongo = new MongoCRUD();
		String JSONString = mongo.fetchMongoData("Nayan");
		XMLConverter xmls = new XMLConverter();
		String XMLString  = xmls.TheXMLConverter(JSONString);
		System.out.println("Final XML String is \n"+XMLString);

	}

}
