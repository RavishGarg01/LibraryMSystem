package com.example.demo.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
	
	private String bookId;
	
	private String name;
	
	private String author;
	
	private boolean isissued;

	private String category;
	
	
	
//	public BookDto() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public BookDto(String bookId, String name, String author, boolean isissued,String category) {
//		super();
//		this.bookId = bookId;
//		this.name = name;
//		this.author = author;
//		this.isissued = isissued;
//		this.category = category;
//	}
//
//
//
//	public String getBookId() {
//		return bookId;
//	}
//
//
//
//	public void setBookId(String bookId) {
//		this.bookId = bookId;
//	}
//
//
//
//	public String getName() {
//		return name;
//	}
//
//
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//
//
//	public String getAuthor() {
//		return author;
//	}
//
//
//
//	public void setAuthor(String author) {
//		this.author = author;
//	}
//
//
//
//	public boolean isIsissued() {
//		return isissued;
//	}
//
//
//
//	public void setIsissued(boolean isissued) {
//		this.isissued = isissued;
//	}
//
//
//
//	@Override
//	public String toString() {
//		return "BookDto [bookId=" + bookId + ", name=" + name + ", author=" + author + ", isissued=" + isissued + "]";
//	}
//

}
