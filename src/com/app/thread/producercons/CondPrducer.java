package com.app.thread.producercons;

public class CondPrducer implements Runnable {
	private CondBlkQ cq;
	private Thread t;

	public CondPrducer(CondBlkQ cq) {
		this.cq = cq;
		this.t = new Thread(this, "Producer");
		this.t.start();
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			System.out.println(this.t.getName() + " produceing :  " + i);
			cq.put(i);
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
