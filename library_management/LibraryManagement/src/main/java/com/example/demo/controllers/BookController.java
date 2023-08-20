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
import com.example.demo.dtos.TransactionDto;
import com.example.demo.entites.Book;
import com.example.demo.entites.Transaction;
import com.example.demo.sevices.BookService;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class BookController {
	
	
	@Autowired
	private BookService bs;
	
//	@PostMapping("/transection/{id}/book")
//	public void createNewBook(@PathVariable("id")int id,@RequestBody BookDto book) {
//		
//		this.bs.createBook(id,book);
//		
//	}
	@PostMapping("/book")
	public void createNewBook(@RequestBody BookDto book) {
		System.out.println("here");
		this.bs.createBook(book);
		
	}
	
	@GetMapping("/book/{id}")
	public BookDto getById(@PathVariable("id") int id) {
		return this.bs.getById(id);
		
	}
	@GetMapping("/Issue/{id}")
	public List<TransactionDto> IssueStatusBookId(@PathVariable("id") int id) {
		return this.bs.IssueStatusBookId(id);
		
	}
	
	@GetMapping("/book")
    public List<BookDto> getAllBooks(){
		return this.bs.getAll();
    	
    }
	
	@PutMapping("/book/{id}")
	public void updateBook(@PathVariable("id")int id,@RequestBody Book book) {
		this.bs.updateBook(id,book);
	}
	
//	@GetMapping("/transection/{id}/book")
//	public List<BookDto> getBooksWithTransection(@PathVariable("id")int id){
//		return this.bs.getBooksByTransection(id);
//	}

}
