package com.nagarro.training;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;

import com.nagarro.training.Comparator.*;
import com.nagarro.training.InputOutput.ReadDirectory;
import com.nagarro.training.InputOutput.User;
import com.nagarro.training.InputOutput.UserInput;

import com.nagarro.training.Model.Tshirt;
import com.nagarro.training.Utility.HibernateUtility;

public class App {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char choice = 'y';

		ReadDirectory r = new ReadDirectory();
		r.checkFiles();

		do {
			User user = new User();
			UserInput u = user.getInput();

			List<Tshirt> result = new ArrayList<Tshirt>();

			SessionFactory factory = HibernateUtility.getSessionFactory();
			Session session = factory.openSession();
			session.beginTransaction();

			Query query = session.createQuery("from Tshirt");
			@SuppressWarnings("unchecked")
			List<Tshirt> tshirtList = query.list();
//			session.getTransaction().commit();

			for (Tshirt t : tshirtList) {
				if (t.getColor().equalsIgnoreCase(u.getColor()) && t.getSize().equalsIgnoreCase(u.getSize())
						&& t.getGender().equalsIgnoreCase(u.getGender())) {
					result.add(t);
				}
			}

			if (u.getPreference() == 1)
				Collections.sort(result, new PriceComparator());
			else if (u.getPreference() == 2)
				Collections.sort(result, new RatingComparator());
			else {
				Collections.sort(result, new RatingComparator());
				Collections.sort(result, new PriceComparator());
			}
			if (result.size() == 0) {
				System.out.println("No such Item Found...");
			} else {
				result.forEach(System.out::println);
			}
			System.out.println("\n\nDo you want to continue(y/n):");
			choice = (char) br.read();
			br.readLine();

			while (choice != 'n' && choice != 'N' && choice != 'y' && choice != 'Y') {
				System.out.println("Wrong Input. Enter Again(y/n)");
				choice = (char) br.read();
				br.readLine();

			}
		} while (choice == 'y' || choice == 'N');
		System.out.println("Existing...");
	}
}
