package com.nagarro.training.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Brand {

	@Id
	@GeneratedValue
	int id;
	@Column(unique = true)
	String name;

	@OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
	List<Tshirt> tshirts = new ArrayList<Tshirt>();

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

	public List<Tshirt> getTshirts() {
		return tshirts;
	}

	public void setTshirts(List<Tshirt> tshirts) {
		this.tshirts = tshirts;
	}

}
