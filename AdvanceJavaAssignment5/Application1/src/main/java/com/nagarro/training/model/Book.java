package com.nagarro.training.model;

import java.time.LocalDate;
import java.util.Date;

public class Book {

	int bCode;
	String bName;

	public Book(int bCode, String bName, String bAuthor,String addedDate) {
		super();
		this.bCode = bCode;
		this.bName = bName;
		this.bAuthor = bAuthor;
		this.addedDate = addedDate;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	String bAuthor;

	@Override
	public String toString() {
		return "Book [bCode=" + bCode + ", bName=" + bName + ", bAuthor=" + bAuthor + ", addedDate=" + addedDate + "]";
	}

	String addedDate;

	public int getbCode() {
		return bCode;
	}

	public void setbCode(int bCode) {
		this.bCode = bCode;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbAuthor() {
		return bAuthor;
	}

	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}

	public String getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(String addedDate) {
		this.addedDate = addedDate;
	}

}
