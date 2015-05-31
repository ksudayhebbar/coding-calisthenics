package com.app.thread.producercons;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class CondBlkQ {
	private static final int MAX = 10;
	private BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<Integer>();
	private boolean bFlag = false;

	public BlockingQueue<Integer> getBlockingQueue() {
		return blockingQueue;
	}

	public boolean isbFlag() {
		return bFlag;
	}

	public synchronized void put(int i) {

		try {
			while (bFlag) {
				try {

					wait();

				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
			if (!bFlag && blockingQueue.size() < MAX) {
				blockingQueue.put(i);
				if (blockingQueue.size() == MAX) {
					bFlag = true;
					notifyAll();
				}

			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public synchronized int get() {

		int i = 0;
		try {
			while (!bFlag) {
				try {
					wait();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
			if (bFlag && blockingQueue.size() != 0) {
				i = blockingQueue.take();
				if (blockingQueue.size() == 0) {
					bFlag = false;
					notifyAll();
				}

			}

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		return i;
	}
}
