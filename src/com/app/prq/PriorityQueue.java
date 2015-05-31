package com.app.prq;

public class PriorityQueue {
	public Element rootNode;
	private int size = 0;

	public void offer(int value, int priority) {
		if (rootNode != null) {
			Element temNode = rootNode;
			while (temNode.getNext() != null) {
				temNode = temNode.getNext();
			}

			Element t = new Element();
			t.setValue(value);
			t.setPriority(priority);
			t.setNext(null);
			temNode.setNext(t);
			size++;
		} else {
			rootNode = new Element();
			rootNode.setValue(value);
			rootNode.setPriority(priority);
			rootNode.setNext(null);
			size++;
		}
	}

	public int peek(int priorty) throws Exception {
		int value = 0;
		if (rootNode == null) {
			throw new Exception("Empty list");
		}

		Element temNode = rootNode;
		Element pre = null;
		while (temNode != null) {
			if (temNode.getPriority() == priorty)
				break;
			pre = temNode;
			temNode = temNode.getNext();
		}
		if (temNode != null) {
			value = temNode.getValue();
			pre.setNext(temNode.getNext());
			size--;
		}
		return value;

	}

	public int getSize() {
		return size;
	}

	private class Element {
		private int value;
		int priority;
		private Element next;

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public int getPriority() {
			return priority;
		}

		public void setPriority(int priority) {
			this.priority = priority;
		}

		public Element getNext() {
			return next;
		}

		public void setNext(Element next) {
			this.next = next;
		}
	}
}
