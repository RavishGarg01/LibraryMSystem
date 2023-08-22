package com.example.demo.dtos;

public class BookDto {
	
	private int bookId;
	
	private String name;
	
	private String author;
	
	private boolean isissued;
	
	
	
	public BookDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookDto(int bookId, String name, String author, boolean isissued) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.author = author;
		this.isissued = isissued;
	}



	public int getBookId() {
		return bookId;
	}



	public void setBookId(int bookId) {
		this.bookId = bookId;
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
		return isissued;
	}



	public void setIsissued(boolean isissued) {
		this.isissued = isissued;
	}



	@Override
	public String toString() {
		return "BookDto [bookId=" + bookId + ", name=" + name + ", author=" + author + ", isissued=" + isissued + "]";
	}
	

}
