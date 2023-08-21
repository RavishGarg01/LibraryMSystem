package com.example.demo.sevices;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Book;
import com.example.demo.entites.Transaction;
import com.example.demo.repositories.BookRepo;
import com.example.demo.repositories.TransRepo;

@Service
public class TestServiceClass {
	
	
	@Autowired
	private TransRepo transRepo;
	
	@Autowired
	private BookRepo bookRepo;
	
	@Autowired
	ModelMapper modelMapper;
	public void  ServiceMethod() {
		Book b1=new Book();
		b1.setName("The pillars of the earth");
		b1.setAuthor("Ken follett"); 
		b1.setIsissued(true);
		bookRepo.save(b1);
		Transaction transaction1 =new Transaction();
		transaction1.setBook(b1);
//		transaction1.setIssuedate("11-10-23");
		transRepo.save(transaction1);
		Transaction transaction2 =new Transaction();
		transaction2.setBook(b1);
//		transaction2.setIssuedate("18-10-23");
		transRepo.save(transaction2);
		
		List <Transaction>transactionList=new ArrayList<>();
		transactionList.add(transaction1);
		transactionList.add(transaction2);
		b1.setTransactionList(transactionList);
		bookRepo.save(b1);
		
		List<Transaction> transactions = transRepo.findByBook(b1);

        // Print the list of transactions using System.out.println()
        System.out.println("Transactions for Book: " + b1.getName());
        for (Transaction transaction : transactions) {
            System.out.println("Transaction ID: " + transaction.getReferenceId());
            // Print other relevant transaction details
        }
	}
	
	
	
	
}
