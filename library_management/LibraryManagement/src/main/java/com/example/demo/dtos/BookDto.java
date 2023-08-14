package com.example.demo.dtos;

public class BookDto {
	
	private String name;
	
	private String author;
	
	private boolean Isissued;
	
	private TransectionDto transection;

	
	
	public BookDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookDto(String name, String author, boolean isissued,TransectionDto transection) {
		super();
		this.name = name;
		this.author = author;
		Isissued = isissued;
		this.transection=transection;
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
	

	public TransectionDto getTransection() {
		return transection;
	}

	public void setTransection(TransectionDto transection) {
		this.transection = transection;
	}

	@Override
	public String toString() {
		return "BookDto [name=" + name + ", author=" + author + ", Isissued=" + Isissued + "transection"+transection+"]";
	}
	
	

}
