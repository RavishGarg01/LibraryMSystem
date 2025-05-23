package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.BookDto;
import com.example.demo.services.BookService;
import com.example.demo.dtos.TransactionDto;
import com.example.demo.entites.Book;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping("/book")
	public ResponseEntity<String> createNewBook(@RequestBody BookDto bookDto) {

		try {
			String bookId = this.bookService.createBook(bookDto);
			return new ResponseEntity(bookId, HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/book/{id}")
	public ResponseEntity<String> updateBook(@PathVariable("id") int id, @RequestBody BookDto bookDto) {
		this.bookService.updateBook(id, bookDto);
		try {
			String bookId = this.bookService.updateBook(id, bookDto);
			return new ResponseEntity(bookId, HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/book")
	public ResponseEntity<List<BookDto>> getAllBooks() {
		try {
			List<BookDto> bookList = this.bookService.getAll();
			return new ResponseEntity(bookList, HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
//	
//	@GetMapping("/book/{id}")
//	public ResponseEntity<BookDto> getById(@PathVariable("id") int id) {
//		try {
//			BookDto bookDto =this.bookService.getById(id);
//			return new ResponseEntity(bookDto, HttpStatus.OK);
//		} catch (Exception exception) {
//			return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
//		}
//	}

	@PostMapping("/book-by-name")
	public ResponseEntity<List<BookDto>> getByName(@RequestBody BookDto bookDto) {
		try {
			System.out.println("contoller" + bookDto);
			String Name = bookDto.getName();
			if (Name.length() <= 4) {
				throw new Exception("Search text length should be greater than 3");
			}
			List<BookDto> bookDtoResponse = this.bookService.getByName(Name);
			return new ResponseEntity(bookDtoResponse, HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/book-by-id")
	public ResponseEntity<BookDto> getByID(@RequestBody BookDto bookDto) {
		try {
			System.out.println("contoller" + bookDto);
			BookDto bookDtoResponse = this.bookService.getById(bookDto.getBookId());
			return new ResponseEntity(bookDtoResponse, HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

//	@GetMapping("/book-issue-status/{id}")
//	public ResponseEntity<String> IssueStatusBookId(@PathVariable("id") int id) {
//		try {
//			 String status=this.bookService.IssueStatusBookId(id);
//			return new ResponseEntity(status, HttpStatus.OK);
//		} catch (Exception exception) {
//			return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
//		}
//	}
//	@GetMapping("/transection/{id}/book")
//	public List<BookDto> getBooksWithTransection(@PathVariable("id")int id){
//		return this.bookService.getBooksByTransection(id);
//	}

	@PostMapping("/book-by-approxname")
	public ResponseEntity<List<Book>> searchBooks(@RequestBody BookDto bookDto) {
		try {
			String Name = bookDto.getName();
			if (Name.length() <= 4) {
				throw new Exception("Search text length should be greater than 3");
			}
			List<Book> bookDtoResponse = bookService.searchByApproxName(Name);
			return new ResponseEntity(bookDtoResponse, HttpStatus.OK);

		} catch (Exception exception) {
			return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}


	@PostMapping("/book/addMultiple")
	public ResponseEntity<List<String>> createNewBook(@RequestBody List<BookDto> bookDtos) {

		try {
			List<String> bookIds = this.bookService.addMultipleBooks(bookDtos);
			return new ResponseEntity(bookIds, HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
