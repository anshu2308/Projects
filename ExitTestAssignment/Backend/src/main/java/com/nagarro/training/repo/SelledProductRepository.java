package com.nagarro.training.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.training.entity.SelledProduct;

public interface SelledProductRepository extends JpaRepository<SelledProduct, Long> {

	public Set<SelledProduct> findAllByCustomerId(int id);

//	public Set<SelledProduct> findAllBySellerId(int id);

}
