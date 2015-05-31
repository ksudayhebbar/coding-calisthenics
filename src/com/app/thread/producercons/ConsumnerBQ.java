package com.app.thread.producercons;

import java.util.concurrent.BlockingQueue;

public class ConsumnerBQ implements Runnable {
	private BlockingQueue<Integer> q;
	private Thread thread;

	public ConsumnerBQ(BlockingQueue<Integer> q) {
		this.q = q;
		this.thread = new Thread(this, "ConsumnerBQ");

		this.thread.start();
	}

	@Override
	public void run() {
		while (true) {
			try {

				System.out.println(thread.getName() + " Consumeing "
						+ this.q.take());

				Thread.sleep(1000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
