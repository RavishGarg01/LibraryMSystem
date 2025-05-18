package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Book;

public interface BookRepo extends  JpaRepository<Book,Integer> {

	Optional<List<Book>> findByName(String name);
	List<Book> findByNameContaining(String searchTerm);
}
