package com.example.demo.sevices;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.TransectionDto;
import com.example.demo.entites.Book;
import com.example.demo.entites.Student;
import com.example.demo.entites.Transection;
import com.example.demo.repositories.StudentRepo;
import com.example.demo.repositories.TransRepo;

@Service
public class Transection_Service {

	@Autowired
	private TransRepo tr;
	
	@Autowired
	private StudentRepo sr;
	
//	@Autowired
//	private BookRepo br;
	
	@Autowired
	ModelMapper modelMapper;
	
	
	public List<Transection> getAllTransections(){
		return this.tr.findAll();
	}
	
	
	public TransectionDto getTransectionById(int id) {
		Optional<Transection> op=this.tr.findById(id);
		
		Transection t1=op.get();
//		Book b=t1.getBook();
		Student s=t1.getStudent();
		
		
		TransectionDto tdto=modelMapper.map(t1, TransectionDto.class);
//		tdto.setBookid(b.getBookId());
		tdto.setStudentid(s.getId());
		
		return tdto;
		
	}
	
	
	//Create Transaction
	
	public TransectionDto CreateTransection(TransectionDto t1) {
		System.out.println("I an currently here");
		Integer sid= t1.getStudentid();
//		int bid=t1.getBookid();
		
		
		//Student
		Student student=this.sr.findById(sid).get();
		
		
		//BOOK
//		Book book=this.br.findById(bid).get();
		
		
		
		Transection t=modelMapper.map(t1, Transection.class);
//		t.setBook(book);
		t.setStudent(student);
		
		Transection saved=this.tr.save(t);
		
		return t1;
	}
	
}
