package com.example.demo.dtos;

public class StudentDto {
	
	private int id;
	
	private String collegeId; 
	
	private String name;
	
	private String branch;
	
	private String year;
	
	private int fine;
	
	

	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public StudentDto(int id, String collegeId, String name, String branch, String year, int fine) {
		super();
		this.id = id;
		this.collegeId = collegeId;
		this.name = name;
		this.branch = branch;
		this.year = year;
		this.fine = fine;
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



	@Override
	public String toString() {
		return "StudentDto [id=" + id + ", collegeId=" + collegeId + ", name=" + name + ", branch=" + branch + ", year="
				+ year + ", fine=" + fine + "]";
	}
	
	
}
