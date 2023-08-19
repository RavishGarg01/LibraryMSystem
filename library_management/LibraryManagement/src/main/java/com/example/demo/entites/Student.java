package com.example.demo.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private String branch;
	
	private String course;
	
	private String year;
	
	
	
	@OneToMany(mappedBy="student",cascade=CascadeType.ALL)
	private List<Transection> transections=new ArrayList<>();
	

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Student(int id, String name, String branch, String course, String year, List<Transection> transections) {
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.course = course;
		this.year = year;
		this.transections = transections;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	

	

	public List<Transection> getTransections() {
		return transections;
	}



	public void setTransections(List<Transection> transections) {
		this.transections = transections;
	}



	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", branch=" + branch + ", course=" + course + ", year="+ year+"transection"+transections+"]";
	}
	
	
	

}
