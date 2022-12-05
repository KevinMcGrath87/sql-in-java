package com.kevin.sql.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kevin.sql.models.Book;
import com.kevin.sql.repositories.BookRepository;

@Service

//a class.. for BookService not an interface... loaded with methods for queries etc.?
public class BookService {
	private final BookRepository bookRepository;
	
	
	public BookService (BookRepository bookRepository) {
		this.bookRepository = bookRepository;
		}	
	
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}
	
	public Long deleteBook(Book b) {
		Long id = b.getId();
		bookRepository.delete(b);
		return id;
	}
	public Long updateBookTitle(Book b, String newTitle) {
		Long id = b.getId();
		b.setTitle(newTitle);
		bookRepository.save(b);
		return id;
	}
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}
		else {
			return null;
		}
	}

}
