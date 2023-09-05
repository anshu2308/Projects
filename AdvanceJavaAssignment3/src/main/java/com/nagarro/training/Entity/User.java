package com.nagarro.training.Entity;

import java.util.List;


import javax.persistence.*;

@Entity
public class User {
 
	@Id
	private int id;
	private String name;
	private String password;
	public User() {
		
	}
	@OneToMany(mappedBy="user_id")
	private List<Products> productID;
	
	
	
	public User(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		
		this.password = password;
	}

	public List<Products> getProductID() {
		return productID;
	}

	public void setProductID(List<Products> productID) {
		this.productID = productID;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
