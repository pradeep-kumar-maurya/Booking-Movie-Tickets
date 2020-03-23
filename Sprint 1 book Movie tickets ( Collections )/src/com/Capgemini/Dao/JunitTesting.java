package com.Capgemini.Dao;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import com.Capgemini.Service.MovieService;

public class JunitTesting {

	MovieService service = new MovieService();
	MovieDao dao = new MovieDao();

	@Test
	public void check_Transactions() throws Exception {
		int actual = service.transactions();
		int expected = 99200;
		assertEquals(expected, actual);
	}

	@Ignore
	@Test
	public void check_Cancelling() {
		int actual = service.update_Payments();
		int expected = 100000;
		assertEquals(expected, actual);
	}


	@Test
	public void check_Persistence() {
		Object actual = dao.transactions(1,1600,3,0,333,"20-03-2020, time : 2:33 PM","Gold");
		String string1 = actual.toString();
		String string2 = "1    1600  0    3      333  20-03-2020, time : 2:33 PM  Gold";
		assertEquals(string2, string1);
	}
	
	
	@Test
	public void chech_Refunding(){
		Object actual = dao.cancelTickets(1, 1600, "20-03-2020, time : 2:33 PM", 333);
		String string1 = actual.toString();
		String string2 = ("1  1600  20-03-2020, time : 2:33 PM  333");
		assertEquals(string2, string1);
	}
}
