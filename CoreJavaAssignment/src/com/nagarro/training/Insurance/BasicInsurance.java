package com.nagarro.training.Insurance;

public class BasicInsurance {
  protected double price;
  protected int percent;
  protected double amount;  
  
  public BasicInsurance(double price,int percent)
  {
	  this.price=price;
	  this.percent=percent;
  }
  
  public double calcAmount()
  {
	  amount=price/100*percent;
	  return amount;
  }
  
}
