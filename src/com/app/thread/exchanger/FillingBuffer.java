package com.app.thread.exchanger;

import java.util.concurrent.Exchanger;

public class FillingBuffer implements Runnable {
	Exchanger<Buffer> fillingBuffer;
	Buffer buffer = new Buffer();

	public FillingBuffer(Exchanger<Buffer> fillingBuffer, Buffer buffer) {

		this.fillingBuffer = fillingBuffer;
		this.buffer = buffer;
		Thread t = new Thread(this, "fillingBuffer");
		t.start();
	}

	@Override
	public void run() {
		int i = 0;
		Buffer currentBuffer =buffer;
		while (i<=100) {
			buffer.add(++i);
			System.out.println("Added item " + i);
			if (buffer.isFull()) {
				try {
					currentBuffer = fillingBuffer.exchange(currentBuffer);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
			
		}

	}
}
