//package com.api.book.services;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.stereotype.Component;
//
//import com.api.book.entities.Book;
//
//@Component
//public class BookService2 {
//
//	private static List<Book> list = new ArrayList<>();
//
//	static {
////		list.add(new Book(1, "t1", "a1"));
////		list.add(new Book(2, "t2", "a2"));
////		list.add(new Book(3, "t3", "a3"));
////		list.add(new Book(4, "t4", "a4"));
//	}
//
//	public List<Book> getAllBooks() // get all books
//	{
//		return list;
//	}
//
//	public Book getBookById(int id) // get book by id
//	{
////		for (Book book : list) {
////			if (book.getId() == id) {
////				return book;
////			}
////		}
////		return null;
//		Book book = null;
//		try {
//			book = list.stream().filter(e -> e.getId() == id).findFirst().get();
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return book;
//	}
//
//	public Book addBook(Book book) // add book
//	{
//		list.add(book);
//		return book;
//	}
//
//	public void deleteBook(int id) // delete book
//	{
////		for (int i = 0; i < list.size(); i++) {
////            Book book = list.get(i);
////            if (book.getId() == id) {
////                list.remove(i);
////            }
////		}
//		list = list.stream().filter(book -> book.getId() != id).collect(Collectors.toList());
//
//	}
//
//	public void updateBook(Book book, int id) // update book
//	{
//		list = list.stream().map(b -> {
//			if (b.getId() == id) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
//	}
//
//}
