package com.nagarro.training.service;

import java.util.Set;

import com.nagarro.training.entity.Products;

public interface ProductService {
	// creating user
	public Products addProducts(Products products) throws Exception;

	public Products updateProduct(Products products);

	public Set<Products> getProducts();

	public Products getProductById(int id);

	public void deleteProduct(int id);

//	public Set<Products> getProductByCategory(String category);
}
