package com.app.deadlock;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDeadLock {

	static public class Test {
		private String name;
		private Lock lock = new ReentrantLock();

		public Test(String name) {
			this.name = name;
			
		}

		public boolean islocked(Test t) {
			boolean lock1 = false;
			boolean lock2 = false;
			try {
				lock1 = this.lock.tryLock();
				lock2 = t.lock.tryLock();
			} finally {
				if (!(lock1 && lock2)) {
					if (lock1) {
						this.lock.unlock();
					}
					if (lock2) {
						t.lock.unlock();
					}
				}
			}
			return lock1 && lock2;
		}

		public synchronized void testA(Test t) {
			if (islocked(t)) {
				try {
					System.out.format("%s: %s has" + " bowed to me!%n",
							this.name, t.name);
					t.testB(this);
				} finally {
					this.lock.unlock();
					t.lock.unlock();
				}
			}else{
				System.out.format("%s: %s started"
	                    + " to bow to me, but saw that"
	                    + " I was already bowing to"
	                    + " him.%n",
	                    this.name, t.name);
			}
		}

		public synchronized void testB(Test t) {
			System.out.format("%s: %s" + " has bowed back to me!%n", this.name,
					t.name);
		}
	}

	public static void main(String[] args) {
		Test deadLock = new Test("Thraed1");
		Test deadLock1 = new Test("Thraed2");

		new Thread(new Runnable() {

			@Override
			public void run() {
				deadLock.testA(deadLock1);
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				deadLock1.testA(deadLock);
			}
		}).start();
		 
	}
	
	
	
}
