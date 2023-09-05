package com.nagarro.training.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.nagarro.training.model.User;

@Component
public class userDao {


	@Autowired
	HibernateTemplate hibernateTemplate;
	 
	@Transactional
	public void save(User u) {
	this.hibernateTemplate.save(u);
	}
	
	public List<User> getAll() {

		List<User> t = this.hibernateTemplate.loadAll(User.class);
		return t;
	}
}
