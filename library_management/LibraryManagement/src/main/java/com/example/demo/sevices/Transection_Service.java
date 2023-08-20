package com.example.demo.sevices;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.TransactionDto;
import com.example.demo.entites.Book;
import com.example.demo.entites.Student;
import com.example.demo.entites.Transaction;
import com.example.demo.repositories.BookRepo;
import com.example.demo.repositories.StudentRepo;
import com.example.demo.repositories.TransRepo;

@Service
public class Transection_Service {

	@Autowired
	private TransRepo tr;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	StudentServices studentService;
	
	public List<Transaction> getAllTransections(){
		return this.tr.findAll();
	}
	
	public TransactionDto getTransectionById(int id) {
		Optional<Transaction> op=this.tr.findById(id);
		
		Transaction t1=op.get();
		
		TransactionDto tdto=modelMapper.map(t1, TransactionDto.class);
		
		return tdto;
		
	}
	
	
	//Create Transaction
	
	public Transaction CreateTransaction(TransactionDto t1) {
		
		Transaction t=modelMapper.map(t1, Transaction.class);
		
		System.out.println(t1.getBookName());
		System.out.println(t1.getStudentName());
		
		Book b1=bookService.getByName(t1.getBookName());
		t.setBook(b1);
		System.out.println(b1);
		
		Student s1=studentService.getByName(t1.getStudentName());
		t.setStudent(s1);
		System.out.println(s1);
		
		Transaction saved=this.tr.save(t);
		
		return saved;
	}
	
}
