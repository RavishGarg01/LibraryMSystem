package com.example.demo.entites;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bookId;
	
	private String name;
	
	private String author;
	
	private boolean isissued;

	private String category;

	@OneToMany(mappedBy="book", cascade=CascadeType.ALL)
	private List<Transaction>  transactionList=new ArrayList<>();
	

//	public Book() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//
//	public Book(int bookId, String name, String author, boolean isissued, List<Transaction> transactionList,String category) {
//		super();
//		this.bookId = bookId;
//		this.name = name;
//		this.author = author;
//		this.isissued = isissued;
//		this.transactionList = transactionList;
//		this.category = category;
//	}

//
//	public int getBookId() {
//		return bookId;
//	}
//
//
//	public void setBookId(int bookId) {
//		this.bookId = bookId;
//	}
//
//
//	public String getName() {
//		return name;
//	}
//
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//
//	public String getAuthor() {
//		return author;
//	}
//
//
//	public void setAuthor(String author) {
//		this.author = author;
//	}
//
//
//	public boolean isIsissued() {
//		return isissued;
//	}
//
//
//	public void setIsissued(boolean isissued) {
//		this.isissued = isissued;
//	}
//
//
//	public List<Transaction> getTransactionList() {
//		return transactionList;
//	}
//
//
//	public void setTransactionList(List<Transaction> transactionList) {
//		this.transactionList = transactionList;
//	}
//
//
//	@Override
//	public String toString() {
//		return "Book [bookId=" + bookId + ", name=" + name + ", author=" + author + ", isissued=" + isissued
//				+ ", transactionList=" + transactionList + "]";
//	}

	

}
