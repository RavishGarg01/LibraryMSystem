package com.example.demo.sevices;

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
	

	public void  createBook(BookDto bookDto) {
		
		Book book=modelMapper.map(bookDto, Book.class);
		book.setIsissued(false);
		this.bookRepo.save(book);
		
	}
	
	public BookDto getById(int id) {
		Optional<Book> bookList= this.bookRepo.findById(id);
		if(bookList.isPresent()) {
			Book book=bookList.get();
			BookDto bookDto=modelMapper.map(book,BookDto.class);
			return bookDto;
			
		}
		else {
			return null;
		}
	}
	
	public Book getByName(String name) throws NullPointerException {
		Optional<Book> optionalbook= this.bookRepo.findByName(name);
		if(optionalbook.isPresent()) {
			Book book=optionalbook.get();
			System.out.println("get name Method"+book);
			
			return book;
		}
		else {
			throw new NullPointerException("Book with given name is not found");
		}
	}
	
	public List<BookDto> getAll() {
		List<Book>bookList=this.bookRepo.findAll();
		List<BookDto>bookDtoList=bookList.stream().map(i->modelMapper.map(i,BookDto.class)).collect(Collectors.toList());
		return bookDtoList;
	}
	
	//GetBooksByTransection
	
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

	public void updateBook(int id,BookDto bookDto) {
		Optional<Book> bookList= this.bookRepo.findById(id);
		Book book=bookList.get();
		if(bookDto.getAuthor()!=null) {book.setAuthor(bookDto.getAuthor());}
		if(bookDto.getName()!=null) book.setName(bookDto.getName());
		this.bookRepo.save(book);
	}

	public List<TransactionDto> IssueStatusBookId(int id) {
		
		Optional<Book> bookList= this.bookRepo.findById(id);
		if(bookList.isPresent()) {
			Book book=bookList.get();
			List<Transaction>listTransections=book.getTransactionList();
			List<TransactionDto>listTransectionDto=listTransections.stream().map(i->modelMapper.map(i,TransactionDto.class) ).collect(Collectors.toList());
			return listTransectionDto;
		}
		else {
			return null;
		}
	}

}
