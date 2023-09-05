package com.nagarro.training.Utility;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.training.Model.Brand;
import com.nagarro.training.Model.Tshirt;

public class HibernateUtility {

	public static SessionFactory factory;

	private HibernateUtility() {
	}

	public static synchronized SessionFactory getSessionFactory() {

		if (factory == null) {
			factory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Tshirt.class).addAnnotatedClass(Brand.class).buildSessionFactory();
		}
		return factory;
	}
}