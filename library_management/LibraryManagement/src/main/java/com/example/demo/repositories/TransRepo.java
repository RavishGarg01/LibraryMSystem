package com.example.demo.repositories;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Book;
import com.example.demo.entites.Student;
import com.example.demo.entites.Transaction;

public interface  TransRepo extends JpaRepository<Transaction,Integer> {
	List<Transaction> findByBook(Book book);

	Optional<List<Transaction>> findByStudentAndReturnDate(Student student, Date returnDate);

	Optional<Transaction> findByBookAndStudentAndReturnDate(Book book, Student student, Date returnDate);
}
