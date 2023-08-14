package com.example.demo.dtos;

public class TransectionDto {
	
    
	
	private String IssuedTo;
	
	private String Issuedate;
	
	private String Duedate;
	
	
	private int fine;

	private StudentDto student;
//	private BookDto bookDto;
	public TransectionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransectionDto( String issuedTo, String issuedate, String duedate, 
		    int fine,StudentDto student) {
		super();
		
		IssuedTo = issuedTo;
		Issuedate = issuedate;
		Duedate = duedate;
		this.fine = fine;
		this.student=student;
		
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

	
	

	public StudentDto getStudent() {
		return student;
	}

	public void setStudent(StudentDto student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "TransectionDto [  IssuedTo=" + IssuedTo + ", Issuedate=" + Issuedate
				+ ", Duedate=" + Duedate + ", fine=" + fine + "student="+ student + "]";
	}
	

	
	

}
