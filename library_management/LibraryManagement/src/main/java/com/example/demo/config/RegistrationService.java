package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Role;
import com.example.demo.entites.User;

import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerUser(String username, String rawPassword) {
        // Check if the user already exists
        if (userRepository.findByUsername(username) != null) {
            throw new RuntimeException("Username already exists");
        }

        // Create a new user and save to database
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(rawPassword)); // Encrypt password
        
        Role defaultRole = roleRepository.findByName("DEFAULT_USER");
//                .orElseThrow(() -> new RuntimeException("Role not found"));
         user.getRoles().add(defaultRole);
//        user.setRoles(roles); // Assign roles
        userRepository.save(user);

        return "User registered successfully";
    }
}
