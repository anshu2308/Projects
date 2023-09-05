package com.nagarro.training.InputOutput;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.nagarro.training.Model.Tshirt;

public class CheckNewFiles implements Runnable{

	@Autowired
	  HibernateTemplate hibernateTemplate;
	public void run() {
		List<Tshirt> tshirtList=this.hibernateTemplate.loadAll(Tshirt.class);
		ReadDirectory rd=new ReadDirectory();
		List<Tshirt> newtshirt=new ArrayList<Tshirt>();
		try {
			newtshirt=rd.checkFiles();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Tshirt t:newtshirt) {
			if(!tshirtList.contains(t)) {
				this.hibernateTemplate.save(t);
			}
		}
		System.out.println(":Anshu");
	}
}
