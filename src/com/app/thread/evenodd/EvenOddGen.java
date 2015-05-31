package com.app.thread.evenodd;

public class EvenOddGen {
	private int count = 0;
	private boolean bFlag = false;

	public synchronized int getEvenNumber() {
		while(count%2!=0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notifyAll();
		return count++;

	}

	public synchronized int getOddNumber() {
		while(count%2==0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notifyAll();
		return count--;

	}

}
