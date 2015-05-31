package com.app.fibfact;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class fibonacciAndFactTest {
	private fibonacciAndFact fib;

	@Before
	public void setUp() throws Exception {
		fib = new fibonacciAndFact();
	}

	@After
	public void tearDown() throws Exception {
		fib = null;
	}

	@Test
	public void testGenFibonacciSeries() {

		System.out.println(fib.genFibonacciSeries(1));
		System.out.println(fib.genFibonacciSeries(2));

		System.out.println(fib.factorial(1));
		System.out.println(fib.factorial(2));

		System.out.println(fib.factorial(10));

		System.out.println(fib.fact(10));

		System.out.println(fib.genFibonacciSeries(10));

		System.out.println(fib.fib(10));
	}

}
