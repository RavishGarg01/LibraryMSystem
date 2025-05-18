package com.example.demo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.ApplicationContext; 
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//import com.example.demo.sevices.TestServiceClass;

@SpringBootApplication
public class LibraryManagementApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(LibraryManagementApplication.class, args);
		
//		 // Instantiate TestServiceClass using context.getBean()
//        TestServiceClass testClass = context.getBean(TestServiceClass.class);
//        
//        // Call the ServiceMethod on the instantiated TestServiceClass
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
	
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000") // Replace with your frontend URL
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*");
            }
        };
    }
    
}