package com.app.thread.producercons;

public class CondConsumer implements Runnable {
	private CondBlkQ cq;
	private Thread t;

	public CondConsumer(CondBlkQ cq) {
		this.cq = cq;
		this.t = new Thread(this, "Consumer ");
		this.t.start();
	}

	@Override
	public void run() {
		while (true) {

			System.out.println(t.getName() + " Consuming :" + cq.get());

		}
	}

}
