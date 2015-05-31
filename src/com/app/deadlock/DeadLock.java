package com.app.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
	public static class Friend {
		private final String name;
		
		private final Lock lock = new ReentrantLock();

		public Friend(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}
		public boolean impendingBow(Friend bower) {
            Boolean myLock = false;
            Boolean yourLock = false;
            try {
                myLock = lock.tryLock();
                yourLock = bower.lock.tryLock();
            } finally {
                if (! (myLock && yourLock)) {
                    if (myLock) {
                        lock.unlock();
                    }
                    if (yourLock) {
                        bower.lock.unlock();
                    }
                }
            }
            return myLock && yourLock;
        }
		public synchronized void bow(Friend bower) {
			 if (impendingBow(bower)) {
	                try {
	                    System.out.format("%s: %s has"
	                        + " bowed to me!%n", 
	                        this.name, bower.getName());
	                    bower.bowBack(this);
	                } finally {
	                    lock.unlock();
	                    bower.lock.unlock();
	                }
	            } else {
	                System.out.format("%s: %s started"
	                    + " to bow to me, but saw that"
	                    + " I was already bowing to"
	                    + " him.%n",
	                    this.name, bower.getName());
	            }
		}

		public synchronized void bowBack(Friend f) {
			System.out.format("%s: %s" + " has bowed back to me!%n", this.name,
					f.getName());
		}
	}

	public static void main(String[] args) {
		final Friend alphonse = new Friend("Alphonse");
		final Friend gaston = new Friend("Gaston");

		new Thread(new Runnable() {

			@Override
			public void run() {
				alphonse.bow(gaston);

			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				gaston.bow(alphonse);

			}
		}).start();
	}

}
