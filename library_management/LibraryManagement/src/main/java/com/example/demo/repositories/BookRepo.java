package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Book;
import com.example.demo.entites.Transaction;

public interface BookRepo extends  JpaRepository<Book,Integer> {

	Optional<Book> findByName(String name);
 
//	List<Book> getByTransection(Transaction transection);
}
