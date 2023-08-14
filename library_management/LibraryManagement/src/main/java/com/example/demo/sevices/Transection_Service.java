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
import com.example.demo.repositories.BookRepo;
import com.example.demo.repositories.StudentRepo;
import com.example.demo.repositories.TransRepo;

@Service
public class Transection_Service {

	@Autowired
	private TransRepo tr;
	
	private StudentRepo sr;
	
	@Autowired
	ModelMapper modelMapper;
	
	
	public List<Transection> getAllTransections(){
		return this.tr.findAll();
	}
	
	public TransectionDto getTransectionById(int id) {
		Optional<Transection> op=this.tr.findById(id);
		
		Transection t1=op.get();
		
		TransectionDto tdto=modelMapper.map(t1, TransectionDto.class);
		
		return tdto;
		
	}
	
	
	//Create Transection
	
	public Transection CreateTransection(TransectionDto t1) {
		
		
	    
		Transection t=modelMapper.map(t1, Transection.class);
		
		
		Transection saved=this.tr.save(t);
		
		
		
		return saved;
	}
	
}
