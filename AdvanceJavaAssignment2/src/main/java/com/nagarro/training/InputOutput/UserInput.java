package com.nagarro.training.InputOutput;

public class UserInput {
	String color;
	String size;
	String Gender;
	int Preference;

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
		return Gender;
	}

	public UserInput(String color, String size, String gender, int preference) {
		super();
		this.color = color;
		this.size = size;
		Gender = gender;
		Preference = preference;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public int getPreference() {
		return Preference;
	}

	public void setPreference(int preference) {
		Preference = preference;
	}

}
