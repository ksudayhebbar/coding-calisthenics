package com.app.queue;

public interface Queue<T> {
	public void add(T vale);

	public T remove();

}
