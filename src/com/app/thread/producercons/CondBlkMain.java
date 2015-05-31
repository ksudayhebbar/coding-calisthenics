package com.app.thread.producercons;

public class CondBlkMain {

	public static void main(String[] args) {
		CondBlkQ q = new CondBlkQ();
		new CondPrducer(q);
		new CondConsumer(q);
		
		
	}

}
