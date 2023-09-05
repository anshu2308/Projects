package com.nagarro.training.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.entity.Category;
import com.nagarro.training.repo.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public Category addCategory(Category category) {
		System.out.println("saving1");
		return this.categoryRepo.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return this.categoryRepo.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		return new LinkedHashSet<>(this.categoryRepo.findAll());
	}

	@Override
	public Category getCategory(Long id) {
		return this.categoryRepo.findById(id).get();
	}

	@Override
	public void deleteCategory(Long id) {

		this.categoryRepo.deleteById(id);
	}

}
