package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.TransactionDto;
import com.example.demo.entites.Transaction;
import com.example.demo.sevices.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	
	@GetMapping("/transection")
  public List<Transaction> getAll(){
	  return this.transactionService.getAllTransections();
  }
  
	@GetMapping("/transection/{id}")
  public TransactionDto getById(@PathVariable("id" ) int id) {
	  return this.transactionService.getTransectionById(id);
  }
	
	
	@PostMapping("/transection")
	public Transaction addTransaction(@RequestBody TransactionDto trans) {
		System.out.println("I m in TransactionController");
		System.out.println(trans);
		return this.transactionService.CreateTransaction(trans);
		
	}
	

}
