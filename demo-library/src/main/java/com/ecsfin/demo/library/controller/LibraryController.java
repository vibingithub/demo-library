package com.ecsfin.demo.library.controller;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecsfin.demo.library.controller.model.Book;
import com.ecsfin.demo.library.controller.model.Books;

@RestController
@RequestMapping("/api/books")
public class LibraryController {
	
	private Books books = new Books(Arrays.asList(
			new Book("B1", "Quantum Physics", "Science", "English"),
			new Book("B2", "Truth", "Art", "English"),
			new Book("B3", "AI Knowledge", "Technology", "English"),
			new Book("B4", "Freedom", "History", "English"),
			new Book("B5", "Space", "Science", "English"),
			new Book("B6", "Probability", "Mathematics", "English"),
			new Book("B7", "Laughter", "Comis", "English"),
			new Book("B8", "Leap", "Art", "English")
			));
	
	@GetMapping
	public ResponseEntity<Books> getBooks(){
		return new ResponseEntity<Books>(books, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> getBook(@PathVariable String id){
		Optional<Book> opsBook = books.getBooks().stream()
					.filter(b->b.getBookId().equals(id))
					.findFirst();
		
		Book book = opsBook.get();
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
}
