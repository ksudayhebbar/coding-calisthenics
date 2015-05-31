package com.app.thread.evenodd;


public class OddProducer implements Runnable {
	private EvenOddGen evenOddGen;
	private Thread t;

	public OddProducer(EvenOddGen oddProducer) {
		this.evenOddGen = oddProducer;
		this.t = new Thread(this, "oddProducer");
		t.start();
	}

	@Override
	public void run() {
		int i = 1;
		while (i != 5) {
			System.out.println("get odd Number " + evenOddGen.getOddNumber());
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
