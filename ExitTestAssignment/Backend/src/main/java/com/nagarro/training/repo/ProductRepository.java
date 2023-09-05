package com.nagarro.training.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.training.entity.Products;

public interface ProductRepository extends JpaRepository<Products, Integer> {

	public Products findBypName(String name);
//	public Set<Products> findAllByName(String category);
}
