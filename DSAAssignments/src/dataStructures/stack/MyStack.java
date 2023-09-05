package dataStructures.stack;

import java.util.*;

import dataStructures.*;
import dataStructures.linkedList.*;

public class MyStack<T extends Comparable<T>> implements Iterable<T> {
	Node<T> top;
	static int size;
	int maxSize;

	MyStack(int s) {
		this.top = null;
		maxSize = s;
	}

	/**
	 * Push value at top
	 * 
	 * @param value
	 */
	public void push(T value) {
		Node<T> newNode = new Node<T>(value);
		if (size() == maxSize) {
			System.out.println("Stack Overflow...");
			return;
		}
		newNode.next = top;
		top = newNode;
		size++;
		System.out.println("Item inserted...");

	}

	/**
	 * Pop value from the top
	 */
	public void pop() {
		if (top == null) {
			System.out.println("Stack underflow...");
			return;
		} else {
			System.out.println(peek() + " is popped...");
			top = top.next;
			size--;

		}
	}

	/**
	 * 
	 * @return top elements
	 */
	public T peek() {
		return top.data;
	}

	/**
	 * Check the value present in stack or not
	 * 
	 * @param value
	 */
	public void contains(T value) {
		Iterator<T> itr = iterator();
		while (itr.hasNext()) {
			if (itr.next() == value) {
				System.out.println("\"" + value + "\" is present in the stack");
				return;
			}
		}
		System.out.println("\"" + value + "\" is not present");
	}

	/**
	 * @return iterator
	 */
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Node<T> temp = top;

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

	/**
	 * 
	 * @return Size of the stack
	 */
	public int size() {
		return size;
	}

	/**
	 * 
	 * @return Center Element
	 */
	public T center() {
		Node<T> temp = top;
		for (int i = 0; i < size() / 2 - 1; i++) {
			temp = temp.next;
		}
		if (size() % 2 == 0)
			return temp.data;
		else
			return temp.next.data;
	}

	/**
	 * Sort the stack
	 */
	public void sort() {
		for (int i = 0; i < size() - 1; i++) {
			Node<T> temp = top;
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
	 * reverse the stack
	 */
	public void reverse() {
		Node<T> temp = top;
		Node<T> next = null;
		Node<T> prev = null;
		while (temp != null) {
			next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;

		}
		top = prev;
		System.out.println("List is reversed...");
	}
}
