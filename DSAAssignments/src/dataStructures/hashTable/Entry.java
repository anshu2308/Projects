package dataStructures.hashTable;

public class Entry<T extends Comparable<T>> {
	int key;
	T value;
	Entry<T> next;

	public Entry(int key, T value2) {
		this.key = key;
		this.value = value2;
		next = null;
	}

	public Entry() {

		next = null;
	}

	public int GetKey() {

		return key;
	}

	public T GetValue() {
		return value;
	}
}