package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private CustomUserDetailsService userService;

    @PostMapping("/promote-member/{userId}")
    public ResponseEntity<?> promoteUser(@PathVariable Long userId) {
//        userService.promoteToMember(userId);
        return ResponseEntity.ok("User promoted to MEMBER_USER");
    }
}
