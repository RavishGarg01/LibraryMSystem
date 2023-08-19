package com.example.demo.entites;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int BookId;
	
	private String name;
	
	private String author;
	
	private boolean Isissued;

//	@OneToMany(mappedBy="book",cascade=CascadeType.ALL)
//	private List<Transection> transections;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int bookId, String name, String author, boolean isissued) {
		super();
		BookId = bookId;
		this.name = name;
		this.author = author;
		Isissued = isissued;
//		this.transections=transections;
	}

	public int getBookId() {
		return BookId;
	}

	public void setBookId(int bookId) {
		BookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isIsissued() {
		return Isissued;
	}

	public void setIsissued(boolean isissued) {
		Isissued = isissued;
	}

//	public List<Transection> getTransection() {
//		return transections;
//	}
//
//	public void setTransection(List<Transection> transections) {
//		this.transections = transections;
//	}

	@Override
	public String toString() {
		return "Book [BookId=" + BookId + ", name=" + name + ", author=" + author + ", Isissued=" + Isissued
				+  "]";
	}

	
	
	

}
