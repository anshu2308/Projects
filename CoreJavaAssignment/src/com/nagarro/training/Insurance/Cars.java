package com.nagarro.training.Insurance;

import com.nagarro.training.exceptions.*;
import com.nagarro.training.enums.*;


public class Cars {
    public int checkInsurancePercent(String car)
    {
    		  Car_Type[] cartype = Car_Type.values();
    			 try {
    				  for (Car_Type c : cartype) {
    					   if (c.toString().equalsIgnoreCase(car))
    						   return c.getPercent();
    				    }
    				   throw new ValueNotFoundException("***Invalid Car Type***\n");
    			     }
    			 catch (ValueNotFoundException e) {
    					System.out.println(e.getMessage());
    					return 0;
    				}
    			   
    		  
    	  
    }
}
