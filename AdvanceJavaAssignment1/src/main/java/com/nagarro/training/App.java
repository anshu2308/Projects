package com.nagarro.training;

import java.io.BufferedReader;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.nagarro.training.CSVFileReader.CheckNewFiles;
import com.nagarro.training.CSVFileReader.FilesReader;
import com.nagarro.training.Inputs.GetInputFromUser;
import com.nagarro.training.Inputs.UserInput;

/**
 * Hello world!
 *
 */
public class App {
	public static HashMap<String, HashSet<Tshirt>> TshirtData = new HashMap<String, HashSet<Tshirt>>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Tshirt> result = new ArrayList<Tshirt>();
		char choice = 'x';
		FilesReader fr=new FilesReader();
		fr.readDirectory();
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(new CheckNewFiles(), 0, 3, TimeUnit.SECONDS);
		do {
		UserInput u = GetInputFromUser.input();
		
		result.clear();
		synchronized (App.TshirtData) {
			for (HashSet<Tshirt> set : TshirtData.values()) {
				for (Tshirt t : set) {
					
					if (t.getColor().equalsIgnoreCase(u.getColor()) && t.getSize().equalsIgnoreCase(u.getSize())
							&& t.getGender().equalsIgnoreCase(u.getGender())) {
						result.add(t);
						
					}
				}
			}
		}

     if(u.getPreference()==1)
    	 Collections.sort(result,new PriceComparator());
     else if(u.getPreference()==2)
    	  Collections.sort(result, new RatingComparator());
     else {
    	 Collections.sort(result,new PriceComparator());
     Collections.sort(result,new RatingComparator());
     }
		for (int i = 0; i < result.size(); i++) {
              
			System.out.println(result.get(i));
		}
		if(result.size()==0)
		{
			System.out.println("No such Item Found...");
		}
		service.shutdown();
		
		System.out.println("\n\nDo you want to continue(y/n):");
		choice=(char)br.read();
		br.readLine();
		
		while(choice!='n'&& choice!='N' && choice!='y' && choice!='Y') {
			System.out.println("Wrong Input. Enter Again(y/n)");
			choice=(char)br.read();
			br.readLine();
			
		}
	}while(choice=='y' || choice=='N');
		System.out.println("Existing...");
	}
}
