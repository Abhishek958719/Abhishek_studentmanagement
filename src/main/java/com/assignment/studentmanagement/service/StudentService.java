package com.assignment.studentmanagement.service;

import java.util.List;

import com.assignment.studentmanagement.model.Student;

public interface StudentService {
	Student addStudent(Student student);
	List<Student>getAllStudent();
	Student getStudentById(Long name);
	List<Student>searchStudentByName(String name);
	Student updateStudent(Long id, Student student);
	void deleteStudent(Long id);
}
