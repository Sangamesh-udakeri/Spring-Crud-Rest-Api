package com.vdit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vdit.entity.Book;
import com.vdit.repository.BookRepository;
@Service
public class BookServiceImpl implements BookService{

	private BookRepository bookRepository;
	
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
	}
	@Override
	public String addBook(Book book) {
		
		Book save = bookRepository.save(book);
		
		if(book.getBookId()==null) {
			return "record inserted!!";
		}
		return "record updated!!";
	}

	@Override
	public List<Book> getAllBooks() {
		
		
		return bookRepository.findAll();
	}

	@Override
	public String deleteBook(Integer id) {
		bookRepository.deleteById(id);
		return "deleted";
	}

}
