package com.example.demo.dtos;

import java.util.Date;

public class TransactionDto {
	
	
	private int referenceId;
	
	private String returnDate;;
	
	private String issueDate;
	
	private String BookName;
	
	private String StudentName;
	
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
