package com.Capgemini.UI;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.Capgemini.Service.MovieService;

public class Client {

	public static void main(String[] args) {

		MovieService service = new MovieService();

		while(true)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter your choice");
			System.out.println("Press 1 -> Book Movie Tickets");
			System.out.println("Press 2 -> Cancel Movie Tickets");
			System.out.println("Press 3 -> Exit");
			try{
				int choice = sc.nextInt();

				if(choice>0 && choice<4)
				{
					switch(choice)
					{
					case 1 : try {
						service.bookTickets();
						service.transactions();
					} catch (Exception e) {
						System.out.println("Exception 1 -> either you are not Registered"
								+ "\nException 2 -> either your input is not appropiate"
								+ "\nException 3 -> either your choice is not appropiate");
					}
					break;

					case 2 : service.refund();
					service.update_Payments();
					break;

					case 3 : System.out.println("Thanks for using the application :)");
					System.exit(0);
					}
				}
				else {
					System.out.println("Sorry your input for choice is not correct");
				}
			}
			catch(InputMismatchException e) {
				System.out.println("your input should be an Intger value");
			}
			catch(NoSuchElementException e) {
				e.printStackTrace();
			}
		}
	}
}
