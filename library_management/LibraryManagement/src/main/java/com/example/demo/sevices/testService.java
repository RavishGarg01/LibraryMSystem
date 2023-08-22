package com.example.demo.sevices;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entites.Student;
import com.example.demo.entites.Transection;
import com.example.demo.repositories.StudentRepo;
import com.example.demo.repositories.TransRepo;


public class testService {

    @Autowired
	private TransRepo tr;
	
	@Autowired
	private StudentRepo sr;
	
	
	public Student CreateStudent() {
		Student s=new Student();
		s.setName("Ravish");
		s.setCourse("btech");
		s.setBranch("coe");
		s.setYear("3rd");
//		s.setId(12);
		this.sr.save(s);
		
		Transection t=new Transection();
		t.setFine(50);
	     t.setStudent(s);
	     tr.save(t);
	     
	     return s;
		
		
		
	}
	
	
	
	
	
	
	
}
