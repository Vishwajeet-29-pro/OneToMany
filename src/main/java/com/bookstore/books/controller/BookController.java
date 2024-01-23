package com.bookstore.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.books.entity.Book;
import com.bookstore.books.service.BookService;
import com.bookstore.books.service.CategoryService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/1.0/books")
public class BookController {

	
	private final BookService bookService;
	private final CategoryService categoryService;
	
	public BookController(BookService bookService, CategoryService categoryService) {
		this.bookService = bookService;
		this.categoryService = categoryService;
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveBook(@RequestBody Book bookDetails, @RequestParam("name") String name, HttpServletResponse response) {
		Book book = bookService.saveBook(bookDetails, name);
		String location = "api/1.0/book/"+book.getTitle();
		response.addHeader("Location", location);
	}
	
	@GetMapping("/")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@GetMapping("/id/{id}")
	public Book getBookDetailsById(@PathVariable int id) {
		return bookService.getBookById(id);
	}
	
	@GetMapping("/{name}")
	public Book getBookByTitle(@PathVariable String title) {
		return bookService.getBookByTitle(title);
	}
	
	@PutMapping("/updateById/{id}")
	public Book updateBookById(@PathVariable("id") int id, @RequestBody Book book) throws Exception {
		return bookService.updateById(id, book);
	}
	
	@PutMapping("/updateBookByTitle/{title}")
	public Book updateBookDetailsByTitle(@PathVariable("title") String title, @RequestBody Book book) throws Exception{
		return bookService.updateBookDetailsByTitle(title, book);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteBookById(@PathVariable("id") int id) {
		bookService.deleteBookById(id);
		Book book = bookService.getBookById(id);
		if(book != null) {
			return "Problem occur during delation of book";
		} else {
		return "Book with "+id+" deleted successfully";
		}
	}
	
	@DeleteMapping("/deleteBookByTitle/{title}")
	public String deleteBookDetailsByTitle(@PathVariable("title") String title) {
		bookService.deleteBookDetailsByTitle(title);
		Book book = bookService.getBookByTitle(title);
		if(book != null) {
			return "Problem occur during delation of book";
		} else {
		return "Book with "+title+" deleted successfully";
		}
	}
 }
