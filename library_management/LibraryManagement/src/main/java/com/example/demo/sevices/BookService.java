package com.example.demo.sevices;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.BookDto;
import com.example.demo.entites.Book;
import com.example.demo.entites.Transection;
import com.example.demo.repositories.BookRepo;
import com.example.demo.repositories.TransRepo;

@Service
public class BookService {
	
	@Autowired
	private BookRepo br;
	
	@Autowired
	private TransRepo tr;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	//Create Book
	
	public void  createBook(int id,BookDto book) {
		 Optional<Transection> t=tr.findById(id);
		 Transection t1=t.get();
		Book b1=modelMapper.map(book, Book.class);
		b1.setTransection(t1);
		this.br.save(b1);
		
	}
	
	
	public BookDto getById(int id) {
		Optional<Book> b1= this.br.findById(id);
		if(b1.isPresent()) {
		Book book=b1.get();
		BookDto bookDto=modelMapper.map(book,BookDto.class);
		return bookDto;
		}
		else {
			return null;
		}
	}

	
	//GetAllBooks
	
	public List<BookDto> getAll() {
		List<Book>li=this.br.findAll();
		List<BookDto>list=li.stream().map(i->modelMapper.map(i,BookDto.class)).collect(Collectors.toList());
		return list;
	}
	
	//GetBooksByTransection
	
	public List<BookDto> getBooksByTransection(int id){
		Optional<Transection>t=tr.findById(id);
		
		if(t.isPresent()) {
			Transection transection=t.get();
			List<Book>li=this.br.getByTransection(transection);
			List<BookDto>list=li.stream().map(i->modelMapper.map(i, BookDto.class)).collect(Collectors.toList());
			return list;
		}
		else {
			return null;
		}
	}

	public void updateBook(int id,Book book) {
		Optional<Book> b2= this.br.findById(id);
		 Book b1=b2.get();
		
		b1.setAuthor(book.getAuthor());
		b1.setBookId(book.getBookId());
		b1.setIsissued(false);
		b1.setName(book.getName());
		
		this.br.save(b1);
		
		
		
	}

}
