package dataStructures.priorityqueue;

import java.util.Scanner;

public class PriorityQueueDriver {
	public static void main(String args[]) {
		MyPriorityQueue<Integer> queue = new MyPriorityQueue<Integer>(5);
		PrintPriorityQueue print = new PrintPriorityQueue();
		Scanner scn = new Scanner(System.in);

		char ch = 'y';
		System.out.println("You can perform following operations on queue :");
		while (ch != 'n' && ch != 'N') {
			System.out.println("\n1.Enqueue\n2.Dequeue\n3.Peek\n4.Contains\n5.Size\n6.Reverse\n7.Center\n8.Print");
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
				System.out.println(queue.size());
				break;
			case 6:
				queue.reverse();
				break;
			case 7:
				System.out.println(queue.center());
				break;
			case 8:
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
