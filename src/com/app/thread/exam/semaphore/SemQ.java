package com.app.thread.exam.semaphore;

import java.util.concurrent.Semaphore;

public class SemQ {
	private int count = 0;
	private boolean bFlag = false;
	Semaphore semProd = new Semaphore(1);
	Semaphore semCon = new Semaphore(0);

	public void put(int c) {

		try {
			semProd.acquire();
			count = c;
			semCon.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int get() {
		int c = 0;
		try {
			semCon.acquire();
			c = count;
			semProd.release();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return c;

	}

}
