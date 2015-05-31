package com.app.thread.evenodd;

public class EvenProducer implements Runnable {
	private EvenOddGen evenOddGen;
	private Thread t;

	public EvenProducer(EvenOddGen evenProducer) {
		this.evenOddGen = evenProducer;
		this.t = new Thread(this, "EvenProducer");
		t.start();
	}

	@Override
	public void run() {
		int i = 1;
		while (i != 5) {
			System.out.println("get Even Number " + evenOddGen.getEvenNumber());
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
