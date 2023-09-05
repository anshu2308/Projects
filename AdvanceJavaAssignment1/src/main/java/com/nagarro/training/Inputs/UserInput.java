package com.nagarro.training.Inputs;

import com.nagarro.training.Constants;

public class UserInput implements Constants {
	public UserInput(String color, String size, String gender, int preference) {
		super();
		this.color = color;
		this.size = size;
		this.gender = gender;
		this.preference = preference;
	}
	String color;
	String size;
	String gender;
	int preference;
	public String getColor() {
		return color;
	}
	public String getSize() {
		return size;
	}
	public String getGender() {
		return gender;
	}
	public int getPreference() {
		return preference;
	}
	@Override
	public String toString() {
		return "UserInput [color=" + color + ", size=" + size + ", gender=" + gender + ", preference=" + preference
				+ "]";
	}

}
