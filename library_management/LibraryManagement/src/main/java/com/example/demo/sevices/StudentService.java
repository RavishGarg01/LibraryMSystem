package com.example.demo.sevices;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.BookDto;
import com.example.demo.dtos.StudentDto;
import com.example.demo.entites.Student;
import com.example.demo.entites.Transaction;
import com.example.demo.repositories.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
//	@Autowired
//	private TransactionService transactionService;
	
	public void addStudent(StudentDto studentDto) {
		Student student =modelMapper.map(studentDto, Student.class);
		this.studentRepo.save(student);
	}
	
	public Student getSingleStudent(int id) {
		Optional<Student> studentList=this.studentRepo.findById(id);
		Student student=studentList.get();
		return student;
	}
	
	public List<Student> getAllStudents(){
		return this.studentRepo.findAll();
	}
	
	public void UpdateStudent(int id,StudentDto studentDto) {
		Optional<Student> studentList=this.studentRepo.findById(id);
		Student student=studentList.get();
		student.setName(studentDto.getName());
		student.setBranch(studentDto.getBranch());
		student.setYear(studentDto.getYear());
		this.studentRepo.save(student);
	}
	
	public void deleteStudent(int id) {
		this.studentRepo.deleteById(id);
	}
	
	public Student getByName(String name) {
		Optional<Student> studentList= this.studentRepo.findByName(name);
		if(studentList.isPresent()) {
		Student student=studentList.get();
//		BookDto bookDto=modelMapper.map(book,BookDto.class);
		return student;
		}
		else {
			return null;
		}
	}
//	public List<BookDto> issuedBooks(StudentDto studentDto){
//		Optional<Transaction>transactionList=transactionService.getAllTransactionByStudentAndReturnDate(modelMapper.map(studentDto, Student.class));
//		List <BookDto> bookList=transactionList.stream().map(transaction->modelMapper.map(transaction.getBook(),BookDto.class) ).collect(Collectors.toList());
//		return bookList;
//	}
//	public Optional<Transaction> issuedBooks(Student student){
//		return transactionService.getAllTransactionByStudentAndReturnDate(student);
//		
//	}
//	
}
