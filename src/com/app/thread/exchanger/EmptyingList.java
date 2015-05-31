package com.app.thread.exchanger;

import java.util.concurrent.Exchanger;

public class EmptyingList implements Runnable {
	Exchanger<Buffer> emptyBuffer;
	Buffer buffer;

	public EmptyingList(Exchanger<Buffer> emptyBuffer, Buffer buffer) {

		this.emptyBuffer = emptyBuffer;
		this.buffer = buffer;
		Thread t = new Thread(this, "Emtying List");
		t.start();
	}

	@Override
	public void run() {
		int i=0;
		Buffer currentBuffer =buffer;
		while (i<=100) {
			System.out.println("Removed item from buffer " + buffer.remove());
			i++;
			if (buffer.isEmpty()) {
				try {
					currentBuffer = emptyBuffer.exchange(currentBuffer);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
			

		}

	}
}
