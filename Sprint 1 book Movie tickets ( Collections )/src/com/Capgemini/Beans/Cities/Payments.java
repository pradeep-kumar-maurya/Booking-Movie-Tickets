package com.Capgemini.Beans.Cities;

public class Payments {
	private int account_No;
	private int money_Collected;
	private int seats_Booked;
	private int refund;
	private int booking_Id;
	private String date_time;
	private String seat_type;
	
	
	public Payments(int account_No, int money_Collected, int seats_Booked, int refund, int booking_Id, String date_time,
			String seat_type) {
		super();
		this.account_No = account_No;
		this.money_Collected = money_Collected;
		this.seats_Booked = seats_Booked;
		this.refund = refund;
		this.booking_Id = booking_Id;
		this.date_time = date_time;
		this.seat_type = seat_type;
	}

	public String getSeat_type() {
		return seat_type;
	}

	public void setSeat_type(String seat_type) {
		this.seat_type = seat_type;
	}

	public int getAccount_No() {
		return account_No;
	}
	public void setAccount_No(int account_No) {
		this.account_No = account_No;
	}
	public int getMoney_Collected() {
		return money_Collected;
	}
	public void setMoney_Collected(int money_Collected) {
		this.money_Collected = money_Collected;
	}
	public int getSeats_Booked() {
		return seats_Booked;
	}
	public void setSeats_Booked(int seats_Booked) {
		this.seats_Booked = seats_Booked;
	}
	public int getRefund() {
		return refund;
	}
	public void setRefund(int refund) {
		this.refund = refund;
	}
	public int getBooking_Id() {
		return booking_Id;
	}
	public void setBooking_Id(int booking_Id) {
		this.booking_Id = booking_Id;
	}
	public String getDate_time() {
		return date_time;
	}
	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

	@Override
	public String toString() {
		return account_No + "    " + money_Collected + "  " + refund+"    "
				+ seats_Booked + "      "+ booking_Id + "  " + date_time
				+ "  " + seat_type;
	}
	
}
