package com.example.demo.dtos;

public class TransectionDto {
	
	private int studentid;
	
//	private int bookid;
	
	private int fine;
	
	private StudentDto student;
	

	
//	private BookDto bookDto;
	
	public TransectionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransectionDto(int studentid, int fine,StudentDto student) {
		super();
		this.studentid=studentid;
//		this.bookid=bookid;
		this.fine = fine;
		this.student=student;
		
	}

	
	
//	public int getBookid() {
//		return bookid;
//	}
//
//	public void setBookid(int bookid) {
//		this.bookid = bookid;
//	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public int getFine() {
		return fine;
	}

	public void setFine(int fine) {
		this.fine = fine;
	}

	
	

	public StudentDto getStudent() {
		return student;
	}

	public void setStudent(StudentDto student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "TransectionDto [studentid=" + studentid + ", fine=" + fine + ", student="
				+ student + "]";
	}

	
	

	
	

}
