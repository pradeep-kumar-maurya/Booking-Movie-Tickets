package com.Capgemini.Beans.Cities;

public class Customer {
	private int account_No;
	private String name;
	private int current_Balance;
	private String username;
	private String password;
	
	public Customer(int account_No, String name, int current_Balance, String username, String password) {
		super();
		this.account_No = account_No;
		this.name = name;
		this.current_Balance = current_Balance;
		this.username = username;
		this.password = password;
	}
	
	public int getAccount_No() {
		return account_No;
	}

	public void setAccount_No(int account_No) {
		this.account_No = account_No;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCurrent_Balance() {
		return current_Balance;
	}

	public void setCurrentBalance(int current_Balance) {
		this.current_Balance = current_Balance;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [accountNo=" + account_No + ", name=" + name + ", currentBalance=" + current_Balance
				+ ", username=" + username + ", password=" + password + "]";
	}
	
}
