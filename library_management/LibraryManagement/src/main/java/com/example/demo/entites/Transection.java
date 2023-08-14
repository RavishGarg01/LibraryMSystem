package com.example.demo.entites;

import java.util.Date;
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
public class Transection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int referenceId;
	
	private String IssuedTo;
	
	private String Issuedate;
	
	private String Duedate;
	
	private int fine;
	
	@OneToMany(mappedBy="transection",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Book> book;
	
	@ManyToOne
	private Student student;

	public Transection() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transection(int referenceId, String issuedTo, String issuedate, String duedate, int bookId, String name,
			String author,List<Book> book,Student student) {
		super();
		this.referenceId = referenceId;
		IssuedTo = issuedTo;
		Issuedate = issuedate;
		Duedate = duedate;
		this.book=book;
		this.student=student;
	}

	public int getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(int referenceId) {
		this.referenceId = referenceId;
	}

	public String getIssuedTo() {
		return IssuedTo;
	}

	public void setIssuedTo(String issuedTo) {
		IssuedTo = issuedTo;
	}

	public String getIssuedate() {
		return Issuedate;
	}

	public void setIssuedate(String issuedate) {
		Issuedate = issuedate;
	}

	public String getDuedate() {
		return Duedate;
	}

	public void setDuedate(String duedate) {
		Duedate = duedate;
	}

	
	

	public int getFine() {
		return fine;
	}

	public void setFine(int fine) {
		this.fine = fine;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	

	@Override
	public String toString() {
		return "Book [referenceId=" + referenceId + ", IssuedTo=" + IssuedTo + ", Issuedate=" + Issuedate + ", Duedate="
				+ Duedate + ", bookId=" + "Books="+book+"student" + student + "]";
	}
	
	
	

}