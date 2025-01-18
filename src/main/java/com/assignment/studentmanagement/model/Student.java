package com.assignment.studentmanagement.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Name is Required")
	private String name;
	
	@NotEmpty(message = "Age is Required")
	private String age;
	
	@NotEmpty(message="Class is Required")
	private String studentClass;
	
	@NotEmpty(message="Phone no is Required")
	@Pattern(regexp="\\d{10}", message="Phone No must be 10 Digit")
	private String phoneNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Student(Long id, @NotEmpty(message = "Name is Required") String name,
			@NotEmpty(message = "Age is Required.") String age,
			@NotEmpty(message = "Class is Required.") String studentClass,
			@NotEmpty(message = "Phone no is Required.") @Pattern(regexp = "\\d{10", message = "Phone No must be 10 Digit") String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.studentClass = studentClass;
		this.phoneNumber = phoneNumber;
	}
	public Student() {
		
	}
	
	
	
}
