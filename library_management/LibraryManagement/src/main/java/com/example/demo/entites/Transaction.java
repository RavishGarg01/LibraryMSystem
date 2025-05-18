package com.example.demo.entites;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int referenceId;
	
	private Date issueDate;
	
	private Date returnDate;

	
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

	public Transaction(int referenceId, Date issueDate, Date returnDate, Book book, Student student) {
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

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
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
	