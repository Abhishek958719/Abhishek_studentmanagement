package com.assignment.studentmanagement.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.assignment.studentmanagement.model.Student;
import com.assignment.studentmanagement.service.StudentService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentApiControllerTest {

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentApiController studentApiController;

    private Student student;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        student = new Student();
        student.setId(1L);
        student.setName("John Doe");
        student.setAge("21");
        student.setStudentClass("12th Grade");
        student.setPhoneNumber("9876543210");
    }

    @Test
    void addStudent_ShouldReturnSavedStudent() {
        when(studentService.addStudent(student)).thenReturn(student);

        ResponseEntity<Student> response = studentApiController.addStudent(student);

        assertNotNull(response.getBody());
        assertEquals("John Doe", response.getBody().getName());
        verify(studentService, times(1)).addStudent(student);
    }

    @Test
    void getAllStudents_ShouldReturnStudentList() {
        when(studentService.getAllStudent()).thenReturn(Arrays.asList(student));

        ResponseEntity<List<Student>> response = studentApiController.getAllStudents();

        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        verify(studentService, times(1)).getAllStudent();
    }

    @Test
    void getStudentById_ShouldReturnStudent() {
        when(studentService.getStudentById(1L)).thenReturn(student);

        ResponseEntity<Student> response = studentApiController.getStudentById(1L);

        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());
        verify(studentService, times(1)).getStudentById(1L);
    }

    @Test
    void updateStudent_ShouldReturnUpdatedStudent() {
        when(studentService.updateStudent(1L, student)).thenReturn(student);

        ResponseEntity<Student> response = studentApiController.updateStudentByid(1L, student);

        assertNotNull(response.getBody());
        assertEquals("John Doe", response.getBody().getName());
        verify(studentService, times(1)).updateStudent(1L, student);
    }

    @Test
    void deleteStudent_ShouldReturnNoContent() {
        doNothing().when(studentService).deleteStudent(1L);

        ResponseEntity<Void> response = studentApiController.deleteStudentById(1L);

        assertEquals(204, response.getStatusCodeValue());
        verify(studentService, times(1)).deleteStudent(1L);
    }
}
