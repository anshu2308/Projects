package com.nagarro.training.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nagarro.training.entity.Products;
import com.nagarro.training.entity.SelledProduct;
import com.nagarro.training.service.ProductService;
import com.nagarro.training.service.SelledProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	SelledProductService selledProductService;

	@PostMapping(value = { "/" }, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public Products createProduct(@RequestPart("product") Products p, @RequestPart("image") MultipartFile file)
			throws Exception {

		p.setImage(file.getBytes());
		return this.productService.addProducts(p);
	}

	@PutMapping("/")
	public Products updateProducts(@RequestBody Products products) {
		return this.productService.updateProduct(products);
	}

	@GetMapping("/")
	public Set<Products> getAllProducts() {
		return this.productService.getProducts();
	}

	@GetMapping("/{productId}")
	public Products getProductById(@PathVariable("productId") int id) {
		return this.productService.getProductById(id);
	}

	@DeleteMapping("/{productId}")
	public void deleteProduct(@PathVariable("productId") int id) {
		this.productService.deleteProduct(id);
	}

//
//	@GetMapping("/{category}")
//	public Set<Products> getAllProducts(@PathVariable("category") String category) {
//		return this.productService.getProductByCategory(category);
//	}
	@PostMapping("/sold")
	public SelledProduct addSold(@RequestBody SelledProduct product) {
		return this.selledProductService.addsoldProduct(product);
	}

}
