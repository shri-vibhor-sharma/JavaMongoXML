package com.integration.XMLRead;

import org.json.JSONObject;
import org.json.XML;

public class XMLConverter {
	public String TheXMLConverter(String inputstr) {
		//String sample = "{ \"_id\" : { \"$oid\" : \"5b6f13b0e53911a3b062fd54\"} , \"first_name\" : \"meghna\" , \"last_name\" : \"Sharma\"}";
		JSONObject json = new JSONObject(inputstr);
		String xml = XML.toString(json);
		System.out.println(xml);
		return xml;
	}
}
