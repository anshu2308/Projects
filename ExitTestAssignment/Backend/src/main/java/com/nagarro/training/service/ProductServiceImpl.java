package com.nagarro.training.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.entity.Products;
import com.nagarro.training.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Override
	public Products addProducts(Products products) throws Exception {
		Products p = this.productRepo.findBypName(products.getpName());
		if (p == null) {
			products.setPrice();
			return this.productRepo.save(products);
		} else {
			throw new Exception("Product already present!!!");

		}
	}

	@Override
	public Products updateProduct(Products products) {
		products.setPrice();
		return this.productRepo.save(products);
	}

	@Override
	public Set<Products> getProducts() {

		return new HashSet<>(this.productRepo.findAll());
	}

	@Override
	public Products getProductById(int id) {
		return this.productRepo.findById(id).get();
	}

	@Override
	public void deleteProduct(int id) {

		this.productRepo.deleteById(id);

	}

//	@Override
//	public Set<Products> getProductByCategory(String category) {
//		return this.productRepo.findAllByName(category);
//	}
}
