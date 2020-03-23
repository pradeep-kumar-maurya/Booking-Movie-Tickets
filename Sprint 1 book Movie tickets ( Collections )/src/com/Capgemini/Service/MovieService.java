package com.Capgemini.Service;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import com.Capgemini.Beans.Cities.City;
import com.Capgemini.Beans.Cities.Customer;
import com.Capgemini.Beans.Cities.Language;
import com.Capgemini.Beans.Cities.Movies;
import com.Capgemini.Beans.Cities.Payments;
import com.Capgemini.Beans.Cities.Refund;
import com.Capgemini.Beans.Cities.Seats;
import com.Capgemini.Beans.Cities.Shows;
import com.Capgemini.Beans.Cities.Theatres;
import com.Capgemini.Dao.Exceptions;
import com.Capgemini.Dao.MovieDao;
import com.Capgemini.throwException.InvalidAuthenticationException;

public class MovieService implements MovieServiceInterface {

	Scanner sc = new Scanner(System.in);
	MovieDao dao = new MovieDao();
	Customer customer1 = new Customer(1000, "Pradeep", 100000, "pradeep", "pradeep123");
	Seats seat1 = new Seats(1, "Gold", 100, 800);
	Payments payments = null;
	Refund refund = null;
	Random random = new Random(); 
	Date date = new Date();
	Exceptions exceptions = new Exceptions();
	int accountNo = 0;
	int bookingId = 0;
	String date_time = null;

	@Override
	public void bookTickets() throws Exception {
		// Customers validity
		System.out.println("-> Please enter your Username");
		String username = sc.next();
		System.out.println("-> Please enter your Password");
		String password = sc.next();

		if(username.equals(customer1.getUsername()) && password.equals(customer1.getPassword()))
		{
			System.out.println("-> Valid Customer <-");
			System.out.println("** Book your Tickets now **");
			// Choosing the City
			City city = new City();
			city.chooseCity();

			// Chossing the Theatre
			Theatres theatre = new Theatres();
			theatre.chooseTheatre();

			// Choosing the Movie
			Movies movies = new Movies();
			movies.chooseMovie();

			// Choosing the Show
			Shows shows = new Shows();
			shows.chooseShow();

			// Choosing the Language
			Language language = new Language();
			language.chooseLanguage();
		}
		else { throw new InvalidAuthenticationException("invalid Customer"); }
	}

	@Override
	// Transactions	
	public int transactions() {
		int updated_balance = 0;
		int total_amount = 0;
		int no_of_seats = 0;
		int num = 0;
		String date_time = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("-> Please select the Seats by its SNo");
		System.out.println("SNo  Seat_Type   Seats_Available   Price");
		System.out.println("-------------------------------------------------");
		System.out.println(seat1);
		try {
			int seat = sc.nextInt();
			if(seat == 1)
			{
				if(seat1.getSeats_available() > 0) // checking the availability of seats
				{
					System.out.println("-> Please enter the no. of seats to be booked");
					no_of_seats = sc.nextInt();
					if(no_of_seats > 0 && no_of_seats <= seat1.getSeats_available())
					{
						total_amount = no_of_seats * seat1.getPrice();
						System.out.println("-> your total amount is : "+total_amount);
						System.out.println("-> Please enter your account number");
						int accountNo = sc.nextInt();
						if(accountNo == customer1.getAccount_No()) // checking with account number
						{
							if(customer1.getCurrent_Balance() >= 800) 
							{
								updated_balance = customer1.getCurrent_Balance()-total_amount;
								if(updated_balance >= 0) // checking if sufficient balance
								{
									int seats_left = seat1.getSeats_available()-no_of_seats;
									seat1.setSeats_available(seats_left);
									customer1.setCurrentBalance(updated_balance);
									num = random.nextInt(1000);
									date_time = date.toString();
									System.out.println("** your tickets are booked :) **");
									System.out.println("** your Booking ID is : "+num+" **");
									// Moving to the Dao layer
									payments = dao.transactions(customer1.getAccount_No(), total_amount, no_of_seats, 0, num, date_time, seat1.getSeat_type());
									System.out.println("|-> Payment Information is below : ");
									System.out.println("-----------------------------------------------------------------------------------------");
									System.out.println("accNo  tamn  ref  seats  bID  d&t                                     s_type  money");
									System.out.println("-----------------------------------------------------------------------------------------");
									System.out.println(payments+"   "+customer1.getCurrent_Balance()+"\n");
								}
								else { exceptions.noBalance(); }
							}
							else { exceptions.noBalance(); }
						}
						else { exceptions.wrongAccountNo(); }
					}
					else { exceptions.wrongNo_of_Seats(); }
				}
				else { exceptions.seatsNotAvailable(); }
			}
			else { exceptions.wrongSeatNo(); }
		}
		catch (InputMismatchException e) { System.out.println("your input should be an Integer value"); }
		return updated_balance;
	}

	@Override
	public void refund() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("** cancel your Tickets now **");
		System.out.println("-> Please enter your valid Account Number");
		try
		{
			accountNo = sc.nextInt();
			date_time = date.toString();
			System.out.println("-> Please enter your Booking ID");
			bookingId = sc.nextInt();

			if(accountNo == customer1.getAccount_No() && bookingId == payments.getBooking_Id())
			{
				System.out.println("** Valid Credentials **");
				System.out.println("-> No. of seats booked by you : "+payments.getSeats_Booked());
				// Moving to the Dao layer
				refund = dao.cancelTickets(customer1.getAccount_No(), payments.getMoney_Collected(),date_time ,payments.getBooking_Id());
				System.out.println("|-> Refund Information is below :");
				System.out.println("-------------------------------------------------------");
				System.out.println("a.no  refamn  d&t                                  bId");
				System.out.println("-------------------------------------------------------");
				System.out.println(refund);
			}
			else { System.out.println("Sorry, you have not booked any ticket"); }
		}
		catch(InputMismatchException e) { System.out.println("your input should be an Integer value"); }
	}
	
	@Override
	public int update_Payments() {
		int updateBalance = 0;
		if(accountNo == customer1.getAccount_No() && bookingId == payments.getBooking_Id())
		{
			int newSeats = seat1.getSeats_available() + payments.getSeats_Booked();
			updateBalance = customer1.getCurrent_Balance() + payments.getMoney_Collected();
			customer1.setCurrentBalance(updateBalance);
			int paymentBalance = payments.getMoney_Collected() - payments.getMoney_Collected();
			payments = dao.update_Payments(payments.getMoney_Collected(), paymentBalance, date_time,newSeats);
			System.out.println("\n|-> Refunded Payment Information is below : ");
			System.out.println("-------------------------------------------------------------------------------------------");
			System.out.println("accNo  tamn  ref  seats  bID  d&t                                  s_type     money");
			System.out.println("-------------------------------------------------------------------------------------------");
			System.out.println(payments+"   "+customer1.getCurrent_Balance()+"\n");
		}
		return updateBalance;
	}
}
