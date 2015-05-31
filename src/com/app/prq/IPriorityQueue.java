package com.app.prq;

public interface IPriorityQueue<E> {
	public boolean isEmpty();

	public E getNext();

	public boolean add(E value, int priority);

}
