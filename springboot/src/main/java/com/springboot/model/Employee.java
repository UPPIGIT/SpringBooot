package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity
@Table(name="EMPlOYEE")
public class Employee {
	
	private Integer empId;
	
	@NonNull
	@Size(min=2 , message = "First Name should have atleast 2 chars")
	private String firstName;
	
	@NonNull
	@Size(min=2 , message = "Last Name should have atleast 2 chars")
	private String lastName;
	
	@Email
	@NotBlank
	private String emailId;
	
	@NonNull
	@Size(min=2 , message = "passport should have atleast 2 chars")
	private String passportNumber;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMP_ID")
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	
	@Column(name = "FIRST_NAME" ,nullable = false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "LAST_NAME" ,nullable = false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "EMAIL_ID" ,nullable = false)
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Column(name = "PASSPORT_NUMBER" ,nullable = false)
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public Employee(@Size(min = 2, message = "First Name should have atleast 2 chars") String firstName,
			@Size(min = 2, message = "Last Name should have atleast 2 chars") String lastName,
			@Email @NotBlank String emailId,
			@Size(min = 2, message = "passport should have atleast 2 chars") String passportNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.passportNumber = passportNumber;
	}
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
