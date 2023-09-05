package com.nagarro.training.Model;

public class UserInput {
	@Override
	public String toString() {
		return "UserInput [color=" + color + ", size=" + size + ", gender=" + gender + ", preference=" + preference
				+ "]";
	}

	String color;
	String size;
	String gender;
	String preference;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getGender() {
		return gender;
	}

	public UserInput(String color, String size, String gender, String preference) {
		super();
		this.color = color;
		this.size = size;
		this.gender = gender;
		this.preference = preference;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}

	public UserInput() {
		super();
		// TODO Auto-generated constructor stub
	}

}
