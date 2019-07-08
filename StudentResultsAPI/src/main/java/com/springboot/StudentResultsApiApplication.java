package com.springboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.dao.StudentRepository;
import com.springboot.model.StudentResults;

@SpringBootApplication
public class StudentResultsApiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(StudentResultsApiApplication.class,
				args);
		
	StudentRepository repository=	applicationContext.getBean("studentRepository",StudentRepository.class);
		
		StudentResults s1= new StudentResults(0, "Upender", 520, "A");
		StudentResults s2= new StudentResults(0, "abc", 362, "B");
		StudentResults s3= new StudentResults(0, "sruthi", 530, "A");
		StudentResults s4= new StudentResults(0, "aadhya", 598, "A");
		StudentResults s5= new StudentResults(0, "shreshat", 550, "A");
		
		List<StudentResults> results=Arrays.asList(s1,s2,s3,s4,s5);
		
		repository.saveAll(results);
		
	}

}
