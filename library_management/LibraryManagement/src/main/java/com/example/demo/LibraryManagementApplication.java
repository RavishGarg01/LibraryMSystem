package com.example.demo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.ApplicationContext; 

import com.example.demo.sevices.TestClass;

@SpringBootApplication
public class LibraryManagementApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(LibraryManagementApplication.class, args);
		
//		 // Instantiate TestClass using context.getBean()
//        TestClass testClass = context.getBean(TestClass.class);
//        
//        // Call the ServiceMethod on the instantiated TestClass
//        testClass.ServiceMethod();
//        
//        // Close the application context
//   
//        
	}
 

	@Bean
    public ModelMapper modelMapper() {
    	return new ModelMapper();
    	
    }
    
}