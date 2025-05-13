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
import com.example.demo.services.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@GetMapping("/transection")
	public ResponseEntity<List<Transaction>> getAll() {
		try {
			List<Transaction> transactionList = this.transactionService.getAllTransections();
			return new ResponseEntity(transactionList, HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/transection/{id}")
	public ResponseEntity<TransactionDto> getById(@PathVariable("id") int id) {
		try {
			TransactionDto transactionDto = this.transactionService.getTransectionById(id);
			return new ResponseEntity(transactionDto, HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/transection/issue")
	public ResponseEntity<Transaction> issueBook(@RequestBody TransactionDto transactionDto) throws Exception {
		try {
			Transaction transaction = this.transactionService.issueBook(transactionDto);
			return new ResponseEntity(transaction, HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/transection/return")
	public ResponseEntity<Transaction> returnBook(@RequestBody TransactionDto transactionDto) throws ParseException {
		try {
			Transaction transaction = this.transactionService.returnBook(transactionDto);
			return new ResponseEntity(transaction, HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

}
