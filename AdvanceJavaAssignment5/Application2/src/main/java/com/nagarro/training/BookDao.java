package com.nagarro.training;



import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.training.entity.Book;

public interface BookDao extends JpaRepository<Book,Integer>{

 
  
	
}
