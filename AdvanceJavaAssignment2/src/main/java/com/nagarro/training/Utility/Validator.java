package com.nagarro.training.Utility;

import com.nagarro.training.Model.Size;

public class Validator {
  public static boolean sizeValidator(String size) {
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
 public static boolean genderValidator(String s) {
	  if(s.equalsIgnoreCase("M") || s.equalsIgnoreCase("F")){
		  return true;
	  }
	  System.out.println("Choose F(female)/M(Male):");
	  return false;
  }
}
