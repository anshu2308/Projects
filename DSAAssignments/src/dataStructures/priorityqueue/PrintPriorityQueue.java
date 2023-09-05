package dataStructures.priorityqueue;

import java.util.Iterator;

public class PrintPriorityQueue {
	public void print(MyPriorityQueue obj) {
		System.out.println("Items in Queue are:");
		Iterator it = obj.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}

	}
}
