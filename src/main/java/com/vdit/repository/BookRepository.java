package com.vdit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vdit.entity.Book;

public interface BookRepository  extends JpaRepository<Book, Serializable>{

	
}
