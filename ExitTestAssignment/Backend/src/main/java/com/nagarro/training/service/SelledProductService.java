package com.nagarro.training.service;

import java.util.Set;

import com.nagarro.training.entity.SelledProduct;

public interface SelledProductService {

	public SelledProduct addsoldProduct(SelledProduct product);

	public SelledProduct getsoldProductByProductId(Long id);

//	public Set<SelledProduct> getSoldProductBySellerId(int id);

	public Set<SelledProduct> getSoldProductByCustomerId(int id);

}
