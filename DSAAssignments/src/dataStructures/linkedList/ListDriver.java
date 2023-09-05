package dataStructures.linkedList;

import java.util.*;

public class ListDriver {
	public static void main(String args[]) {
		MyLinkedList<Integer> ll = new MyLinkedList<Integer>();
		PrintLinkedList print = new PrintLinkedList();
		Scanner scn = new Scanner(System.in);
		char ch = 'y';
		System.out.println("You can perform following operations on Linked List:");
		while (ch != 'n' && ch != 'N') {
			System.out.println(
					"\n1.Insert\n2.Insert At Index\n3.Delete\n4.Delete from Index\n5.Size\n6.Center\n7.Sort\n8.Reverse\n9.Print");
			int choice = scn.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the number to insert");
				int data = scn.nextInt();
				ll.insert(data);
				break;
			case 2:
				System.out.println("Enter the index:");
				int index = scn.nextInt();
				System.out.println("Enter number you want to insert at index " + index);
				int value = scn.nextInt();
				ll.insertAt(index, value);
				break;
			case 3:
				ll.delete();
				break;
			case 4:
				System.out.println("Enter the index from which you want to delete value");
				int dIndex = scn.nextInt();
				ll.deleteAt(dIndex);
				break;
			case 5:
				System.out.println("Size of Linked List is :" + ll.size());
				break;
			case 6:
				System.out.println("Center Element:" + ll.center());
				break;
			case 7:
				ll.sort();
				break;
			case 8:
				ll.reverse();
				break;
			case 9:
				print.print(ll);
				break;
			default:
				System.out.println("Enter a valid choice");
			}
			System.out.println("\n\nDo you want to continue(y/n):");
			ch = scn.next().charAt(0);

		}
//		ll.insert(22);
//		ll.insert(32);
//		ll.insert(234);
//		ll.insertAt(2, 1000);
//        ll.insert(300);
//        ll.print();
//        ll.sort();
//        ll.print();
		scn.close();
	}

}
