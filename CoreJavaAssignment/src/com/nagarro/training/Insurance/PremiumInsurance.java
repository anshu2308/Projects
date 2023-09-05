package com.nagarro.training.Insurance;

public class PremiumInsurance extends BasicInsurance{
	
  public PremiumInsurance(double price,int percent)
	{
		super(price,percent);
	}
	
	public double calcAmount() {
		amount=super.calcAmount();
		amount+=amount/100*20;
		return amount;
	}
	

}
