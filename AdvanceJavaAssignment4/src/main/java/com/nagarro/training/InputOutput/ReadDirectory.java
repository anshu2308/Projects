package com.nagarro.training.InputOutput;

import java.io.File;
import java.io.FileReader;
import java.util.*;

import com.nagarro.training.Model.Tshirt;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class ReadDirectory {
	public List<Tshirt> checkFiles() {
		List<Tshirt> tshirtSet=new ArrayList<Tshirt>();
		String path = "C:\\Users\\anshukumari01\\eclipse-workspace\\AdvanceJava4\\Assigment Links";
		File[] files = new File(path).listFiles(obj -> obj.isFile() && obj.getName().endsWith(".csv"));
		for (File f : files) {
			try {
				CSVParser csvParser = new CSVParserBuilder().withSeparator('|').build();
				CSVReader lineReader = new CSVReaderBuilder(new FileReader(f)).withCSVParser(csvParser).withSkipLines(1)
						.build();
				
				List<String[]> records = lineReader.readAll();
				
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
                       tshirtSet.add(tshirt);
                        
				}
			} catch (Exception e) {
				System.out.println("Not able to read the files");
			}
		}
		   
		 return tshirtSet;
	}
  
}