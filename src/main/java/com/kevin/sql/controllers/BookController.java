package com.kevin.sql.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kevin.sql.models.Book;
import com.kevin.sql.services.BookService;

@Controller
public class BookController {
	private final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/books/{id}")
	public String index(Model model, @PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "index.jsp";
	}
	
	@GetMapping("/books")
	public String allBooks(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		
		return "allBooks.jsp";
	}

}
