package com.app.thread.producercons;


public class Consumer implements Runnable {

	private Q q;
	private Thread t;

	public Consumer(Q q) {
		super();
		this.q = q;
		t = new Thread(this, "Consumer");
		t.start();
	}

	@Override
	public void run() {
		int i = 1;
		while (i != 5) {
			System.out.println("Consumeing i " + q.get());
			i++;
		}
	}

}
