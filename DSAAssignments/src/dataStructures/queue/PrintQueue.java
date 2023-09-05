package dataStructures.queue;

import java.util.Iterator;

public class PrintQueue {

	public void print(MyQueue obj) {
		System.out.println("Items in Queue are:");
		Iterator it = obj.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}

	}
}
