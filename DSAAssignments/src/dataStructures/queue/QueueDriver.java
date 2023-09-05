package dataStructures.queue;

import java.util.Scanner;

import dataStructures.stack.MyStack;
import dataStructures.stack.PrintStack;

public class QueueDriver {
	public static void main(String args[]) {
		MyQueue<Integer> queue = new MyQueue<Integer>(5);
		PrintQueue print = new PrintQueue();
		Scanner scn = new Scanner(System.in);

		char ch = 'y';
		System.out.println("You can perform following operations on queue :");
		while (ch != 'n' && ch != 'N') {
			System.out.println(
					"\n1.Enqueue\n2.Dequeue\n3.Peek\n4.Contains\n5.Size\n6.Center\n7.Sort\n8.Reverse\n9.Print");
			int choice = scn.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the number to insert");
				int data = scn.nextInt();
				queue.enqueue(data);
				break;
			case 2:
				queue.dequeue();
				break;
			case 3:
				System.out.println(queue.peek());
				break;
			case 4:
				System.out.println("Enter the value");
				int value = scn.nextInt();
				queue.contains(value);
				break;
			case 5:
				System.out.println("Size of Queue is"+queue.size());
				break;
			case 6:
				System.out.println("Center Element is:"+queue.center());
				break;
			case 7:
				queue.sort();
				break;
			case 8:
				queue.reverse();
				break;
			case 9:
				print.print(queue);
				break;
			default:
				System.out.println("Enter a valid choice");
			}
			System.out.println("\n\nDo you want to continue(y/n):");
			ch = scn.next().charAt(0);

		}
	}
}
