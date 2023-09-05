package com.nagarro.training.InputOutput;

public class UserInput {
	String color;
	String size;
	String gender;
	int[] preference;

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

	public UserInput(String color, String size, String gender, int[] preference) {
		super();
		this.color = color;
		this.size = size;
		this.gender = gender;
		this.preference = preference;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int[] getPreference() {
		return preference;
	}

	public void setPreference(int[] preference) {
		this.preference = preference;
	}

}
