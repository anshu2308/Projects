package com.nagarro.customer.entity;

import java.util.ArrayList;
import java.util.List;


public class Customer {
	private Long cusId;
	private String name;
	private String phone;
	private String address;
	
	List<Account> accounts = new ArrayList<>();
	
	public Customer(Long cusId, String name, String phone, String address, List<Account> accounts) {
		super();
		this.cusId = cusId;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.accounts = accounts;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public Long getCusId() {
		return cusId;
	}
	public void setCusId(Long cusId) {
		this.cusId = cusId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Customer() {
		super();
	}
	public Customer(Long cusId, String name, String phone, String address) {
		super();
		this.cusId = cusId;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	
	

}
