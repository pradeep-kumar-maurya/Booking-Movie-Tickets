package com.Capgemini.Beans.Cities;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.Capgemini.throwException.InvalidShowException;
import com.Capgemini.throwException.MismatchInputException;

import java.util.Scanner;
import java.util.Set;

public class Shows {

	public void chooseShow() throws InvalidShowException, MismatchInputException {
		Scanner sc = new Scanner(System.in);
		Map<Integer, String> map = new LinkedHashMap();

		System.out.println("-> Please select a show by its SNo");

		System.out.println("SNo  Timings     Show");
		System.out.println("-----------------------------------");
		map.put(1, "   Morning     9AM-12PM");
		map.put(2, "   Afternoon   1PM-4PM");
		map.put(3, "   Evening      5PM-8PM");
		map.put(4, "   Night         9PM-12PM");



		Set set = map.entrySet();
		Iterator itr = set.iterator();
		while(itr.hasNext())
		{
			Entry<Integer, String> entry = (Entry<Integer, String>) itr.next();
			System.out.println(entry.getKey()+"  "+entry.getValue());
		}
		try {
			int show = sc.nextInt();
			if(show < 1 || show > 4)
			{
				throw new InvalidShowException("incorrect choice");
			}
		}
		catch (InputMismatchException e) {
			throw new MismatchInputException("wrong input");
		}
	}
}
