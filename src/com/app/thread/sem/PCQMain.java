package com.app.thread.sem;

import com.app.thread.evenodd.EvenOddGen;
import com.app.thread.exam.semaphore.SemConsumer;
import com.app.thread.exam.semaphore.SemProducer;
import com.app.thread.exam.semaphore.SemQ;

public class PCQMain {
	public static void main(String[] args) {
		/*
		 * Q q = new Q(); new Producer(q); new Consumer(q);
		 */
		EvenOddGen evenOddGen = new EvenOddGen();
		/*
		 * new EvenProducer(evenOddGen); new OddProducer(evenOddGen);
		 */
		
		SemQ q = new SemQ();
		new SemProducer(q);
		new SemConsumer(q);
	}
}
