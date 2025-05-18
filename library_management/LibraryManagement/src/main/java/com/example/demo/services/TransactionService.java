package com.example.demo.services;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.BookDto;
import com.example.demo.dtos.TransactionDto;
import com.example.demo.entites.Book;
import com.example.demo.entites.Student;
import com.example.demo.entites.Transaction;
import com.example.demo.repositories.BookRepo;
import com.example.demo.repositories.StudentRepo;
import com.example.demo.repositories.TransRepo;

@Service
public class TransactionService {

	@Autowired
	private TransRepo transRepo;
	@Autowired
	private BookRepo bookRepo;
	@Autowired
	private StudentRepo studentRepo;
	@Autowired
	ModelMapper modelMapper;

	@Autowired
	BookService bookService;

	@Autowired
	StudentService studentService;

	public List<Transaction> getAllTransections() {
		return this.transRepo.findAll();
	}

	public TransactionDto getTransectionById(int id) {
		Optional<Transaction> transactionList = this.transRepo.findById(id);
		Transaction transaction = transactionList.get();
		TransactionDto transactionDto = modelMapper.map(transaction, TransactionDto.class);
		return transactionDto;
	}

	// Create Transaction

	public Transaction issueBook(TransactionDto transactionDto) throws Exception {

		Transaction transaction = modelMapper.map(transactionDto, Transaction.class);
		List<BookDto> bookDtoList = bookService.getByName(transactionDto.getbookName());
		BookDto bookDto;
		try {
			if (bookDtoList.size() != 1) {
				throw new Exception("Selected book is not unique");
			}
			bookDto = bookDtoList.get(0);
			System.out.println(bookDto);
		} catch (NullPointerException e) {
			e.printStackTrace();

			throw e;
		}

		if (!bookDto.isIsissued()) {
			bookDto.setIsissued(true);
			Book book = modelMapper.map(bookDto, Book.class);
			bookRepo.save(book);
			transaction.setBook(book);

			Student student = studentService.getByName(transactionDto.getstudentName());
			transaction.setStudent(student);
			System.out.println(student);

			Date currentDate = new Date();
			transaction.setIssueDate(currentDate);
			transaction.setReturnDate(null);
			Transaction saved = this.transRepo.save(transaction);

			return saved;
		} else {
			throw new Exception("Book is already issued");
		}

	}

	public Transaction returnBook(TransactionDto transactionDtofromUser) throws Exception {
		Date currentDate = new Date();

		Student student = studentService.getByName(transactionDtofromUser.getstudentName());
		System.out.println(student);
		List<BookDto> bookDtoList = bookService.getByName(transactionDtofromUser.getbookName());
		if (bookDtoList.size() != 1) {
			throw new Exception("Selected book is not unique");
		}
		BookDto bookDto = bookDtoList.get(0);
		
		
		bookDto.setIsissued(false);
		Book book = modelMapper.map(bookDto, Book.class);
		System.out.println(book);
		
		Optional<Transaction> optionaltransaction = transRepo.findByBookAndStudentAndReturnDate(book, student, null);
		if (!optionaltransaction.isPresent()) {
			throw new Exception("The student has not issued this book");
		}
		Transaction transaction = optionaltransaction.get();
		transaction.setReturnDate(currentDate);
		
		int fine = fineCalculator(transaction.getIssueDate(), currentDate);
		student.setFine(student.getFine() + fine);
		
		this.studentRepo.save(student);
		this.bookRepo.save(book);
		Transaction saved = this.transRepo.save(transaction);
		return saved;
	}

	private int fineCalculator(Date issueDate, Date returnDate) throws ParseException {
		int fine = 0;
		int daysLimit = 15;
		int finePerDay = 1;
//		Date issueDate = new SimpleDateFormat("dd-MM-yyyy").parse(issueDateS);
//		Date returnDate = new SimpleDateFormat("dd-MM-yyyy").parse(returnDateS);
		long time_difference = returnDate.getTime() - issueDate.getTime();

		// Calucalte time difference in days using TimeUnit class
		int days_difference = (int) TimeUnit.MILLISECONDS.toDays(time_difference);

		if (days_difference <= daysLimit) {
			fine = 0;
		} else {
			fine = (days_difference - daysLimit) * finePerDay;
		}
		return fine;
	}

	public Optional<List<BookDto>> getAllTransactionByStudentAndReturnDate(Student student) {

		Student studentInstance = studentService.getByName(student.getName());

		Optional<List<Transaction>> transactionList = transRepo.findByStudentAndReturnDate(studentInstance, null);
		
		Optional<List<BookDto>> bookList = Optional.ofNullable(
		transactionList.get().stream().map(transaction ->modelMapper.map(transaction.getBook(), BookDto.class) ).collect(Collectors.toList()));
		return bookList;
	}

}
