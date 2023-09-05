package com.nagarro.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.entity.Category;
import com.nagarro.training.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/")
	public Category addCategory(@RequestBody Category category) {
		return this.categoryService.addCategory(category);
	}

	@GetMapping("/")
	public ResponseEntity<?> getAllCategories() {
		return ResponseEntity.ok(this.categoryService.getCategories());
	}

	@GetMapping("/{categoryId}")
	public Category getCategoryById(@PathVariable("categoryId") Long id) {
		return this.categoryService.getCategory(id);
	}

	@PutMapping("/")
	public Category updatecategory(Category category) {
		return this.categoryService.updateCategory(category);
	}

	@DeleteMapping("/{categoryId}")
	public void deleteCategory(@PathVariable("categoryId") Long id) {
		this.categoryService.deleteCategory(id);
	}
}