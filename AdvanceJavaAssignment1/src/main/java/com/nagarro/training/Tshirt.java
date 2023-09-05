package com.nagarro.training;

public class Tshirt implements Constants{
	
	String ID;
	String name;
	String color;
	String gender;
	String size;
	float price;
	float rating;
	String availability;
	
	public Tshirt(String iD, String name, String color, String gender, String size, float price, float rating,
			String availability) {
		super();
		ID = iD;
		this.name = name;
		this.color = color;
		this.gender = gender;
		this.size = size;
		this.price = price;
		this.rating = rating;
		this.availability = availability;
	}
    public Tshirt() {
    	
    }
	public String getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public String getGender() {
		return gender;
	}

	public String getSize() {
		return size;
	}

	public float getPrice() {
		return price;
	}

	public float getRating() {
		return rating;
	}

	public String getAvailability() {
		return availability;
	}

	@Override
	public String toString() {
		return "Tshirt [ID=" + ID + ", name=" + name + ", color=" + color + ", gender=" + gender + ", size=" + size
				+ ", price=" + price + ", rating=" + rating + ", availability=" + availability + "]";
	}

//	public void setID(String iD) {
//		ID = iD;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public void setColor(String color) {
//		this.color = color;
//	}
//
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
//
//	public void setSize(String size) {
//		this.size = size;
//	}
//
//	public void setPrice(String price) {
//		this.price = price;
//	}
//
//	public void setRating(String rating) {
//		this.rating = rating;
//	}
//
//	public void setAvailability(String availability) {
//		this.availability = availability;
//	}

	
	

}
