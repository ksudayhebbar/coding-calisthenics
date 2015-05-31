package com.app.toss;

public class Toss {
	public void flips(int f) {
		if (f < 0) {
			System.out.println("error");

		}
		int head = 0;
		int tail = 0;
		int count = 0;
		for (int i = 0; i < f; i++) {
			if (Math.random() < 0.5) {
				head++;
			} else if (Math.random() > 0.5) {
				tail++;
			}
		}
		System.out.println("P(H) = " + (double) head / f);
		System.out.println("P(T) = " + (double) tail / f);
	}

	public int getHeadFlips(int f) {
		if (f <= 0) {
			return -1;
		}
		int head = 0;

		for (int i = 0; i < f; i++) {
			if (Math.random() < 0.5) {
				head++;
			}
		}
		return head;
	}

	public int getTailFlips(int f) {
		if (f <= 0) {
			return -1;
		}
		int tail = 0;

		for (int i = 0; i < f; i++) {
			if (Math.random() > 0.5) {
				tail++;
			}
		}
		return tail;

	}
}
