package com.nagarro.training.CSVFileReader;

import java.io.File;

import java.util.*;
//import java.nio.file.Files;

import com.nagarro.training.App;

public class CheckNewFiles implements Runnable{
	
	HashMap<String,Long> lastModifiedAt =new HashMap<String,Long>();
	
	public void run() {
		String path="C:\\Users\\anshukumari01\\OneDrive - Nagarro\\Desktop\\eclipse\\AdvanceJava\\Assigment Links";
    	File [] files = new File(path).listFiles(obj -> obj.isFile() && obj.getName().endsWith(".csv"));
    	   
		ArrayList<String> l=new ArrayList<String>();
		for(File f:files) {
			if((!(lastModifiedAt.containsKey(f.getName())))||(f.lastModified()>lastModifiedAt.get(f.getName())))
					{
				lastModifiedAt.put(f.getName(), f.lastModified());
				synchronized(App.TshirtData)
				{
					App.TshirtData.put(f.getName(), FilesReader.readFile(f));
					
				}
		
		}
			l.add(f.getName());
		}
			Set <String> fc=lastModifiedAt.keySet();
			Set <String> fname=new HashSet<String>();
			fname.addAll(fc);
			
		if(fc.size()==l.size())
			return;
		for(String string:fname) {
			if(!(l.contains(string))) {
				lastModifiedAt.remove(string);
				synchronized(App.TshirtData) {
					App.TshirtData.remove(string);
				}
				
			}
		}
	}
	
}
