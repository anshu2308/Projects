package dataStructures.queue;

import java.util.Iterator;

import dataStructures.*;
import dataStructures.linkedList.Node;

public class MyQueue<T extends Comparable<T>> implements Iterable<T> {
	static int size;
	int maxSize = 0;
	Node<T> rear;
	Node<T> front;

	MyQueue(int size) {
		front = rear = null;
		maxSize = size;
		size = 0;
	}

	/**
	 * Insert element at Rear
	 * 
	 * @param data
	 */
	void enqueue(T data) {
		if (size == maxSize) {
			System.out.println("Queue is full...");
		} else {
			Node<T> node = new Node(data);
			if (front == null) {
				front = rear = node;
			}
			rear.next = node;
			rear = node;
			size++;
		}

	}

	/**
	 * Delete element from front
	 */
	void dequeue() {
		if (size == 0) {
			System.out.println("Queue is empty");
		} else {
			front = front.next;
			size--;
		}
	}

	/**
	 * 
	 * @return return front element
	 */
	public T peek() {
		return front.data;
	}

	/**
	 * Check the value is present in queue or not
	 * 
	 * @param value
	 */
	public void contains(T value) {
		Iterator<T> itr = iterator();
		while (itr.hasNext()) {
			if (itr.next().compareTo(value) == 0) {
				System.out.println("\"" + value + "\" is present in the stack");
				return;
			}
		}
		System.out.println("\"" + value + "\" is not present");
	}

	/**
	 * 
	 * @return Size of the queue
	 */
	int size() {
		return size;
	}

	/**
	 * Sort the queue
	 */
	public void sort() {
		for (int i = 0; i < size() - 1; i++) {
			Node<T> temp = front;
			Node<T> temp1 = temp.next;
			T obj;
			for (int j = 0; j < size() - i - 1; j++) {
				if (temp.data.compareTo(temp1.data) > 0) {
					obj = temp.data;
					temp.data = temp1.data;
					temp1.data = obj;
				}
				temp = temp1;
				temp1 = temp1.next;
			}
		}
		System.out.println("\nList is sorted...");
	}

	/**
	 * Reverse the queue
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
	 * @return Center Element
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
	 * iterator
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
