package com.nagarro.customer.service;

import java.util.List;

import com.nagarro.customer.entity.Customer;

public interface CustomerService {
	public Customer  getCustomerById(Long userId);
	public List<Customer> getCustomers();
}
