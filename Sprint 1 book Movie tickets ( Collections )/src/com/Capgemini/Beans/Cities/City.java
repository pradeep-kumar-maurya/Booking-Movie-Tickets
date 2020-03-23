package com.Capgemini.Beans.Cities;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class City {

	public void chooseCity() {	

		Map<Integer, String> lmap = new LinkedHashMap<Integer, String>();

		lmap.put(1, "Hyderabad");
		lmap.put(2, "Banglore");
		lmap.put(3, "Mumbai");
		// Add more Cities here

		Set set = lmap.entrySet();
		Iterator itr = set.iterator();
		System.out.println("-> Please select a City by its SNo");
		System.out.println("SNo   City");
		System.out.println("--------------------");

		while(itr.hasNext())
		{
			Entry entry = (Entry) itr.next();
			System.out.println(entry.getKey()+"       "+entry.getValue());
		}
	}
}
