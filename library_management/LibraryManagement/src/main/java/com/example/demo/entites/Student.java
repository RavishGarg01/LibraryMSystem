package com.example.demo.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	
	private String collegeId; 
	
	private String name;
	
	private String branch;
	
	private String year;
	
	private int fine;
	
	@OneToMany(mappedBy="student", cascade=CascadeType.ALL)
	private List<Transaction>  transactionList=new ArrayList<>();
	
	public Student() {
//		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String collegeId, String name, String branch, String year, int fine,
			List<Transaction> transactionList) {
		super();
		this.id = id;
		this.collegeId = collegeId;
		this.name = name;
		this.branch = branch;
		this.year = year;
		this.fine = fine;
		this.transactionList = transactionList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getFine() {
		return fine;
	}

	public void setFine(int fine) {
		this.fine = fine;
	}

	public List<Transaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", collegeId=" + collegeId + ", name=" + name + ", branch=" + branch + ", year="
				+ year + ", fine=" + fine + ", transactionList=" + transactionList + "]";
	}
	
}

	