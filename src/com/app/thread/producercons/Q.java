package com.app.thread.producercons;

public class Q {
	private int count = 0;
	private boolean bFlag = false;

	public synchronized void put(int c) {
		while (bFlag) {
			try {
				wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		
		count = c;
		bFlag=true;
		notifyAll();
	}

	public synchronized int get() {
		while (!bFlag) {
			try {
				wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		bFlag=false;
		notifyAll();
		return count;

	}

}
