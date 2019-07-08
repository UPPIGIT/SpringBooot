package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.dao.EmployeeRepository;
import com.springboot.model.Employee;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext	applicationContext= SpringApplication.run(SpringbootApplication.class, args);
	
	EmployeeRepository employeeRepository=	applicationContext.getBean("employeeRepository", EmployeeRepository.class);
	
	Employee e1= new Employee("upender","tadewar","uppi@gmail.com","12344");
	employeeRepository.save(e1);
	Employee e2= new Employee("sruthu","pardiwar","sru@gmail.com","56482");
	employeeRepository.save(e2);
	Employee e3=new Employee("aadhya","shrisha","aadhya@gmail.com","99856");
	employeeRepository.save(e3);
	
	
	}

}
