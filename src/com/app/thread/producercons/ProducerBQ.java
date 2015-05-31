package com.app.thread.producercons;

import java.util.concurrent.BlockingQueue;

public class ProducerBQ implements Runnable {
	private BlockingQueue<Integer> q;
	private Thread thread;

	public ProducerBQ(BlockingQueue<Integer> q) {
		this.q = q;
		this.thread = new Thread(this, "ProducerBQ");

		this.thread.start();
	}

	@Override
	public void run() {

		int i = 0;
		while (true) {

			try {
				System.out.println(thread.getName() + " produceing " + i);
				q.put(i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			i++;
		}

	}
}
