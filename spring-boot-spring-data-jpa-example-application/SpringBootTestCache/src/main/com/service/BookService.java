package main.com.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import main.com.entity.Book;

public interface BookService {
	public List<Book> findAll();
	public void saveBook(Book book);
	public void delete(long id);
	
	
	@Cacheable("booksAuthor")
	public Book findOne(long id);
}
