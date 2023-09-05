package com.nagarro.training.Utility;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nagarro.training.Entity.Products;

public class ValidUser {
  public static Session fetch(String user,String pass) {
	  System.out.println(user+" "+pass);
	  Session session=HibernateUtility.getSessionFactory().openSession();
	 
	 TypedQuery<Products> q=session.createQuery("from User where name=:user and password=:pass");
	 q.setParameter("user", user);
	 q.setParameter("pass", pass);
	 
	 List<Products> list=q.getResultList();

	 if(list.size()==1)
		 return session;
	 
	 
	  return null;
  }
}
