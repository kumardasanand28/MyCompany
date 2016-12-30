package main.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.com.entity.Book;
import main.com.service.BookService;


@RestController
@RequestMapping(value = "/books")
public class BookController {

	@Autowired
	private BookService bookService;



	@RequestMapping(value = "/add/{id}/{name}/{author}/{price}")
	public Book addBook(@PathVariable int id, @PathVariable String name, @PathVariable String author,
			@PathVariable long price) {
		Book book = new Book();
		book.setId(id);
		book.setName(name);
		book.setAuthor(author);
		book.setPrice(price);
		bookService.saveBook(book);
		return book;
	}


	@RequestMapping(value = "/delete/{id}")
	public void deleteBook(@PathVariable int id) {
		Book book = new Book();
		book.setId(id);
		bookService.delete(id);
	}


	@RequestMapping(value = "")
	public List<Book> getBooks() {
		return bookService.findAll();
	}



	@RequestMapping(value = "/{id}")
	public Book getBook(@PathVariable int id) {
		Book book = bookService.findOne(id);
		return book;
	}

}
