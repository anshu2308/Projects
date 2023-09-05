package com.nagarro.customer.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagarro.customer.entity.Customer;
import com.nagarro.customer.service.CustomerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/{custId}")
//	@HystrixCommand(fallbackMethod="getFallbackCatalog")
	public Customer getCustomer(@PathVariable("custId") Long id) {
		Customer customer=this.customerService.getCustomerById(id);
		List accounts=this.restTemplate.getForObject("http://account-service/account/customer/"+id, List.class);
		customer.setAccounts(accounts);
		return customer;
	}

	@GetMapping("/add")
	public List<Customer> addCustomer(Customer customer){
		return customerService.addCustomer(customer);
	
	}
	
	@GetMapping("/edit/{custId}")
	public Customer editCustomer(@PathVariable("custId")Long cusId) {
		 return  customerService.upateCustomer(cusId);
	
	}
	@GetMapping("/all")
	public List<Customer> getAllCustomers(){
		return customerService.getCustomers();
	}
}
