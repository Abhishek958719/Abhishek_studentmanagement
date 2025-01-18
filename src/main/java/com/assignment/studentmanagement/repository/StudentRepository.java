package com.assignment.studentmanagement.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.studentmanagement.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	List<Student>findByNameContainingIgnoreCase(String name);
}
