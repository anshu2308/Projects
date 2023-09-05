 package com.nagarro.training;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public class TodoDao {
	@Autowired
  HibernateTemplate hibernateTemplate;
	
	@Transactional
  public int save(User t) {
		Integer i=(Integer)this.hibernateTemplate.save(t);
		return i;
	}
  
  public List<User> getAll(){
	  List<User> list=this.hibernateTemplate.loadAll(User.class);
      return list;
  }
}
