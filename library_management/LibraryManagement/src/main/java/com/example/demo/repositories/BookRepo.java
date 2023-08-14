package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Book;
import com.example.demo.entites.Transection;

public interface BookRepo extends  JpaRepository<Book,Integer> {
 
	List<Book> getByTransection(Transection transection);
}
