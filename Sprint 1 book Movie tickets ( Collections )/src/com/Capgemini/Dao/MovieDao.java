package com.Capgemini.Dao;

import com.Capgemini.Beans.Cities.Payments;
import com.Capgemini.Beans.Cities.Refund;
import com.Capgemini.Beans.Cities.Seats;

public class MovieDao implements MovieDaoInterface{

	Payments payments = null;
	Refund refund = null;
	Seats seat1 = new Seats(1, "Gold", 100, 800);
	@Override	
	public Payments transactions(int i, int total_amount, int no_of_seats, int j, int num, String date_time, String string) {

		payments = new Payments(i, total_amount, no_of_seats, j, num, date_time, string);
		if(payments != null)
			return payments;
		else
			return null;
	}

	@Override
	public Refund cancelTickets(int i, int j, String date_time, int k) {
		
		refund = new Refund(i, j,date_time ,k);
		if(refund != null)
			return refund;
		else
			return null;
	}

	@Override
	public Payments update_Payments(int money_Collected, int paymentBalance, String date_time, int newSeats) {
		seat1.setSeats_available(newSeats);
		payments.setMoney_Collected(paymentBalance);
		payments.setDate_time(date_time);
		payments.setRefund(money_Collected);
		return payments;
	}
}

