package com.example.springbootdemo;

import com.example.springbootdemo.domain.Employee;
import com.example.springbootdemo.repository.EmployeeReposittory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootDemoApplication {

	@Bean
	public  CommandLineRunner init(EmployeeReposittory reposittory){
	return  (args -> {
		reposittory.save(new Employee("jonh","show"));
		reposittory.save(new Employee("show","john"));
	});
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

}
