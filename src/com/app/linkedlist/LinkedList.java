package com.app.linkedlist;

public class LinkedList<T> {
	public Element<T> rootNode;
	private int size = 0;

	public void add(T value) {
		if (rootNode != null) {
			Element<T> temNode = rootNode;

			while (temNode.getNext() != null) {
				temNode = temNode.getNext();
			}

			Element<T> t = new Element<T>();
			t.setValue(value);
			t.setNext(null);
			temNode.setNext(t);
			size++;
		} else {
			rootNode = new Element<T>();
			rootNode.setValue(value);
			rootNode.setNext(null);
			size++;
		}
	}

	public void add(T value, int index) {
		if (rootNode != null) {
			if (index > 1 && index < size) {
				Element<T> temNode = rootNode;
				for (int i = 1; i < index; i++) {
					temNode = temNode.getNext();
				}

				Element<T> t = new Element<T>();
				t.setValue(value);
				t.setNext(temNode.getNext());
				temNode.setNext(t);
				size++;
			}
		} else {
			rootNode = new Element<T>();
			rootNode.setValue(value);
			rootNode.setNext(null);
			size++;
		}
	}

	public void display() {
		Element<T> temNode = rootNode;
		while (temNode != null) {
			System.out.println(temNode.getValue());
			temNode = temNode.getNext();
		}

	}

	public void reverse() {
		Element<T> tempNode = rootNode;
		Element<T> next = null;
		while (rootNode != null) {
			tempNode = tempNode.getNext();
			rootNode.setNext(next);
		    next = rootNode;
			rootNode = tempNode;

		}
		rootNode = next;
	}

	public T remove() throws Exception {
		T value;
		if (rootNode == null) {
			throw new Exception("Empty list");
		} else {
			Element<T> temNode = rootNode;
			value = temNode.getValue();
			rootNode = rootNode.getNext();
			size--;
		}
		return value;

	}

	public boolean remove(int index) throws Exception {
		if (rootNode == null) {
			throw new Exception("Empty list");
		}
		if (index > 1 && index < size) {
			Element<T> temNode = rootNode;
			for (int i = 1; i < index; i++) {
				if (temNode.getNext() == null)
					return false;

				temNode = temNode.getNext();
			}
			temNode.setNext(temNode.getNext().getNext());
			size--;
			return true;
		} else {
			return false;
		}

	}

	public int getSize() {
		return size;
	}

	private class Element<T> {
		private T value;
		private Element<T> next;

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public Element<T> getNext() {
			return next;
		}

		public void setNext(Element<T> next) {
			this.next = next;
		}
	}

	public static void main(String[] args) throws Exception {
		LinkedList<Integer> ln = new LinkedList<Integer>();
		ln.add(10);
		ln.add(11);
		ln.add(12);
		ln.add(13);
		ln.add(14);
		ln.add(15);
		/*System.out.println("Size" + ln.getSize());
		ln.display();
		System.out.println("Deleted item " + ln.remove(2));
		System.out.println("Size " + ln.getSize());
		System.out.println("Deleted item " + ln.remove());
		System.out.println("Size " + ln.getSize());*/
		ln.reverse();
		ln.display();
	}

}
