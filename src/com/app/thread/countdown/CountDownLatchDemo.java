package com.app.thread.countdown;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	final static int N = 3;

	   public static void main(String[] args) throws InterruptedException
	   {
	      CountDownLatch startSignal = new CountDownLatch(1);
	      CountDownLatch doneSignal = new CountDownLatch(N);
	      for (int i = 0; i < N; ++i) // create and start threads
	         new Thread(new Worker(startSignal, doneSignal)).start();
	      System.out.println("about to let threads proceed");
	      startSignal.countDown(); // let all threads proceed
	      System.out.println("doing work");
	      System.out.println("waiting for threads to finish");
	      doneSignal.await(); // wait for all threads to finish
	      System.out.println("main thread terminating");
	   }
}
