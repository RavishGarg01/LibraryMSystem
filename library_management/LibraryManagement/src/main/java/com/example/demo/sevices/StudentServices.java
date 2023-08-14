package com.example.demo.sevices;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.StudentDto;
import com.example.demo.entites.Student;
import com.example.demo.entites.Transection;
import com.example.demo.repositories.StudentRepo;
import com.example.demo.repositories.TransRepo;

@Service
public class StudentServices {

	@Autowired
	private StudentRepo sr;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private TransRepo tr;
	
	public void addStudent(StudentDto student) {
		
	
		
		Student st=modelMapper.map(student, Student.class);
		
	
		
		this.sr.save(st);
		
	}
	public Student getSingleStudent(int id) {
		
	Optional<Student> s=this.sr.findById(id);
		
		Student student=s.get();
		
		return student;
		
	}
	
	public List<Student> getAllStudents(){
		
		return this.sr.findAll();
	}
	
	public void UpdateStudent(int id,Student student) {
		
		Student s1=new Student();
		
		s1.setId(id);
		s1.setName(student.getName());
		s1.setBranch(student.getBranch());
		s1.setCourse(student.getCourse());
		s1.setYear(student.getYear());
		
		this.sr.save(s1);
	}
	public void deleteStudent(int id) {
		this.sr.deleteById(id);
		
	}
	
}
