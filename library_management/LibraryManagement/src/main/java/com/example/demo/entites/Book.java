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

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int BookId;
	
	private String name;
	
	private String author;
	
	private boolean Isissued;

	@ManyToOne
	private Transection transection;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int bookId, String name, String author, boolean isissued,Transection transection) {
		super();
		BookId = bookId;
		this.name = name;
		this.author = author;
		Isissued = isissued;
		this.transection=transection;
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

	public Transection getTransection() {
		return transection;
	}

	public void setTransection(Transection transection) {
		this.transection = transection;
	}

	@Override
	public String toString() {
		return "Book [BookId=" + BookId + ", name=" + name + ", author=" + author + ", Isissued=" + Isissued + "Transection="+transection+"]";
	}
	
	
	

}
