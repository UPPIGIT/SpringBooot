package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.StudentResults;
@Repository
public interface StudentRepository extends JpaRepository<StudentResults, Integer> {

}
