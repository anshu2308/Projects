package com.nagarro.training.service;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.nagarro.training.Comparator.PriceComparator;
import com.nagarro.training.Comparator.RatingComparator;
import com.nagarro.training.InputOutput.ReadDirectory;
import com.nagarro.training.Model.Tshirt;
import com.nagarro.training.Model.UserInput;

@Component
public class TshirtDao {
	@Autowired
	HibernateTemplate hibernateTemplate;

	@Transactional
	public void save() {
		ReadDirectory rd = new ReadDirectory();
		List<Tshirt> list = rd.checkFiles();

		for (Tshirt t : list)
			this.hibernateTemplate.save(t);

	}

	public List<Tshirt> getAll() {
		List<Tshirt> t = this.hibernateTemplate.loadAll(Tshirt.class);
		System.out.println(t.size() );
		return t;
	}

	public List<Tshirt> search(UserInput u) {
		List<Tshirt> availableTshirts = this.hibernateTemplate.loadAll(Tshirt.class);
		System.out.println(u);
		List<Tshirt> result = new ArrayList<Tshirt>();
		for (Tshirt t : availableTshirts) {
			if (t.getColor().equalsIgnoreCase(u.getColor()) && t.getSize().equalsIgnoreCase(u.getSize())
					&& t.getGender().equalsIgnoreCase(u.getGender())) {
				result.add(t);
			}
		}

		if (u.getPreference().equals("Rating")) {
			Collections.sort(result, new RatingComparator());

		} else if (u.getPreference().equals("Price")) {
			Collections.sort(result, new PriceComparator());

		} else {
			Collections.sort(result, new RatingComparator());
			Collections.sort(result, new PriceComparator());

		}

		return result;

	}
}
