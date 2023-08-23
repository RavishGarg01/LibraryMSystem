package com.example.demo.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	
	@PostMapping("/transection/issue")
	public ResponseEntity<Transaction> issueBook(@RequestBody TransactionDto transactionDto) {
		System.out.println("I m in TransactionController");
		System.out.println(transactionDto);
		return new ResponseEntity(this.transactionService.issueBook(transactionDto),HttpStatus.OK);
	
	}
	@PostMapping("/transection/return")
	public Transaction returnBook(@RequestBody TransactionDto transactionDto) throws ParseException {
		System.out.println("I m in TransactionController");
		System.out.println(transactionDto);
		return this.transactionService.returnBook(transactionDto);
		
	}
	

}
