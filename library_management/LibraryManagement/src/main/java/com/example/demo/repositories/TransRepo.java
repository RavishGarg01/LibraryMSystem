package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entites.Transection;

public interface  TransRepo extends JpaRepository<Transection,Integer> {

}
