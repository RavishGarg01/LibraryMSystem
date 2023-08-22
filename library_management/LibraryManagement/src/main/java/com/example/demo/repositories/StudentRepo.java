package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Student;

public interface StudentRepo extends JpaRepository<Student,Integer> {

	Optional<Student> findByName(String name);
}
