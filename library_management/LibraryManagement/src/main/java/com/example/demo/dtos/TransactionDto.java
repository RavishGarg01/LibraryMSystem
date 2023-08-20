package com.example.demo.dtos;


public class TransactionDto {
	
	
	private int referenceId;
	
	private String transactionType;
	
	private String transactionDate;
	
	private String BookName;
	
	private String StudentName;
	
	private StudentDto studentDto;
	
	private BookDto bookDto;
	
	public TransactionDto() {
		super();
	}

	public TransactionDto(int referenceId, String transactionType, String transactionDate, String bookName,
			String studentName, StudentDto studentDto, BookDto bookDto) {
		super();
		this.referenceId = referenceId;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		BookName = bookName;
		StudentName = studentName;
		this.studentDto = studentDto;
		this.bookDto = bookDto;
	}

	public int getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(int referenceId) {
		this.referenceId = referenceId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public StudentDto getStudentDto() {
		return studentDto;
	}

	public void setStudentDto(StudentDto studentDto) {
		this.studentDto = studentDto;
	}

	public BookDto getBookDto() {
		return bookDto;
	}

	public void setBookDto(BookDto bookDto) {
		this.bookDto = bookDto;
	}

	
	
	
}
