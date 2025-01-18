package com.assignment.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.studentmanagement.model.Student;
import com.assignment.studentmanagement.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentApiController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public ResponseEntity<Student> addStudent(@Validated @RequestBody Student student){
		
		return ResponseEntity.ok(studentService.addStudent(student));
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents(){
		
		return ResponseEntity.ok(studentService.getAllStudent());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id){
		return ResponseEntity.ok(studentService.getStudentById(id));
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Student>> getStudentsByName(@RequestParam String name){
		
		return ResponseEntity.ok(studentService.searchStudentByName(name));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudentByid(@PathVariable Long id,@RequestBody Student student){
		return ResponseEntity.ok(studentService.updateStudent(id, student));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudentById(@PathVariable Long id){
		studentService.deleteStudent(id);
		return ResponseEntity.noContent()
.build()	;}
}
