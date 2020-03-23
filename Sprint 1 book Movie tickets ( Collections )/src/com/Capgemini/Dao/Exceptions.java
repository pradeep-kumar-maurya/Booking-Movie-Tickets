package com.Capgemini.Dao;

public class Exceptions {
	
	public void noBalance() {
		System.out.println("Sorry, you won't have enough Balance in your account");
	}

	public void wrongAccountNo() {
		System.out.println("Sorry, Incorrcet Account Number");
	}

	public void wrongSeatNo() {
		System.out.println("Sorry, Incorrect Seat number");
	}

	public void seatsNotAvailable() {
		System.out.println("Sorry, Seats are not available");
	}

	public void wrongNo_of_Seats() {
		System.out.println("entered no. of seats can't be Zero or more than the actual no. of seats");
	}
}
