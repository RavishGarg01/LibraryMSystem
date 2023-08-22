package com.example.demo.entites;


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
	
	private String transactionType;
	
	private String transactionDate;
	
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

	public Transaction(int referenceId, String transactionType, String transactionDate, Book book, Student student) {
		super();
		this.referenceId = referenceId;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.book = book;
		this.student = student;
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
	