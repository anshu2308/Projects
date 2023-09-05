package com.nagarro.training.InputOutput;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import com.nagarro.training.Utility.Validator;

public class User {
	public UserInput getInput() throws Exception {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		String color, gender, size;
		int preference;

		System.out.println("Enter Color");
		color = read.readLine();
		System.out.println("Enter Size");
		while (true) {
			size = read.readLine();
			boolean validSize = Validator.sizeValidator(size);
			if (validSize == true)
				break;
		}

		System.out.println("Enter Gender");
		while (true) {
			gender = read.readLine();
			boolean validGender = Validator.genderValidator(gender);
			if (validGender == true)
				break;
		}

		System.out.println("Select Ouput Preferrence:\n1.Price\n2.Rating\n3.Both");
		preference = Integer.parseInt(read.readLine());

		return new UserInput(color, size, gender, preference);

	}
}
