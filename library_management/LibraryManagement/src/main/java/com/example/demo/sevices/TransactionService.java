package com.example.demo.sevices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

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
//	StudentService studentService;
	
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
	
	public Transaction issueBook(TransactionDto transactionDto) {
		
		Transaction transaction=modelMapper.map(transactionDto, Transaction.class);
		
		Book book=bookService.getByName(transactionDto.getBookName());
		book.setIsissued(true);
		transaction.setBook(book);
		
		System.out.println(book);
		
		Student student=studentService.getByName(transactionDto.getStudentName());
		transaction.setStudent(student);
		System.out.println(student);
		
		Transaction saved=this.transRepo.save(transaction);
		
		return saved;
	}

	public Transaction returnBook(TransactionDto transactionDto) throws ParseException {
		Transaction transaction=modelMapper.map(transactionDto, Transaction.class);
		
		Book book=bookService.getByName(transactionDto.getBookName());
		book.setIsissued(false);
		transaction.setBook(book);
		
		System.out.println(book);
		
		Student student=studentService.getByName(transactionDto.getStudentName());
		transaction.setStudent(student);
		System.out.println(student);
		
//		Optional<Transaction>transactionList=transRepo.findByBookAndStudentAndReturnDate(book, student,"");
		//need to get latest transaction
//		Transaction prevTransaction =transactionList.get();
		int fine = fineCalculator(transaction.getIssueDate(),transaction.getReturnDate());
		
		student.setFine(student.getFine()+fine);
		Transaction saved=this.transRepo.save(transaction);
		
		return saved;	
		}
	
	private int fineCalculator(String issueDateS,String returnDateS) throws ParseException {
		int fine=0;
		int daysLimit=15;
		int finePerDay=1;
		Date issueDate = new SimpleDateFormat("dd-MM-yyyy").parse(issueDateS);
		Date returnDate = new SimpleDateFormat("dd-MM-yyyy").parse(returnDateS);
		long time_difference = returnDate.getTime() - issueDate.getTime();  
        
        // Calucalte time difference in days using TimeUnit class  
        int days_difference = (int)TimeUnit.MILLISECONDS.toDays(time_difference);
		
		if(days_difference<=daysLimit) {
			fine= 0;
		}else {
			fine=(days_difference-daysLimit)*finePerDay;
		}
		return fine;
	}
	
//	public Optional<Transaction> getAllTransactionByStudentAndReturnDate(Student student){
//		Optional<Transaction> transactionList= transRepo.findByStudentAndReturnDate(student, "");
//		return transactionList;
//	}
//	
}
