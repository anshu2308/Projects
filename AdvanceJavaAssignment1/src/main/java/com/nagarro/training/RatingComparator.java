package com.nagarro.training;

import java.util.Comparator;

public class RatingComparator implements Comparator<Tshirt> {
	public int compare(Tshirt a, Tshirt b) {
		float x=a.getRating()-b.getRating();
		if(x>0)
			return-1;
		else if(x<0)
			return 1;
		else
			return 0;
	}
   
}
