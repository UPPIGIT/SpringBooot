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

import com.springboot.dao.EmployeeRepository;
import com.springboot.exception.ResourceNotFoundException;
import com.springboot.model.Employee;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;

	@GetMapping("/allEmps")
	public List<Employee> getAllEmployess() {
		return repository.findAll();
	}

	@GetMapping("/emp/{Id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable("Id") Integer Id) throws ResourceNotFoundException {

		Employee employee = null;
		
			employee = repository.findById(Id).get();
		if (employee==null) {
			throw new ResourceNotFoundException("Employee not found for the this Id.." + Id);	
		}
			
			
		

		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("/createEmp")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return repository.save(employee);
	}

	@PutMapping("/emps/{Id}")
	public ResponseEntity<Employee> updateEmp(@PathVariable("Id") Integer Id, @Valid @RequestBody Employee employee)
			throws ResourceNotFoundException {

		Employee employeeFromDb;
		try {
			employeeFromDb = repository.findById(Id).get();
			employeeFromDb.setFirstName(employee.getFirstName());
			employeeFromDb.setLastName(employee.getFirstName());
			employeeFromDb.setEmailId(employee.getEmailId());
			employeeFromDb.setPassportNumber(employee.getPassportNumber());

		} catch (Exception e) {
			// TODO: handle exception

			throw new ResourceNotFoundException("Employee not found for this Id :" + Id);
		}

		Employee updatedEmp = repository.save(employeeFromDb);

		return ResponseEntity.ok(updatedEmp);

	}

	@DeleteMapping("/delete/{Id}")
	public Map<String, Boolean> deleteEmp(@PathVariable("Id") Integer Id) throws ResourceNotFoundException {
		Employee employeeFromDb;
		try {
			employeeFromDb = repository.findById(Id).get();

		} catch (Exception e) {
			// TODO: handle exception

			throw new ResourceNotFoundException("Employee not found for this Id :" + Id);
		}
		repository.delete(employeeFromDb);
		
		Map<String, Boolean> response=new HashMap<>();
		
		response.put("deleted", Boolean.TRUE);

		return response;

	}

}
