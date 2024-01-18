package com.api.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entities.Book;
import com.api.book.services.BookService;

@RestController
public class BookController {

	@Autowired
	public BookService bookService;

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() // get all books
	{
		List<Book> list = this.bookService.getAllBooks();
		if (list.size() <= 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		System.out.println(list);
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}

	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) // get book by id
	{
		Book book = bookService.getBookById(id);
		if (book == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.of(Optional.of(book));
	}

//	@GetMapping("/book")
//	public Book getBook()
//	{
//		Book book = new Book(11, "title", "author");
//		return book;
//	}

	@PostMapping("/addbook")
	public ResponseEntity<Book> addBook(@RequestBody Book book) // add book
	{
		Book b = null;
		try {
			b = this.bookService.addBook(book);
//			System.out.println(book);
			return ResponseEntity.of(Optional.of(b));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@DeleteMapping("/deletebook/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) // delete book
	{
		try {
			this.bookService.deleteBook(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/updatebook/{id}")
	public ResponseEntity<Book> UpdateBook(@PathVariable("id") int id, @RequestBody Book book) // update book
	{
		try {
			this.bookService.updateBook(book, id);
			return ResponseEntity.ok().body(book);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
