package dataStructures.stack;

import java.util.Scanner;

import dataStructures.linkedList.MyLinkedList;
import dataStructures.linkedList.PrintLinkedList;

public class StackDriver {
	public static void main(String args[]) {
		MyStack<Integer> stack = new MyStack<Integer>(5);
		PrintStack print = new PrintStack();
		Scanner scn = new Scanner(System.in);

		char ch = 'y';
		System.out.println("You can perform following operations on Stack :");
		while (ch != 'n' && ch != 'N') {
			System.out.println("\n1.Push\n2.Pop\n3.Peek\n4.Contains\n5.Size\n6.Center\n7.Sort\n8.Reverse\n9.Print");
			int choice = scn.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the number to insert");
				int data = scn.nextInt();
				stack.push(data);
				break;
			case 2:
				stack.pop();
				break;
			case 3:
				System.out.println(stack.peek());
				break;
			case 4:
				System.out.println("Enter the value");
				int value = scn.nextInt();
				stack.contains(value);
				break;
			case 5:
				System.out.println("Size of Stack is:" + stack.size());
				break;
			case 6:
				System.out.println("Center Element is " + stack.center());
				break;
			case 7:
				stack.sort();
				break;
			case 8:
				stack.reverse();
				break;
			case 9:
				print.print(stack);
				break;
			default:
				System.out.println("Enter a valid choice");
			}
			System.out.println("\n\nDo you want to continue(y/n):");
			ch = scn.next().charAt(0);

		}

	}
}
