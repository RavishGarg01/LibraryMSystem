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
import javax.persistence.OneToOne;

@Entity
public class Transection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int referenceId;

	private String Issuedate;
	
	private int fine;
	
//	@ManyToOne
//	private Book book;
//	
	@ManyToOne(cascade=CascadeType.ALL)
	private Student student;

	public Transection() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transection(int referenceId, String issuedate, int fine, Student student) {
		super();
		this.referenceId = referenceId;
		Issuedate = issuedate;
		this.fine = fine;
		this.student = student;
	}

	public int getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(int referenceId) {
		this.referenceId = referenceId;
	}

	public String getIssuedate() {
		return Issuedate;
	}

	public void setIssuedate(String issuedate) {
		Issuedate = issuedate;
	}

	public int getFine() {
		return fine;
	}

	public void setFine(int fine) {
		this.fine = fine;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Transection [referenceId=" + referenceId + ", Issuedate=" + Issuedate + ", fine=" + fine + ", student="
				+ student + "]";
	}

	

	
	
	
	

}