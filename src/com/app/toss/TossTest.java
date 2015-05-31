package com.app.toss;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TossTest {
	private Toss toos;

	@Before
	public void setUp() throws Exception {
		toos = new Toss();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void flips() {
		toos.flips(1);
		toos.flips(2);
		toos.flips(10);
	}

	@Test
	public void getHeadFlips() {

		assertFalse(-1 > toos.getHeadFlips(1));

		assertFalse(-1 > toos.getHeadFlips(2));
		assertFalse(-1 > toos.getHeadFlips(10));
		assertEquals("-1", -1, toos.getHeadFlips(0));
	}

	@Test
	public void getTailFlips() {
		assertFalse(-1 > toos.getTailFlips(1));
		assertFalse(-1 > toos.getTailFlips(2));
		assertFalse(-1 > toos.getTailFlips(10));
		assertEquals("-1", -1, toos.getTailFlips(0));
	}

}
