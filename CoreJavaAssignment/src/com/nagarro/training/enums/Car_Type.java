package com.nagarro.training.enums;

//Valid Car types
public enum Car_Type {
	   Hatchback(5), Sedan(8), SUV(10);
		 
	  int percent;
		
		Car_Type(int n)
		{
			percent=n;
		}
		
		public int getPercent()
		{
			return percent;
		}
	}

