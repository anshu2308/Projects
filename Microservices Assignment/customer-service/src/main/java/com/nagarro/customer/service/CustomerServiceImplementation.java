package com.nagarro.customer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.customer.entity.Customer;

@Service
public class CustomerServiceImplementation implements CustomerService {

	List<Customer> customers=List.of(new Customer(2L,"Anshu KUmari","23487238423","Lucknow,India"),
			new Customer(3L,"Akash Gupta","2348722389423","Lucknow,India"),
			new Customer(4L,"Ananya Seth","234873288423","Lucknow,India")
			);
	
	@Override
	public Customer getCustomerById(Long cusId) {
		
		return customers.stream().filter(user -> user.getCusId().equals(cusId)).findAny().orElse(null);
	}
	
	@Override
	public List<Customer> getCustomers() {
		return customers;

}

	@Override
	public List<Customer> addCustomer(Customer c) {
		customers.add(c);
		return null;
	}

	@Override
	public Customer upateCustomer(Long cusId) {
		Customer customer=customers.stream().filter(user -> user.getCusId().equals(cusId)).findAny().orElse(null);
		customer.setName("changed");
		return customer;
	}


}