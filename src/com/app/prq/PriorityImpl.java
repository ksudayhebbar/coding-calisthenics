package com.app.prq;

public class PriorityImpl<E> implements IPriorityQueue<E> {
	private Element<E> rootNode;
	private int size;

	public PriorityImpl() {
		this.size = 0;
	}

	@Override
	public boolean isEmpty() {

		return this.size != 0 ? false : true;
	}

	@Override
	public E getNext() {
		E value = null;
		if (rootNode.getPre() == null && rootNode.getNext() == null) {
			value = rootNode.getValue();
			size--;

		} else {

			Element<E> tempNode = rootNode;
			Element<E> cur = null;
			Element<E> pre = null;
			int lastserved = 1000000;
			while (tempNode != null) {
				if (tempNode.getPriority() <= lastserved) {
					pre = tempNode.getPre();
					cur = tempNode;

				}
				tempNode = tempNode.getNext();

			}
			if (cur != null) {
				value = cur.getValue();
				pre.setNext(cur.getNext());
				size--;
			}
		}
		return value;
	}

	@Override
	public boolean add(E value, int priority) {
		boolean baddFlag = false;
		if (rootNode != null) {
			Element<E> tempNode = rootNode;
			while (tempNode.getNext() != null) {
				tempNode = tempNode.getNext();
			}
			Element<E> newNode = new Element<E>();
			newNode.setValue(value);
			newNode.setPriority(priority);
			tempNode.setNext(newNode);
			newNode.setPre(tempNode);
			newNode.setNext(null);
			size++;

		} else {
			rootNode = new Element<E>();
			rootNode.setValue(value);
			rootNode.setPriority(priority);
			rootNode.setNext(null);
			rootNode.setPre(null);
			size++;

		}

		return baddFlag;
	}

	public void display() {

		Element<E> tempNode = rootNode;
		while (tempNode != null) {
			System.out.println("Value " + tempNode.getValue() + " Prioriy "
					+ tempNode.getPriority());
			tempNode = tempNode.getNext();
		}
	}

	private class Element<E> {
		private E value;
		private int priority;
		private Element<E> pre;
		private Element<E> next;

		public E getValue() {
			return value;
		}

		public void setValue(E value) {
			this.value = value;
		}

		public int getPriority() {
			return priority;
		}

		public void setPriority(int priority) {
			this.priority = priority;
		}

		public Element<E> getPre() {
			return pre;
		}

		public void setPre(Element<E> pre) {
			this.pre = pre;
		}

		public Element<E> getNext() {
			return next;
		}

		public void setNext(Element<E> next) {
			this.next = next;
		}

	}
}
