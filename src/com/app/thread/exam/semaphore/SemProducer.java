package com.app.thread.exam.semaphore;

public class SemProducer implements Runnable {
	private SemQ q;
	private Thread t;

	public SemProducer(SemQ q) {
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
