package com.app.thread.producercons;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ProduceConsumerBQ {

	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new LinkedBlockingDeque<Integer>();
		ProducerBQ p = new ProducerBQ(queue);
		ConsumnerBQ cq = new ConsumnerBQ(queue);
		
		
	}

}
