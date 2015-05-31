package com.app.thread.exchanger;

import java.util.concurrent.Exchanger;

public class MainBufferExchange {
	public static void main(String[] args) {
		Exchanger<Buffer> exchanger = new Exchanger<Buffer>();
		Buffer b = new Buffer();
		new FillingBuffer(exchanger, b);
		new EmptyingList(exchanger, b);

	}
}
