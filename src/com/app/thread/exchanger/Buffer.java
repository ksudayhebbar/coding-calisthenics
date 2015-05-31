package com.app.thread.exchanger;

import java.util.LinkedList;
import java.util.List;

public class Buffer {
	private static final int MAX = 10;
	List<Integer> lit = new LinkedList<Integer>();

	public synchronized void add(int i)  {
		while(isFull()){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notifyAll();
		if (!isFull()) {
			lit.add(i);
		}
	}

	public synchronized int remove() {
		while(isEmpty()){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notifyAll();
		if (!isEmpty()) {
			return lit.remove(0);
		}
		return 0;
	}

	public synchronized boolean isEmpty() {

		return lit.size() == 0;
 
	}

	public synchronized boolean isFull() {
		
		if (lit.size() == MAX) {
			return true;
		}
		return false;
	}
}
