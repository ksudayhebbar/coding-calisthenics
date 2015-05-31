package com.app.thread.producercons;

public class Producer implements Runnable {
	private Q q;
	private Thread t;

	public Producer(Q q) {
		super();
		this.q = q;
		t = new Thread(this, "Proucer");
		t.start();
	}

	@Override
	public void run() {
		int i = 1;
		while (i != 5) {
			System.out.println(" Produce the i " + i);
			q.put(i);
			i++;
			try {
				this.t.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
