package com.Capgemini.Beans.Cities;

public class Seats {
	private int SNo;
	private String seat_type;
	private int seats_available;
	private int price;
	
	public Seats(int sNo, String seat_type, int seats_available, int price) {
		super();
		this.SNo = sNo;
		this.seat_type = seat_type;
		this.seats_available = seats_available;
		this.price = price;
	}

	public int getSNo() {
		return SNo;
	}

	public void setSNo(int sNo) {
		this.SNo = sNo;
	}

	public String getSeat_type() {
		return seat_type;
	}

	public void setSeat_type(String seat_type) {
		this.seat_type = seat_type;
	}

	public int getSeats_available() {
		return seats_available;
	}

	public void setSeats_available(int seats_available) {
		this.seats_available = seats_available;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return SNo + "       " + seat_type + "          " + seats_available + "                " + price;
	}
	
}
