package com.example.demo.config;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Role;
import com.example.demo.entites.User;

public interface RoleRepository extends JpaRepository<Role, String> {
	Role findByRole(String Id);
	Role findByName(String Id);
}
