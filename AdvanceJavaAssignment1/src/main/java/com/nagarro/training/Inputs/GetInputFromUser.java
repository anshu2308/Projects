package com.nagarro.training.Inputs;

import java.io.*;

public class GetInputFromUser  {
	
	public static UserInput input() throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	String color,size,gender;
	int outputPreference;
	
//	System.out.println("WELCOME ");
	
	System.out.println("\nEnter color:");
	color=br.readLine();
    
	System.out.println("Enter Size:");
	while(true) {
	size=br.readLine();
	boolean validSize=InputValidator.validateSize(size);
	if(validSize==true)
		break;
	}
     
	
	System.out.println("Enter Gender");
	while(true) {
	gender=br.readLine();
	boolean validGender=InputValidator.validateGender(gender);
	if(validGender==true)
		break;
	}
	
	System.out.println("Select Ouput Preferrence:\n1.Price\n2.Rating\n3.Both");
	outputPreference=Integer.parseInt(br.readLine());
	
	 return new UserInput(color,size,gender,outputPreference);
	}

}
