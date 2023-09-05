package dataStructures.linkedList;

import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>> implements Iterable<T> {
	Node<T> head;
	private int size;

	/**
	 * 
	 * @param data to insert
	 * 
	 */
	public void insert(T data) {
		Node<T> newNode = new Node<T>(data);

		if (head == null) {
			head = newNode;
		} else {
			Node<T> temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
		size++;
		System.out.println("Item inserted...");
	}

	/**
	 * 
	 * @param index to insert data
	 * @param data
	 */
	public void insertAt(int index, T data) {
		Node<T> newNode = new Node<T>(data);

		if (size() < index) {
			System.out.println("Can't insert element at index " + index);
		} else {
			if (index == 0) {
				newNode.next = head;
				head = newNode;
			} else {
				Node<T> temp = head;
				for (int i = 0; i < index - 1; i++) {
					temp = temp.next;
				}
				newNode.next = temp.next;
				temp.next = newNode;
			}
			size++;
			System.out.println("Item inserted...");
		}
	}

	/**
	 * delete last element
	 */
	public void delete() {
		Node<T> temp = head;
		if (size() == 1) {
			head = null;
			size--;
			return;
		}
		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
		size--;
	}

	/**
	 * 
	 * @param index to delete element
	 */
	public void deleteAt(int index) {
		if (size() < index) {
			System.out.println("Size of array is y" + size());
		} else {
			if (index == 0) {

				head = head.next;
			} else {
				Node<T> temp = head;
				for (int i = 0; i < index - 1; i++) {
					temp = temp.next;
				}
				temp.next = temp.next.next;
			}
			size--;
			System.out.println("Item deleted");
		}
	}

	/**
	 * 
	 * @return Size of Linked List
	 */
	public int size() {
		return size;
	}

	/**
	 * 
	 * @return Center Element
	 */
	public T center() {
		Node<T> temp = head;
		for (int i = 0; i < size() / 2 - 1; i++) {
			temp = temp.next;
		}
		if (size() % 2 == 0)
			return temp.data;
		else
			return temp.next.data;
	}

	/**
	 * Sort the list
	 */
	public void sort() {
		for (int i = 0; i < size() - 1; i++) {
			Node<T> temp = head;
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
		System.out.println("List is sorted...");
	}

	/**
	 * Reverse the List
	 */
	public void reverse() {
		Node<T> temp = head;
		Node<T> next = null;
		Node<T> prev = null;
		while (temp != null) {
			next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;

		}
		head = prev;
		System.out.println("List is reversed...");
	}

	/**
	 * @return Iterator
	 */

	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Node<T> temp = head;

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