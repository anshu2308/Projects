package com.nagarro.training.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Author {
	@Id
	int id;
	String name;

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + "]";
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
}
