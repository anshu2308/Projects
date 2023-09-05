package com.nagarro.training.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.entity.SelledProduct;
import com.nagarro.training.service.SelledProductService;

@RestController
@RequestMapping("/sold")
@CrossOrigin("*")
public class SelledProductController {

	@Autowired
	private SelledProductService productService;

	@PostMapping("/")
	public SelledProduct addSold(@RequestBody SelledProduct product) {
		return this.productService.addsoldProduct(product);
	}
//
//	@GetMapping("/seller/{sid}")
//	public Set<SelledProduct> getProductBySeller(@PathVariable("sid") int id) {
//		return this.productService.getSoldProductBySellerId(id);
//	}

	@GetMapping("/customer/{cid}")
	public Set<SelledProduct> getProductByCustomer(@PathVariable("cid") int id) {
		return this.productService.getSoldProductByCustomerId(id);
	}
}
