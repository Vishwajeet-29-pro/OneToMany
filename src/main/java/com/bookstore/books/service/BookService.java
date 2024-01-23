package com.bookstore.books.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.books.entity.Book;
import com.bookstore.books.entity.Categories;
import com.bookstore.books.repository.BookRepository;
import com.bookstore.books.repository.CategoryRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired 
	private CategoryRepository categoryRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	
	public Book saveBook(Book bookDetails, String name) {
		Categories categories = categoryRepository.findByName(name);
		if(categories!=null) {
		bookDetails.setCategories(categories);
		return bookRepository.save(bookDetails);
	}else {
		return null;
	}
	}
	
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	public Book getBookById(int id) {
		return bookRepository.getReferenceById(id);
	}
	
	public Book getBookByTitle(String title) {
		
		return bookRepository.findBookByTitle(title);
	}
	
	public Book updateById(int id, Book book) throws Exception  {
		
		Book bookDetails = bookRepository.getReferenceById(id);
		
		bookDetails.setAuthor(book.getAuthor());
		bookDetails.setPrice(book.getPrice());
		bookDetails.setQuantity(book.getQuantity());
		bookDetails.setTitle(book.getTitle());
		try {
		return bookRepository.save(bookDetails);
		} catch(Exception e) {
			throw new SQLException(e);
		}
	}
	
	public Book updateBookDetailsByTitle(String title, Book book) throws Exception {
		Book bookDetails = bookRepository.findBookByTitle(title);
		
		bookDetails.setAuthor(book.getAuthor());
		bookDetails.setPrice(book.getPrice());
		bookDetails.setQuantity(book.getQuantity());
		bookDetails.setTitle(book.getTitle());
		try {
		return bookRepository.save(bookDetails);
		} catch(Exception e) {
			throw new SQLException(e);
		}
	}
	
	public void deleteBookById(int id) {
		Book book = bookRepository.getReferenceById(id);
		if(book==null) {
			throw new RuntimeException("Book with "+id+" not found");
		}
		bookRepository.delete(book);
	}
	
	public void deleteBookDetailsByTitle(String title) {
		Book book = bookRepository.findBookByTitle(title);
		if(book==null) {
			throw new RuntimeException("Book with "+title+" not found");
		}
		bookRepository.delete(book);
	}
}
