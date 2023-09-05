package com.nagarro.training;

import java.util.Scanner;
import com.nagarro.training.Insurance.*;

public class Main {
	
	static String model;
	static String type;
	static double price;
	static int ins_type;
	static int percent;
	static double amount;
	static char ch='y';
   public static void main(String args[])
   {
	   Cars car=new Cars();
	  
	   try {
	   model=args[0];
	   type=args[1];
	   percent=car.checkInsurancePercent(type);
	   price=Double.parseDouble(args[2]);
	   ins_type=Integer.parseInt(args[3]);
	    insuranceAmount();
	    printDetails();
	   }
	   catch(Exception e) {}
	   finally {
		   getValuesFromUser();
	   }
   } 
   
   static void getValuesFromUser() {
	   Scanner scn=new Scanner (System.in);
	   Cars car=new Cars();
	   
	   
	   if(ch=='y' || ch=='Y') {
		   percent=0;
		   
		   System.out.println("---Enter Your Car details-----\n"); 
		   System.out.println("Car Model:");
		   model=scn.nextLine();
		   
		   while(percent==0)
		   {
		    System.out.println("Type:");
		    type=scn.nextLine();
		    percent=car.checkInsurancePercent(type);
		   }
		   
		  
		   System.out.println("Price:");
		    price=scn.nextDouble();
		   
		   do {
			   System.out.println("Choose the Insurance Type:\n1.Basic\n2.Premium");
			   ins_type=scn.nextInt();
			   }while(ins_type!=1 && ins_type!=2);
		   
		   insuranceAmount();
		   printDetails();
		  	
	   }
   }
  
   
   static void insuranceAmount()
   {
	   if(ins_type==1){
		   BasicInsurance bIns=new BasicInsurance(price,percent);
		  amount= bIns.calcAmount();
	   }
	   else if(ins_type==2){
		   PremiumInsurance pIns=new PremiumInsurance(price,percent);
		   amount=pIns.calcAmount();
	   }
	
   }
  
   
   public static void printDetails()
   {
	   Scanner s=new Scanner (System.in);
	      System.out.println("\n------- THE CAR INSURANCE DETAILS ARE---------");
		  System.out.println("CAR MODEL         : "+ model);
		  System.out.println("CAR PRICE         : "+ price);
		  System.out.printf("Amount to be paid : %.02f", amount);
		  System.out.println("\n\nDo you want to enter details of any other car (y/n):");
			ch = s.nextLine().charAt(0);	
			if(ch=='y' || ch=='Y')
				getValuesFromUser();

   }
}

