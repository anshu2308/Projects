package com.nagarro.training.Model;

import javax.persistence.*;

@Entity
public class Tshirt {

	@Id
	String Id;
	String name;
	String color;
	String gender;
	String size;
	double price;
	double rating;
	String availability;
	@ManyToOne
	Brand brand;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Brand getBrand() {
		return brand;
	}

	@Override
	public String toString() {
		return "Tshirt [Id=" + Id + ", name=" + name + ", color=" + color + ", gender=" + gender + ", size=" + size
				+ ", price=" + price + ", rating=" + rating + ", availability=" + availability + "]";
	}
}
