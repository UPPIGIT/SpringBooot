package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "STUDENT_RESULTS")
public class StudentResults {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roolNo;
	@NotBlank
	@Size(min = 1,message = "Name should not be empty")
	private String name;
	@NotNull
	private Integer marks;
	@NotBlank
	@Size(min = 1,message = "Grade should not be empty")
	private String grade;

	public StudentResults() {
	}

	

	public StudentResults(Integer roolNo, @NotBlank @Size(min = 1, message = "Name should not be empty") String name,
			@NotNull Integer marks, @NotBlank @Size(min = 1, message = "Grade should not be empty") String grade) {
		super();
		this.roolNo = roolNo;
		this.name = name;
		this.marks = marks;
		this.grade = grade;
	}



	@Column(name = "ROLLNO")
	public Integer getRoolNo() {
		return roolNo;
	}

	
	public void setRoolNo(Integer roolNo) {
		this.roolNo = roolNo;
	}

	@Column(name = "STUDENT_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "STUDENT_MARKS")
	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	@Column(name = "STUDENT_GRADE")
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}
