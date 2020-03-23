package com.Capgemini.Dao;

import com.Capgemini.Beans.Cities.Payments;
import com.Capgemini.Beans.Cities.Refund;

public interface MovieDaoInterface {
	Payments transactions(int i, int total_amount, int no_of_seats, int j, int num, String date_time, String string);
	Refund cancelTickets(int i, int j, String date_time, int k);
	Payments update_Payments(int money_Collected, int paymentBalance, String date_time, int newSeats);
}
