
package dataStructures.priorityqueue;

import java.util.Iterator;

import dataStructures.linkedList.Node;
import dataStructures.queue.MyQueue;

public class MyPriorityQueue<T extends Comparable<T>> implements Iterable<T> {
	static int size;
	int maxSize = 0;
	Node<T> rear;
	Node<T> front;

	MyPriorityQueue(int size) {
		front = rear = null;
		maxSize = size;
		size = 0;
	}

	/**
	 * Insert element at Rear
	 * 
	 * @param data to insert
	 */
	void enqueue(T data) {
		if (size == maxSize) {
			System.out.println("Queue is full...");
		} else {
			Node<T> node = new Node(data);
			if (front == null) {
				front = rear = node;
			} else {
				rear.next = node;
				rear = node;
				sort();
			}
			size++;
			System.out.println("Item inserted...");
		}

	}

	/**
	 * delete front Element
	 */
	void dequeue() {
		if (size == 0) {
			System.out.println("Queue is empty");
		} else {
			front = front.next;
			size--;
			System.out.println("Item deleted...");
		}
	}

	/**
	 * 
	 * @return Element at front
	 */
	public T peek() {
		return front.data;
	}

	/**
	 * 
	 * @param value to check in queue
	 */
	public void contains(T value) {
		Node<T> itr = front;

		while (itr != null) {
			if (itr.data.compareTo(value) == 0) {
				System.out.println("\"" + value + "\" is present in the stack");
				return;
			}
			itr = itr.next;
		}
		System.out.println("\"" + value + "\" is not present");
	}

	int size() {
		return size;
	}

	/**
	 * sort the Queue
	 */
	public void sort() {
		for (int i = 0; i < size(); i++) {
			Node<T> temp = front;
			Node<T> temp1 = temp.next;
			T obj;
			for (int j = 0; j < size() - i; j++) {
				if (temp.data.compareTo(temp1.data) < 0) {
					obj = temp.data;
					temp.data = temp1.data;
					temp1.data = obj;
				}
				temp = temp1;
				temp1 = temp1.next;
			}
		}

	}

	/**
	 * reverse the Queue
	 */
	void reverse() {
		Node temp = front;
		Node next = null;
		Node prev = null;
		while (temp != null) {
			next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;

		}
		rear = front;
		front = prev;
		System.out.println("List is reversed...");

	}

	/**
	 * 
	 * @return Center element
	 */
	public T center() {
		Node<T> temp = front;
		for (int i = 0; i < size() / 2 - 1; i++) {
			temp = temp.next;
		}
		if (size() % 2 == 0)
			return temp.data;
		else
			return temp.next.data;
	}

	/**
	 * @return iterator
	 */
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Node<T> temp = front;

			public boolean hasNext() {
				return temp != null;
			}

			public T next() {
				T data = temp.data;
				temp = temp.next;
				return data;
			}
		};
	}

}