package com.app.thread.countdown;

import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Complete the implementation of the runThreads method. The method should start
 * 5 concurrent threads that call the countToThreadLimit() method. The output
 * should be something like this ---- Starting thread: thread2 (count to 3) ----
 * Starting thread: thread0 (count to 1) ---- Starting thread: thread4 (count to
 * 5) ---- Starting thread: thread3 (count to 4) ---- Starting thread: thread1
 * (count to 2) thread3: count 0 thread4: count 0 thread0: count 0 thread2:
 * count 0 thread1: count 0 thread0: count 1 thread1: count 1 thread3: count 1
 * thread4: count 1 … thread3: count 3 thread4: count 5
 *
 * Test the code by running the unit test in ThreadRunnerTest
 */
public class ThreadRunner {

	public void runThreads() {

		CountDownLatch latch = new CountDownLatch(5);

		ThreadCounter task1 = new ThreadCounter(3, 2, latch);

		ThreadCounter task2 = new ThreadCounter(0, 1, latch);

		ThreadCounter task3 = new ThreadCounter(4, 5, latch);

		ThreadCounter task4 = new ThreadCounter(3, 4, latch);

		ThreadCounter task5 = new ThreadCounter(1, 3, latch);

		try {

			// if(latch.getCount()!=0){
			latch.await();
			// }
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public class ThreadCounter implements Runnable {
		private int nCount;
		private Thread thread;
		private CountDownLatch l;

		public ThreadCounter(int count, int threadNum, CountDownLatch latch) {
			this.nCount = count;
			thread = new Thread(this, "Thread" + threadNum);
			thread.start();
			this.l = latch;
		}

		@Override
		public void run() {

			countToThreadLimit(this.nCount);

		}

		public void countToThreadLimit(int limit) {
			// long limit = Math.round(Math.random() * 100);
			System.out.println("---- Starting thread: "
					+ Thread.currentThread().getName() + "( count to " + limit
					+ ")");
			try {
				l.countDown();

				for (int i = 0; i < limit; i++) {

					Thread.sleep(100);
					System.out.println(Thread.currentThread().getName()
							+ ": count " + i);

				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
