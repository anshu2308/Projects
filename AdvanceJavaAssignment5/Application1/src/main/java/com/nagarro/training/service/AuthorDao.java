package com.nagarro.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.nagarro.training.model.Author;

@Component
public class AuthorDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	 
	public List<Author> getAll() {

		List<Author> t = this.hibernateTemplate.loadAll(Author.class);
		return t;
	}
}
