package com.vdit.service;

import java.util.List;

import com.vdit.entity.Book;

public interface BookService {

	public String addBook(Book book);
	
	public List<Book> getAllBooks();
	
	
	public String  deleteBook(Integer id);
}
