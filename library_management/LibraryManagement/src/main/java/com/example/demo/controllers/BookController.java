package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.BookDto;
import com.example.demo.sevices.BookService;
import com.example.demo.dtos.TransactionDto;
import com.example.demo.entites.Book;


@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class BookController {
	
	
	@Autowired
	private BookService bookService;
	
	
	@PostMapping("/book")
	public void createNewBook(@RequestBody BookDto bookDto) {
		this.bookService.createBook(bookDto);
	}
	
	@GetMapping("/book/{id}")
	public BookDto getById(@PathVariable("id") int id) {
		return this.bookService.getById(id);
	}
	
	@GetMapping("/book")
    public List<BookDto> getAllBooks(){
		return this.bookService.getAll();
    	
    }
	
	@PutMapping("/book/{id}")
	public void updateBook(@PathVariable("id")int id,@RequestBody BookDto bookDto) {
		this.bookService.updateBook(id,bookDto);
	}
	
	@GetMapping("/Issue/{id}")
	public List<TransactionDto> IssueStatusBookId(@PathVariable("id") int id) {
		return this.bookService.IssueStatusBookId(id);
	}
//	@GetMapping("/transection/{id}/book")
//	public List<BookDto> getBooksWithTransection(@PathVariable("id")int id){
//		return this.bookService.getBooksByTransection(id);
//	}
	
	@GetMapping("/bookbyname")
	public Book getByName(@RequestBody String bookname) {
		return bookService.getByName(bookname);
	}

}
