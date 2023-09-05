package com.nagarro.training.CSVFileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.StringTokenizer;

import com.nagarro.training.App;
import com.nagarro.training.Tshirt;

public class FilesReader {
	
	public static void readDirectory()
	{
    	HashSet<Tshirt> tshirt=null ;
    	String path="C:\\Users\\anshukumari01\\OneDrive - Nagarro\\Desktop\\eclipse\\AdvanceJava\\Assigment Links";
    	File [] files = new File(path).listFiles(obj -> obj.isFile() && obj.getName().endsWith(".csv"));
    	   for(int i=0;i<files.length;i++)
    	   {
    		 
    		   tshirt=readFile(files[i]);
    	     synchronized(App.TshirtData) {
    	    	 App.TshirtData.put(files[i].getName(),tshirt);
    	     }
    	   }
        
  
    }
    
    public static HashSet<Tshirt>  readFile(File f) {
    	
    	HashSet<Tshirt> tshirt=new HashSet<Tshirt>();
  	  String line="";
  	  
  	  try (  BufferedReader reader=new BufferedReader(new FileReader(f))){
  		     line=reader.readLine();
  		     line=reader.readLine();
  		   
  		     
  		  while(line!=null) {
  			Tshirt t=manipulateLine(line);
  			line=reader.readLine();
  			  tshirt.add(t);
  		  }
  	  }
  	  catch(Exception e){
  		  e.printStackTrace();
  	  }
  	 return tshirt;
   }
    
    private static Tshirt manipulateLine(String line) {
    	
    	StringTokenizer st=new StringTokenizer(line,"|");
    
    	String ID=st.nextToken();
    	String name=st.nextToken();
    	String color=st.nextToken();
    	String gender=st.nextToken();
    	String size=st.nextToken();
    	float price=Float.parseFloat(st.nextToken());
    	float rating=Float.parseFloat(st.nextToken());

    	String availability=st.nextToken();
		return new Tshirt(ID,name,color,gender,size,price,rating,availability);
    	
    	
    	
    }
}
