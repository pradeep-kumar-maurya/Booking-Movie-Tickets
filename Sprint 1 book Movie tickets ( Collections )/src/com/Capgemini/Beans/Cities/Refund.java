package com.Capgemini.Beans.Cities;

public class Refund {
	private int account_No;
	private int money_Refunded;
	private String date_time;
	private int booking_Id;
	
	public Refund(int account_No, int money_Refunded, String date_time, int booking_Id) {
		super();
		this.account_No = account_No;
		this.money_Refunded = money_Refunded;
		this.date_time = date_time;
		this.booking_Id = booking_Id;
	}

	public int getAccount_No() {
		return account_No;
	}

	public void setAccount_No(int account_No) {
		this.account_No = account_No;
	}

	public int getMoney_Refunded() {
		return money_Refunded;
	}

	public void setMoney_Refunded(int money_Refunded) {
		this.money_Refunded = money_Refunded;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

	public int getBooking_Id() {
		return booking_Id;
	}

	public void setBooking_Id(int booking_Id) {
		this.booking_Id = booking_Id;
	}

	@Override
	public String toString() {
		return account_No + "  " + money_Refunded + "  " + date_time + "  " + booking_Id ;
	}
}
