package com.bookstore.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.books.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	public Book findBookByTitle(String title);

}
