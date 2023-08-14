package com.example.demo.dtos;

public class StudentDto {
	

	
	private String name;
	
	private String branch;
	
	private String course;
	
	private String year;
	
	

	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public StudentDto(String name, String branch, String course, String year) {
		super();
		this.name = name;
		this.branch = branch;
		this.course = course;
		this.year = year;
		
		
		
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



	public String getCourse() {
		return course;
	}



	public void setCourse(String course) {
		this.course = course;
	}



	public String getYear() {
		return year;
	}



	public void setYear(String year) {
		this.year = year;
	}



	@Override
	public String toString() {
		return "StudentDto [name=" + name + ", branch=" + branch + ", course=" + course + ", year=" + year + "]";
	}
	
	

}
