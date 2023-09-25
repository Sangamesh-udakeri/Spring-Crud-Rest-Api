package com.vdit.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vdit.entity.Book;
import com.vdit.service.BookService;

@RestController
public class BookController {

	BookService service;
	public BookController(	BookService service) {
		this.service=service;
	}
	@PostMapping(value = "/book", 
			consumes = { "application/json" },
			produces = { "application/json" })
	public ResponseEntity<String> addBook(@RequestBody Book book) {
		
		String s=service.addBook(book);
		
		return new ResponseEntity<String>(s, HttpStatus.OK);
	}
	
	@GetMapping(value = "/books"
			)
	public ResponseEntity<List<Book>> getBook(){
		List<Book> allBooks = service.getAllBooks();
		
		return new ResponseEntity<List<Book>>(allBooks,HttpStatus.OK);
	}
	@PutMapping("/putbook")
	public ResponseEntity<String> updateBook(Book book){
		ResponseEntity<String> addBook = this.addBook(book);
		
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@DeleteMapping("deleteBook/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable  Integer id){
		
		String deleteBook = service.deleteBook(id);
		
		return new ResponseEntity<String>(deleteBook,HttpStatus.OK);
	}
}
