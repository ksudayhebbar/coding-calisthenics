package com.app.linkedlist;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
	LinkedList<Integer> ln;

	@Before
	public void setUp() throws Exception {
		ln = new LinkedList<Integer>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void add() {
		ln.add(10);
		assertEquals("1", 1, ln.getSize());
		ln.add(11);
		assertEquals("1", 2, ln.getSize());
		ln.add(12);
		assertEquals("1", 3, ln.getSize());
		ln.add(13);
		assertEquals("1", 4, ln.getSize());
		ln.add(14);
		assertEquals("1", 5, ln.getSize());
		ln.add(15);
		assertEquals("1", 6, ln.getSize());
		ln.add(15, 4);
		assertEquals("1", 7, ln.getSize());
		ln.add(15, 8);
		assertEquals("1", 7, ln.getSize());
		ln.add(15, -1);
		assertEquals("1", 7, ln.getSize());
	}

	@Test
	public void remove() throws Exception {
		ln.add(10);
		assertEquals("1", 1, ln.getSize());
		ln.add(11);
		assertEquals("1", 2, ln.getSize());
		ln.add(12);
		assertEquals("1", 3, ln.getSize());
		ln.add(13);
		assertEquals("1", 4, ln.getSize());
		ln.add(14);
		assertEquals("1", 5, ln.getSize());
		ln.add(15);
		assertEquals("1", 6, ln.getSize());
		ln.remove();
		assertEquals("1", 5, ln.getSize());
		ln.remove(2);
		assertEquals("1", 4, ln.getSize());
		ln.remove();
		ln.remove();
		ln.remove();
		ln.remove();
		assertEquals("1", 0, ln.getSize());
		ln.add(10);
		assertEquals("1", 1, ln.getSize());
		ln.add(11);
		assertEquals("1", 2, ln.getSize());
		ln.add(12);
		assertEquals("1", 3, ln.getSize());

		ln.add(13);
		assertEquals("1", 4, ln.getSize());
		ln.remove(2);
		assertEquals("1", 3, ln.getSize());
		ln.remove(4);
		assertEquals("1", 3, ln.getSize());
		ln.remove(-1);
		assertEquals("1", 3, ln.getSize());
	}

}
