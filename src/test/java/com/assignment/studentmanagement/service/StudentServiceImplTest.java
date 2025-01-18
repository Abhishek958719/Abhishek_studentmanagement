package com.assignment.studentmanagement.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.assignment.studentmanagement.exceptions.StudentNotFoundException;
import com.assignment.studentmanagement.model.Student;
import com.assignment.studentmanagement.repository.StudentRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

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
    void addStudent_ShouldSaveStudent() {
        when(studentRepository.save(student)).thenReturn(student);

        Student savedStudent = studentService.addStudent(student);

        assertNotNull(savedStudent);
        assertEquals("John Doe", savedStudent.getName());
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    void getAllStudents_ShouldReturnStudentList() {
        when(studentRepository.findAll()).thenReturn(Arrays.asList(student));

        List<Student> students = studentService.getAllStudent();

        assertEquals(1, students.size());
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    void getStudentById_ShouldReturnStudent_WhenStudentExists() {
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        Student foundStudent = studentService.getStudentById(1L);

        assertNotNull(foundStudent);
        assertEquals(1L, foundStudent.getId());
        verify(studentRepository, times(1)).findById(1L);
    }

    @Test
    void getStudentById_ShouldThrowException_WhenStudentDoesNotExist() {
        when(studentRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(StudentNotFoundException.class, () -> studentService.getStudentById(1L));
        verify(studentRepository, times(1)).findById(1L);
    }

    @Test
    void deleteStudent_ShouldDeleteStudent() {
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        studentService.deleteStudent(1L);

        verify(studentRepository, times(1)).delete(student);
    }
}