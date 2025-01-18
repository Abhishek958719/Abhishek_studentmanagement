package com.assignment.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.assignment.studentmanagement.exceptions.StudentNotFoundException;
import com.assignment.studentmanagement.model.Student;
import com.assignment.studentmanagement.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	@CacheEvict(value="students", allEntries= true)
	public Student addStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	@Cacheable(value="students")
	public List<Student> getAllStudent() {
		
		return studentRepository.findAll();
	}

	@Override
	@Cacheable(value="students", key="#id")
	public Student getStudentById(Long id) {
		
		return studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("Student not found for the given Id"));
				
	}
	

	@Override
	public List<Student> searchStudentByName(String name) {
		
		return studentRepository.findByNameContainingIgnoreCase(name);
	}

	@Override
	@CacheEvict(value="students", allEntries=true)
	public Student updateStudent(Long id, Student student) {
		
		Student existingStudent = getStudentById(id);
		existingStudent.setName(student.getName());
		existingStudent.setAge(student.getAge());
		existingStudent.setStudentClass(student.getStudentClass());
		existingStudent.setPhoneNumber(student.getPhoneNumber());
		return studentRepository.save(existingStudent);
		
		
		
	}

	@Override
	@CacheEvict(value="students", allEntries=true)
	public void deleteStudent(Long id) {
		Student student = getStudentById(id);
		
		studentRepository.delete(student);
		
		
		
	}

}
