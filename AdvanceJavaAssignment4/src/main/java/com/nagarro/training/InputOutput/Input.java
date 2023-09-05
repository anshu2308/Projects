package com.nagarro.training.InputOutput;

import com.nagarro.training.Model.UserInput;

public class Input {
  public static String checkValid(UserInput u) {
	  
	  
	  if(u.getSize().equals("NONE") || u.getGender()==null || u.getPreference()==null )
	     return "invalid";
	  
	  return "valid";
  }
}
