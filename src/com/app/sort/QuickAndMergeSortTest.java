package com.app.sort;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuickAndMergeSortTest {
	private QuickAndMergeSort qm;
	private final static int SIZE = 7;
	private final static int MAX = 20;
	private int a[];

	@Before
	public void setUp() throws Exception {
		a = new int[SIZE];
		Random generator = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = generator.nextInt(MAX);
		}
		qm = new QuickAndMergeSort(a);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSort() {
		long startTime = System.currentTimeMillis();
		qm.sort();
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("Quicksort " + elapsedTime);
		qm.display();

		startTime = System.currentTimeMillis();
		qm.mSort();
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("Mergesort " + elapsedTime);
		qm.display();
	}

}
