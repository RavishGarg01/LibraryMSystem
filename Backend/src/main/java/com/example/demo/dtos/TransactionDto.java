package com.example.demo.dtos;

import java.util.Date;

public class TransactionDto {
	
	
	private int referenceId;
	
	private String returnDate;;
	
	private String issueDate;
	
	private String bookName;
	
	private String studentName;
	
	private StudentDto studentDto;
	
	private BookDto bookDto;
	
	public TransactionDto() {
		super();
	}

	public TransactionDto(int referenceId, String returnDate, String issueDate, String bookName,
			String studentName, StudentDto studentDto, BookDto bookDto) {
		super();
		this.referenceId = referenceId;
		this.returnDate = returnDate;
		this.issueDate = issueDate;
		this.bookName = bookName;
		this.studentName = studentName;
		this.studentDto = studentDto;
		this.bookDto = bookDto;
	}

	public int getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(int referenceId) {
		this.referenceId = referenceId;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getbookName() {
		return bookName;
	}

	public void setbookName(String bookName) {
		this.bookName = bookName;
	}

	public String getstudentName() {
		return studentName;
	}

	public void setstudentName(String studentName) {
		this.studentName = studentName;
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
