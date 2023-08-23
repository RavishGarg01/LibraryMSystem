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
	
	public Transaction issueBook(TransactionDto transactionDto) throws Exception {
		
		Transaction transaction=modelMapper.map(transactionDto, Transaction.class);
		Book book;
		try {
		 book=bookService.getByName(transactionDto.getBookName());
		 System.out.println(book);
		}catch(NullPointerException e) {
			e.printStackTrace();
			
		     throw e;
		}
		
		if(!book.isIsissued()) {
			book.setIsissued(true);
			transaction.setBook(book);
			
			System.out.println(book);
			
			Student student=studentService.getByName(transactionDto.getStudentName());
			transaction.setStudent(student);
			System.out.println(student);
			
			Date currentDate= new Date();
			transaction.setIssueDate(currentDate);
			transaction.setReturnDate(null);
			Transaction saved= this.transRepo.save(transaction);
			
			return saved;
		}else {
			throw new Exception("Book is already issued");
		}
		
	}

	public Transaction returnBook(TransactionDto transactionDtofromUser) throws ParseException {
		Date currentDate=new Date();
		
		Student student=studentService.getByName(transactionDtofromUser.getStudentName());
		Book book=bookService.getByName(transactionDtofromUser.getBookName());
		book.setIsissued(false);
		
		Optional<Transaction>transactionList=transRepo.findByBookAndStudentAndReturnDate(book, student,null);
		Transaction transaction =transactionList.get();
		transaction.setReturnDate(currentDate);
		Transaction saved=this.transRepo.save(transaction);
		
		int fine = fineCalculator(transaction.getIssueDate(),currentDate);
		student.setFine(student.getFine()+fine);
		return saved;	
		}
	
	private int fineCalculator(Date issueDate,Date returnDate) throws ParseException {
		int fine=0;
		int daysLimit=15;
		int finePerDay=1;
//		Date issueDate = new SimpleDateFormat("dd-MM-yyyy").parse(issueDateS);
//		Date returnDate = new SimpleDateFormat("dd-MM-yyyy").parse(returnDateS);
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
	
	public Optional<Transaction> getAllTransactionByStudentAndReturnDate(Student student){
		System.out.println("I am in transection service");
		Student studentInstance = studentService.getByName(student.getName());
		Optional<Transaction> transactionList= transRepo.findByStudentAndReturnDate(studentInstance, "");
		
		System.out.println("After declaration of optional");
		return transactionList;
	}
	
}
