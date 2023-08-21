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
import com.example.demo.repositories.TransRepo;

@Service
public class TransactionService {

	@Autowired
	private TransRepo transRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	StudentService studentService;
	
	public List<Transaction> getAllTransections(){
		return this.transRepo.findAll();
	}
	
	public TransactionDto getTransectionById(int id) {
		Optional<Transaction> transactionList=this.transRepo.findById(id);
		Transaction transaction=transactionList.get();
		TransactionDto transactionDto=modelMapper.map(transaction, TransactionDto.class);
		return transactionDto;
	}
	
	
	//Create Transaction
	
	public Transaction CreateTransaction(TransactionDto transactionDto) {
		
		Transaction transaction=modelMapper.map(transactionDto, Transaction.class);
		
		Book book=bookService.getByName(transactionDto.getBookName());
		transaction.setBook(book);
		System.out.println(book);
		
		Student student=studentService.getByName(transactionDto.getStudentName());
		transaction.setStudent(student);
		System.out.println(student);
		
		Transaction saved=this.transRepo.save(transaction);
		
		return saved;
	}
	
}
