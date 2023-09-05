package com.nagarro.customer.service;

import java.util.List;

import com.nagarro.customer.entity.Customer;

public interface CustomerService {
	public Customer  getCustomerById(Long cusId);
	public List<Customer> getCustomers();
	public List<Customer> addCustomer(Customer c);
	public Customer upateCustomer(Long cusId);
}
