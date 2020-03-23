package com.Capgemini.Beans.Cities;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import com.Capgemini.throwException.InvalidTheatreException;

public class Movies {

	public void chooseMovie() throws InvalidTheatreException {
		Scanner sc = new Scanner(System.in);
		Set<String> set = new LinkedHashSet<String>();
		String theatre = sc.next();
		String theatre1 = theatre.toLowerCase();

		System.out.println("-> Please select a movie");

		if(theatre1.equals("asian"))
			set.add("Avengers, Bahubali 1, Bahubali 2");

		else if(theatre1.equals("pacific"))
			set.add("Avengers, Fast and Furious 9, The Core");

		else if(theatre1.equals("fun"))
			set.add("Tanhaji, Fast and Furious 9, Spiderman Returns");

		else if(theatre1.equals("imax"))
			set.add("The 2012, Interstellar, Jumangi 2");

		else if(theatre1.equals("srikrishna"))
			set.add("Robot 2, PK, Yevadu");

		else if(theatre1.equals("talluri"))
			set.add("KGF, KGF 2, Hosefull 4");

		else {
			throw new InvalidTheatreException("incorrect input");
		}

		Iterator itr = set.iterator();
		while(itr.hasNext())
		{
			System.out.println("Movies on Screen : "+itr.next());
		}
		String movie = sc.next();	
	}
}
