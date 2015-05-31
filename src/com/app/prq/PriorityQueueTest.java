package com.app.prq;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PriorityQueueTest {
	private PriorityQueue pr;

	@Before
	public void setUp() throws Exception {
		pr = new PriorityQueue();
	}

	@After
	public void tearDown() throws Exception {
		pr = null;
	}

	@Test
	public void offerAndPeak() throws Exception {
		pr.offer(10, 3);
		assertEquals("adding ele", 1, pr.getSize());
		pr.offer(11, 1);
		assertEquals("adding ele", 2, pr.getSize());
		pr.offer(12, 10);
		assertEquals("adding ele", 3, pr.getSize());
		pr.offer(13, 8);
		assertEquals("adding ele", 4, pr.getSize());
		pr.offer(14, 1);
		assertEquals("adding ele", 5, pr.getSize());
		pr.offer(15, 1);
		assertEquals("adding ele ", 6, pr.getSize());
		assertEquals("11", 11, pr.peek(1));
		assertEquals("1", 5, pr.getSize());
		assertEquals("14", 14, pr.peek(1));
		assertEquals("14", 0, pr.peek(0));
		assertEquals("1", 4, pr.getSize());
	}
}
