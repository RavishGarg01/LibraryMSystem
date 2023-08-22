package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.TransectionDto;
import com.example.demo.entites.Transection;
import com.example.demo.sevices.Transection_Service;

@RestController
public class TransectionController {
	
	@Autowired
	private Transection_Service ts;
	
	
	@GetMapping("/transection")
  public List<Transection> getAll(){
	  return this.ts.getAllTransections();
  }
  
	@GetMapping("/transection/{id}")
  public TransectionDto getById(@PathVariable("id" ) int id) {
	  return this.ts.getTransectionById(id);
  }
	
	//Create Transection
	@PostMapping("/transection")
	public TransectionDto addTransection(@RequestBody TransectionDto trans) {
		System.out.println("I an currently here in controller");
		return this.ts.CreateTransection(trans);
		
	}
	

}
