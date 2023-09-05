package com.nagarro.account.entity;

public class Account {
    private String accNo;  
    private String ifsc;
 
	private Long cusId;  
    private String accType;  
    private Long balance;  
    
    public Account(String accNo, String ifsc, Long cusId, String accType, Long balance) {
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

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}
    
}
