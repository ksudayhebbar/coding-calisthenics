package com.app.ab.factory;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConisVendingClientTest {
	private ConisVendingClient conisVendingClient;

	@Before
	public void setUp() throws Exception {
		conisVendingClient = new ConisVendingClient();
	}

	@After
	public void tearDown() throws Exception {
		conisVendingClient = null;
	}

	@Test
	public void getConistest() {
		assertEquals("Dime", 4,
				conisVendingClient.getConis(new DimeConisFactory(), 1));
		assertEquals("halfDollar", 2,
				conisVendingClient.getConis(new HalfDollarConisFactory(), 1));
		assertEquals("Dime", 40,
				conisVendingClient.getConis(new DimeConisFactory(), 10));
		assertEquals("halfDollar", 20,
				conisVendingClient.getConis(new HalfDollarConisFactory(), 10));
		assertEquals("Dime retun 0 amount", 4,
				conisVendingClient.getConis(new DimeConisFactory(), 1));
		assertEquals("halfDollar retun 0 amount", 0,
				conisVendingClient.getConis(new HalfDollarConisFactory(), 0));
	}
}
