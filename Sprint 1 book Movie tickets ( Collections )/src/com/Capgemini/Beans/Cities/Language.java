package com.Capgemini.Beans.Cities;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.Capgemini.throwException.InvalidLanguageException;

import java.util.Scanner;
import java.util.Set;

public class Language {

	public void chooseLanguage() throws InvalidLanguageException {
		Scanner sc = new Scanner(System.in);
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();

		System.out.println("->Please select a language by its SNo");
		System.out.println("SNo  Language");
		System.out.println("------------------");
		map.put(1, "English");
		map.put(2, "Hindi");
		map.put(3, "Telugu");

		Set set = map.entrySet();
		Iterator itr = set.iterator();
		while(itr.hasNext())
		{
			Entry<Integer, String> entry = (Entry) itr.next();
			System.out.println(entry.getKey()+"       "+entry.getValue());
		}
		try {
			int language = sc.nextInt();
			if(language < 1 || language >3)
			{
				throw new InvalidLanguageException("incorrect choice");
			}
			}
		catch (InvalidLanguageException e) {
			throw new InvalidLanguageException("incorrect input");
		}
	}
}

