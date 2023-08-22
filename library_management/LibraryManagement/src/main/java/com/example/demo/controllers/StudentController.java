package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.BookDto;
import com.example.demo.dtos.StudentDto;
import com.example.demo.entites.Student;
import com.example.demo.entites.Transaction;
import com.example.demo.sevices.StudentService;
import com.example.demo.sevices.TransactionService;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/student")
	public void addStudent(@RequestBody StudentDto student) {
		System.out.println("I m in StudentController");
		this.studentService.addStudent(student);
	}
	
	@GetMapping("/student/{id}")
	public Student getById(@PathVariable("id")int id) {
		return this.studentService.getSingleStudent(id);
	}
	
	
	@GetMapping("/student")
	public List<Student> getAll(){
		return this.studentService.getAllStudents();
	}
	
	@PutMapping("student/{id}")
	public void updateStudentInfo(@PathVariable("id")int id,@RequestBody StudentDto studentDto) {
		this.studentService.UpdateStudent(id, studentDto);
	}
	
	@DeleteMapping("/student")
	public void deleteStudent(@PathVariable("id")int id) {
		this.studentService.deleteStudent(id);
	}
	
	@GetMapping("/student/books")
	public Optional<Transaction> issuedBooks(@RequestBody Student studentDto){
		System.out.println("I m in student controller");
		return this.transactionService.getAllTransactionByStudentAndReturnDate(studentDto);
	}
	
	

}
