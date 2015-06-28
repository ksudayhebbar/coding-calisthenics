package com.app.queue;

import java.util.Optional;

public class QueueCImpl<T> implements Queue<T> {
	private static final int DEFAULT_SIZE = 16;
	private int front;
	private int rear;
	private T[] a;
	private int size;

	public QueueCImpl() {
		this.a = (T[]) new Object[DEFAULT_SIZE];
		this.front = 0;
		this.rear = 0;
		this.size = 0;
	}

	@Override
	public void add(T value) {
		if (Optional.ofNullable(value) != null) {
			this.a[rear++] = value;

		}

	}

	public int getSize() {
		this.size = front < rear ? rear - front : 0;
		return size;
	}

	@Override
	public T remove() {
		T value = null;
		value = this.a[front++];
		return value;
	}

	@Override
	public String toString() {

		return "";
	}

	public static void main(String[] args) {
		Queue<Integer> q = new QueueCImpl<Integer>();
		q.add(1);
		q.add(3);
		q.add(5);
		q.add(5);
		q.add(6);

		q.remove();

	}
}
