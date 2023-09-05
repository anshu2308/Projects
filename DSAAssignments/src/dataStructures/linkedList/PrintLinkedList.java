package dataStructures.linkedList;

import java.util.Iterator;

public class PrintLinkedList {
	public void print(MyLinkedList obj) {
		if (obj.size() == 0) {
			System.out.println("List is empty.");
			return;
		}
		System.out.println("Items in Linked List are:");
		Iterator it = obj.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}

	}

}
