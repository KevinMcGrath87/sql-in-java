package com.kevin.sql.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.sql.models.Book;
import com.kevin.sql.services.BookService;

@RestController
public class BooksApi {
	private final BookService bookService;
	
	public BooksApi(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/api/books") 
	public List<Book> index() {
		return bookService.allBooks();
		
	}
	@RequestMapping( value = "/api/books", method = RequestMethod.POST)
	public Book create(@RequestParam(value = "title") String title, @RequestParam(value="description") String desc, @ RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
		Book newBook =new Book(title, desc, lang, numOfPages);
		
		return bookService.createBook(newBook);
	}
	@RequestMapping("/api/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		return book;
		
	}
	
	@RequestMapping(value = "/api/books/delete/{id}", method = RequestMethod.DELETE)
	public Long delete(@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		return bookService.deleteBook(book);
	}
	
	@RequestMapping(value ="/api/books/updateTitle/{id}", method = RequestMethod.PUT)
	public Book update(@PathVariable("id") Long id, @RequestParam(value="newTitle") String newTitle) {
		Book book = bookService.findBook(id);
		bookService.updateBookTitle(book,newTitle);
		return book;
	}

}
