package com.example.demo.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.BookDto;
import com.example.demo.dtos.TransactionDto;
import com.example.demo.entites.Book;
import com.example.demo.entites.Transaction;
import com.example.demo.repositories.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepo;

	@Autowired
	private ModelMapper modelMapper;

	public String createBook(BookDto bookDto) {

		Book book = modelMapper.map(bookDto, Book.class);
		book.setIsissued(false);
		this.bookRepo.save(book);
		return String.valueOf(book.getBookId());
	}

	public List<String> addMultipleBooks(List<BookDto> bookDtos) {
       return  bookDtos.stream().map(b->{
			Book book = modelMapper.map(b, Book.class);
			book.setIsissued(false);
			this.bookRepo.save(book);
			return String.valueOf(book.getBookId());
		}).collect(Collectors.toList());

	}
	
	public String updateBook(int id, BookDto bookDto) {
		Optional<Book> bookList = this.bookRepo.findById(id);
		Book book = bookList.get();
		if (bookDto.getAuthor() != null) {
			book.setAuthor(bookDto.getAuthor());
		}
		if (bookDto.getName() != null)
			book.setName(bookDto.getName());
		this.bookRepo.save(book);
		return String.valueOf(book.getBookId());
	}

	public BookDto getById(String id) throws NullPointerException {
		
		Optional<Book> bookList = this.bookRepo.findById(Integer.parseInt(id));
		if (bookList.isPresent()) {
			Book book = bookList.get();
			BookDto bookDto = modelMapper.map(book, BookDto.class);
			return bookDto;

		} else {
			throw new NullPointerException("Book with given ID is not found");
		}
	}

	public List<BookDto> getByName(String bookname) throws NullPointerException {
		Optional<List<Book>> optionalbook = this.bookRepo.findByName(bookname);
		System.out.println("service"+bookname);
		if (optionalbook.isPresent()) {
			List<BookDto> bookDto = optionalbook.get().stream().map(book->modelMapper.map(book, BookDto.class)).collect(Collectors.toList());
			return bookDto;
		} else {
			throw new NullPointerException("Book with given Name is not found");
		}
	}

	public List<BookDto> getAll() {
		List<Book> bookList = this.bookRepo.findAll();
		List<BookDto> bookDtoList = bookList.stream().map(i -> modelMapper.map(i, BookDto.class))
				.collect(Collectors.toList());
		return bookDtoList;
	}

	// GetBooksByTransection

//	public List<BookDto> getBooksByTransection(int id){
//		Optional<Transaction>t=tr.findById(id);
//		
//		if(t.isPresent()) {
//			Transaction transection=t.get();
//			List<Book>li=this.bookRepo.getByTransection(transection);
//			List<BookDto>list=li.stream().map(i->modelMapper.map(i, BookDto.class)).collect(Collectors.toList());
//			return list;
//		}
//		else {
//			return null;
//		}
//	}

	

	public String IssueStatusBookId(String id) throws Exception  {
		
		try {
			BookDto bookDto = getById(id);
			if(bookDto.isIsissued()) {
				return "Book is already Issued";
			}else {
				return "You can borrow this book";
			}
			
		}catch(Exception exception) {
			throw exception;
		}
//		Optional<Book> bookList = this.bookRepo.findById(id);
//		if (bookList.isPresent()) {
//			Book book = bookList.get();
//			List<Transaction> listTransections = book.getTransactionList();
//			List<TransactionDto> listTransectionDto = listTransections.stream()
//					.map(i -> modelMapper.map(i, TransactionDto.class)).collect(Collectors.toList());
//			return listTransectionDto;
//		} else {
//			return null;
//		}
	}

	public List<Book> searchByApproxName(String searchTerm) {
		
	        return bookRepo.findByNameContaining(searchTerm);
	}

}
