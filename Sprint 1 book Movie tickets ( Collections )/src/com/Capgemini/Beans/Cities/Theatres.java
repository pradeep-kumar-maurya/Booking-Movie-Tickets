package com.Capgemini.Beans.Cities;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import com.Capgemini.throwException.InvalidCityException;
import com.Capgemini.throwException.MismatchInputException;

public class Theatres {

	public void chooseTheatre() throws InvalidCityException, MismatchInputException {
		Scanner sc = new Scanner(System.in);
		Set<String> set = new LinkedHashSet<String>();
		try{
			int citySNo = sc.nextInt();
			System.out.println("-> Please select a theatre");
			if(citySNo > 0 && citySNo < 4)
			{
				if(citySNo == 1)
					set.add("Asian, Pacific");
				else if(citySNo == 2)
					set.add("Fun, IMAX");
				else
					set.add("SriKrishna, Talluri");

				Iterator<String> itr = set.iterator();
				while(itr.hasNext())
				{
					System.out.println("Theatres : "+itr.next());
				}
			}
			else {
				throw new InvalidCityException("your choice is incorrect");
			}
		}
		catch(InputMismatchException e) {
			throw new MismatchInputException("characters are not allowed as input");
		}
	}
}
