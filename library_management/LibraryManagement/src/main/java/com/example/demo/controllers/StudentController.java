package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.example.demo.entites.Book;
import com.example.demo.entites.Student;
import com.example.demo.entites.Transaction;
import com.example.demo.services.StudentService;
import com.example.demo.services.TransactionService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private TransactionService transactionService;

	@PostMapping("/student")
	public ResponseEntity<String> addStudent(@RequestBody StudentDto student) {
		try {
			String status = this.studentService.addStudent(student);
			return new ResponseEntity(status, HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getById(@PathVariable("id") int id) {
		try {
			Student student = this.studentService.getSingleStudent(id);
			return new ResponseEntity(student, HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/student")
	public ResponseEntity<List<Student>> getAll() {
		try {
			List<Student> studentList = this.studentService.getAllStudents();
			return new ResponseEntity(studentList, HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("student/{id}")
	public ResponseEntity<String> updateStudentInfo(@PathVariable("id") int id, @RequestBody StudentDto studentDto) {
		try {
			String status = this.studentService.UpdateStudent(id, studentDto);
			return new ResponseEntity(status, HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/student")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") int id) {
		this.studentService.deleteStudent(id);
		try {
			String status = this.studentService.deleteStudent(id);
			return new ResponseEntity(status, HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/student/books")
	public ResponseEntity<Optional<List<BookDto>>> issuedBooks(@RequestBody Student studentDto) {
		try {
			System.out.println("I m here in contoller");
			Optional<List<BookDto>> status = this.transactionService.getAllTransactionByStudentAndReturnDate(studentDto);
			return new ResponseEntity(status, HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/student-by-approxname")
	public List<Student> searchBooks(@RequestBody StudentDto studentDto) {
		return studentService.searchByApproxName(studentDto.getName());
	}

}
