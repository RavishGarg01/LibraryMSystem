package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Book;
import com.example.demo.entites.Transaction;

public interface  TransRepo extends JpaRepository<Transaction,Integer> {
	List<Transaction> findByBook(Book book);
}
