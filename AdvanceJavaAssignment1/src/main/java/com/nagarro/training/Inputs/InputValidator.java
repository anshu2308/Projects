package com.nagarro.training.Inputs;

import com.nagarro.training.Enum.Gender;
import com.nagarro.training.Enum.Size;

public class InputValidator {
   public static boolean validateSize(String size) {
	  
	   Size[] s=Size.values();
	   for(int i=0;i<s.length;i++)
	   {
		   if(s[i].toString().equalsIgnoreCase(size)) {
			   return true;
		   }
	   }
	   System.out.println("Wrong Input! Choose between S/M/L/XL/XXL:");
	   return false;
   }
   
   public static boolean validateGender(String gender) {
		  
	   Gender[] g=Gender.values();
	   for(int i=0;i<g.length;i++)
	   {
		   if(g[i].toString().equalsIgnoreCase(gender)) {
			   return true;
		   }
	   }
	   System.out.println("Wrong Input! Choose M(Male)/F(Female):");
	   return false;
   }
}
