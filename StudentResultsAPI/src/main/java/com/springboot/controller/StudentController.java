package com.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dao.StudentRepository;
import com.springboot.exception.ResourceNotFoundException;
import com.springboot.model.StudentResults;

@RestController
@RequestMapping("/StudentResultsAPI/v1")
public class StudentController {

	@Autowired
	private StudentRepository repository;

	@GetMapping("/allstudents")
	public List<StudentResults> getAllResults() {
		return repository.findAll();
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<StudentResults> resultById(@PathVariable Integer id) throws ResourceNotFoundException {
		
		StudentResults results=null;
		try {
			results = repository.findById(id).get();
		} catch (Exception e) {
			throw new ResourceNotFoundException("Invalid Roll no. No results found.");
		}
		return ResponseEntity.ok().body(results);
	}
	
	@PostMapping("/addstudent")
	public ResponseEntity<List<StudentResults>> addStudentResults(@Valid @RequestBody List<StudentResults> results)

	{
		
		return (ResponseEntity<List<StudentResults>>) repository.saveAll(results);
		
	}
	
	@PutMapping("/updateStudent/{Id}")
	public ResponseEntity<StudentResults> updateResults(@PathVariable Integer Id , @RequestBody StudentResults results) throws ResourceNotFoundException{
	
		StudentResults resultsFromDb=null;
		
		try {
			
			resultsFromDb=repository.findById(Id).get();
			resultsFromDb.setRoolNo(results.getRoolNo());
			resultsFromDb.setName(results.getName());
			resultsFromDb.setGrade(results.getGrade());
			resultsFromDb.setMarks(results.getMarks());
			
			
			
		} catch (Exception e) {
			throw new ResourceNotFoundException("Invalid Roll no..no records found for this id");
		}
		
		StudentResults updatedResults=repository.save(resultsFromDb);
		
		return ResponseEntity.ok(updatedResults);
	}
	
	@DeleteMapping("/deleteStudent/{Id}")
	public Map<String, Boolean> deleteResults(@PathVariable Integer Id)
	{
		
		StudentResults resultsFromDb=repository.findById(Id).get();
		
		repository.delete(resultsFromDb);
		
		Map<String, Boolean> response=new HashMap<String, Boolean>();
		
		response.put("Record deletes", Boolean.TRUE);
		
		return response;
	}
		
	
}
