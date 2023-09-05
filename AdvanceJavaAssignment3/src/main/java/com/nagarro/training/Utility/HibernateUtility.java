package com.nagarro.training.Utility;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.training.Entity.Products;
import com.nagarro.training.Entity.User;



public class HibernateUtility {

	public static SessionFactory factory;

	private HibernateUtility() {
	}

	public static synchronized SessionFactory getSessionFactory() {

		if (factory == null) {
			factory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(User.class).addAnnotatedClass(Products.class).buildSessionFactory();
		}
		return factory;
	}
}