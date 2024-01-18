package com.api.book.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;

@Component
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBooks() // get all books
	{
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;
	}

	public Book getBookById(int id) // get book by id
	{
		Book book = null;
		try {
			book = this.bookRepository.findById(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return book;
	}

	public Book addBook(Book book) // add book
	{
		Book b = bookRepository.save(book);
		return b;
	}

	public void deleteBook(int id) // delete book
	{
		bookRepository.deleteById(id);
	}

	public void updateBook(Book book, int id) // update book
	{
		book.setId(id);
		bookRepository.save(book);
	}

}
