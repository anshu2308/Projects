package com.nagarro.training.InputOutput;

import java.io.File;

import java.io.FileReader;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nagarro.training.Model.Brand;
import com.nagarro.training.Model.Tshirt;
import com.nagarro.training.Utility.HibernateUtility;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class ReadDirectory {

	public void checkFiles() {
		String path = "Assigment Links";
		File[] files = new File(path).listFiles(obj -> obj.isFile() && obj.getName().endsWith(".csv"));
		for (File f : files) {
			try {
				readFiles(f);
			} catch (Exception e) {
				System.out.println("Not able to read the files");
			}
		}
	}

	public void readFiles(File f) throws Exception {
		CSVParser csvParser = new CSVParserBuilder().withSeparator('|').build();
		CSVReader lineReader = new CSVReaderBuilder(new FileReader(f)).withCSVParser(csvParser).withSkipLines(1)
				.build();
		@SuppressWarnings("unchecked")
		List<String[]> records = lineReader.readAll();
		Brand b = new Brand();
		b.setName(f.getName());

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		for (String[] record : records) {

			Tshirt tshirt = new Tshirt();
			tshirt.setId(record[0]);
			tshirt.setName(record[1]);
			tshirt.setColor(record[2]);
			tshirt.setGender(record[3]);
			tshirt.setSize(record[4]);
			tshirt.setPrice(Double.parseDouble(record[5]));
			tshirt.setRating(Double.parseDouble(record[6]));
			tshirt.setAvailability(record[7]);
			b.getTshirts().add(tshirt);
			tshirt.setBrand(b);
			session.save(b);

		}

		tx.commit();

	}
}
