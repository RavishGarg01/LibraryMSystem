package com.example.demo.config;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Role;



@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    

    public CustomUserDetailsService(UserRepository userRepository,RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	com.example.demo.entites.User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        

//        return User.builder()
//                .username(user.getUsername())
//                .password(user.getPassword()) // Ensure password is encrypted
//                .roles(user.getRoles().split(",")) // Handle roles
//                .build();
        Set<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(), // Password should be encrypted (BCrypt)
                user.isEnabled(), // Enable or disable user based on status
                true, true, true, // Account non-expired, credentials non-expired, account non-locked
                authorities
        );
    }


// @PreAuthorize("hasRole('ADMIN_USER')")
//    public User promoteToMember(Long userId) {
//        User user = userRepository.findById(userId).orElseThrow("Error: User not found");
//        Role memberRole = roleRepository.findByName("MEMBER_USER").orElseThrow("Error: MEMBER_USER Role not found");
//        
//        user.getRoles().add(memberRole);
//        return userRepository.save(user);
//    }
// 
// 
// @PreAuthorize("hasRole('ROOT_USER')")
// public User promoteToAdmin(Long userId) {
//     User user = userRepository.findById(userId).orElseThrow();
//     Role adminRole = roleRepository.findByName("ADMIN_USER").orElseThrow();
//     
//     user.getRoles().add(adminRole);
//     return userRepository.save(user);
// }
}
