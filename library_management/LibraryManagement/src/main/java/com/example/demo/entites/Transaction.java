package com.example.demo.entites;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int referenceId;
	
	private String issueDate;
	
	private String returnDate;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Book book;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Student student;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(int referenceId, String issueDate, String returnDate, Book book, Student student) {
		super();
		this.referenceId = referenceId;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.book = book;
		this.student = student;
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

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
	
}
	