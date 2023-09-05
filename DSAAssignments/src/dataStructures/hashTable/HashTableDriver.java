package dataStructures.hashTable;

import java.util.Scanner;

public class HashTableDriver {
	public static void main(String args[]) {
		MyHashTable<String> hashtable = new MyHashTable<String>();
		Scanner scn = new Scanner(System.in);

		char ch = 'y';
		System.out.println("You can perform following operations on Hash Table :");
		while (ch != 'n' && ch != 'N') {
			System.out.println("\n1.Insert\n2.Delete\n3.Get Value by key\n4.Size\n5.Print");
			int choice = scn.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the key and String:");
				int key = scn.nextInt();
				String data = scn.nextLine();
				hashtable.put(key, data);
				break;
			case 2:
				System.out.println("Enter the key you want to delete:");
				int deleteKey = scn.nextInt();
				hashtable.delete(deleteKey);
				break;
			case 3:
				System.out.println("Enter the key of value:");
				int vKey = scn.nextInt();
				System.out.println(hashtable.get(vKey));
				break;
			case 4:
				System.out.println(hashtable.size());
				break;
			case 5:
				hashtable.print();
				break;

			default:
				System.out.println("Enter a valid choice");
			}
			System.out.println("\n\nDo you want to continue(y/n):");
			ch = scn.next().charAt(0);

		}
	}
}
