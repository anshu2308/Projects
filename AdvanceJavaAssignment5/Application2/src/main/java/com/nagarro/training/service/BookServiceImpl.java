package com.nagarro.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.BookDao;
import com.nagarro.training.entity.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	public BookServiceImpl() {
	}

	@Override
	public List<Book> getBooks() {
		return bookDao.findAll();

	}

	@Override
	public Book getBook(int id) {
		return bookDao.getOne(id);

	}

	@Override
	public Book addBook(Book b) {
		bookDao.save(b);
		return b;
	}

	@Override
	public Book updateBook(Book b) {
		bookDao.save(b);
		return b;
	}

	@Override
	public void deleteBook(int id) {
		Book b = bookDao.getOne(id);
		bookDao.delete(b);
	}

}
