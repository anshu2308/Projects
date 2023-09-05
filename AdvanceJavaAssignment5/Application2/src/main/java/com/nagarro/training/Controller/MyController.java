package com.nagarro.training.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.entity.Book;
import com.nagarro.training.service.BookService;

@RestController
public class MyController {
	
	@Autowired
   private BookService bookservice;
   

	
	@GetMapping("/books")
	public List<Book> getBooks(){
		return this.bookservice.getBooks();
		
	}
	
	@GetMapping("/books/{bookId}")
	public Book getBook(@PathVariable int bookId) {
		
		return this.bookservice.getBook(bookId);
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book b) {
		return this.bookservice.addBook(b);
	}
	
	@PutMapping("/books")
	public Book updateBook(@RequestBody Book b) {
		return this.bookservice.updateBook(b);
	}
	
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable int bookId) {
		this.bookservice.deleteBook(bookId);
	
	}
}
