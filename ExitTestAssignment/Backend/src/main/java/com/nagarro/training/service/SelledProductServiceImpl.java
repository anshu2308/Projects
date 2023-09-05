package com.nagarro.training.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.entity.SelledProduct;
import com.nagarro.training.repo.SelledProductRepository;

@Service
public class SelledProductServiceImpl implements SelledProductService {

	@Autowired
	private SelledProductRepository selledProduct;

	@Override
	public SelledProduct addsoldProduct(SelledProduct product) {
		return this.selledProduct.save(product);
	}

	@Override
	public SelledProduct getsoldProductByProductId(Long id) {
		return this.selledProduct.findById(id).get();
	}

//	@Override
//	public Set<SelledProduct> getSoldProductBySellerId(int id) {
//		return this.selledProduct.findAllBySellerId(id);
//	}

	@Override
	public Set<SelledProduct> getSoldProductByCustomerId(int id) {

		return this.selledProduct.findAllByCustomerId(id);
	}

}
