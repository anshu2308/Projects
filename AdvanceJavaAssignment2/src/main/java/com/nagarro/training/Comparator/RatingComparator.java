package com.nagarro.training.Comparator;

import java.util.Comparator;

import com.nagarro.training.Model.Tshirt;

public class RatingComparator implements Comparator<Tshirt> {

	public int compare(Tshirt a, Tshirt b) {
		Double x = a.getRating() - b.getRating();
		if (x > 0)
			return -1;
		else if (x < 0)
			return 1;
		else
			return 0;
	}
}
