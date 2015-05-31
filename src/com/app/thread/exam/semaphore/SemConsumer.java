package com.app.thread.exam.semaphore;

public class SemConsumer implements Runnable {

	private SemQ q;
	private Thread t;

	public SemConsumer(SemQ q) {
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
			/*try {
				this.t.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			i++;
			
		}
	}

}
