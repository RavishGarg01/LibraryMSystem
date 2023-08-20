package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.StudentDto;
import com.example.demo.entites.Student;
import com.example.demo.sevices.StudentServices;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class StudentController {
	
	@Autowired
	private StudentServices ss;
	
	@PostMapping("/student")
	public void addStudent(@RequestBody StudentDto student) {
		System.out.println("I m in StudentController");
		this.ss.addStudent(student);
		
	}
	
	@GetMapping("/student/{id}")
	public Student getById(@PathVariable("id")int id) {
		
		return this.ss.getSingleStudent(id);
		
	}
	
	
	@GetMapping("/student")
	public List<Student> getAll(){
		return this.ss.getAllStudents();
	}
	
	@PutMapping("student/{id}")
	public void updateStudentInfo(@PathVariable("id")int id,@RequestBody Student student) {
		this.ss.UpdateStudent(id, student);
	}
	
	@DeleteMapping("/student")
	public void deleteStudent(@PathVariable("id")int id) {
		this.ss.deleteStudent(id);
	}
	
	
	
	

}
