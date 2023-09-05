package dataStructures.hashTable;

import java.util.*;

public class MyHashTable<T extends Comparable<T>> {
	Entry[] arrayHash;
	int size = 10;
	static int nItems = 0;

	public MyHashTable() {

		arrayHash = new Entry[size];
		for (int i = 0; i < size; i++) {
			arrayHash[i] = new Entry();
		}
	}

	/**
	 * 
	 * @param key
	 * @return Hash Value
	 */
	int getHash(int key) {
		return key % size;
	}

	/**
	 * 
	 * @param key
	 * @param value associated with key
	 */
	public void put(int key, T value) {

		int hashIndex = getHash(key);

		Entry ArrayValue = arrayHash[hashIndex];
		Entry newItem = new Entry(key, value);
		if (ArrayValue != null) {
			newItem.next = ArrayValue.next;
			ArrayValue.next = newItem;
		} else {
			arrayHash[hashIndex] = newItem;

		}
		nItems++;
	}

	/**
	 * 
	 * @param key
	 * @return Value associated with key
	 */
	public T get(int key) {
		T value = null;
		int hashIndex = getHash(key);
		Entry ArrayValue = arrayHash[hashIndex];
		while (ArrayValue != null) {
			if (ArrayValue.GetKey() == key) {
				value = (T) ArrayValue.GetValue();
				return value;
			}
			ArrayValue = ArrayValue.next;

		}

		return null;
	}

	/**
	 * 
	 * @param key
	 * 
	 *            Delete Element with this key
	 */
	public void delete(int key) {
		int hashIndex = getHash(key);
		Entry temp = arrayHash[hashIndex];
		while (temp != null) {
			if (temp.next.GetKey() == key) {
				temp.next = temp.next.next;
				nItems--;
				System.out.println("Deleted");
				return;
			} else
				temp = temp.next;
		}

	}

	/**
	 * Prints Hash Table
	 */
	public void print() {

		for (int i = 0; i < size; i++) {

			Entry temp = arrayHash[i];
			while (temp != null) {
				if (temp.GetValue() != null)
					System.out.println(temp.GetKey() + "=>" + temp.GetValue());

				temp = temp.next;
			}
		}
	}

	/**
	 * 
	 * @return Size of Hash Table
	 */
	int size() {
		return nItems;
	}

}
