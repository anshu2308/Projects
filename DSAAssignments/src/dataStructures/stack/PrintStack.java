package dataStructures.stack;

import java.util.Iterator;

import dataStructures.*;

public class PrintStack {
	public void print(MyStack obj) {
		if(obj.size()!=0) {
		System.out.println("Items in Stack are:");
		Iterator it = obj.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		}
		else
		{
			System.out.println("Stack is Empty...");
		}
	}
}
