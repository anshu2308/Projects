package com.nagarro.customer.entity;

public class Account {
    private String accNo;  
    private String ifsc;
 
	private Long cusId;  
    private String accType;  
    private long balance;  
    
    public Account(String accNo, String ifsc, Long cusId, String accType, long balance) {
 		super();
 		this.accNo = accNo;
 		this.ifsc = ifsc;
 		this.cusId = cusId;
 		this.accType = accType;
 		this.balance = balance;
 	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public Long getCusId() {
		return cusId;
	}

	public void setCusId(Long cusId) {
		this.cusId = cusId;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}
    
}
