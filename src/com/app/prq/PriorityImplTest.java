package com.app.prq;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PriorityImplTest {

	@Test
	public void testadd() {

		PriorityImpl<Integer> impl = new PriorityImpl<Integer>();
		impl.add(101, 10);
		impl.add(102, 11);
		impl.add(103, 12);
		impl.add(104, 13);
		impl.display();
		System.out.println("removed " + impl.getNext());
		System.out.println("removed " + impl.getNext());
		System.out.println("removed " + impl.getNext());
		System.out.println("removed " + impl.getNext());

		System.out.println("empty " + impl.isEmpty());

	}

}
