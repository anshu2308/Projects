package com.nagarro.training.service;

import java.util.List;

import com.nagarro.training.entity.Book;

public interface BookService {
 
	public List<Book> getBooks();
	
	public Book getBook(int id);
	
	public Book addBook(Book b);

	public Book updateBook(Book b);
	
	public void deleteBook(int id);
}
