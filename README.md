# Abhishek Kumar

Student Management System

Project Description

Student Management Application:
Student management application is designed to manage student records. The
system allows user to perform basic create, read, update and delete operations on
student data. The application aims to be simple, efficient and user friendly.
Core functions:
The application should be able to

	A) add a new student record with the following fields
		1) name(string, required)
		2) age(string, required)
		3) class(string, required)
		4) phone number(number, required)
	B) display all student records
	C) search student records by name
	D) modify existing student data
	E) remove student data
Notes:
1. Above project can be developed as simple back-end and/or a front-end app.
Bonus points for applications with both back-end and front-end.
2. Follow API first approach.
3. Leverage design patterns as needed.
4. Preferred technologies backend are J2EE/Spring Boot, front end React or
other UI frameworks or vanilla JS , html and css but other similar
technologies can also be used.
5. Code can be shared in zip or git hub

Technologies Used

Backend:
	Spring Boot
	Java
	Maven
Database:
	MySQL

Build Tools:
	Maven

Testing:
	JUnit
	Mockito

Cache:

	Redis

API Endpoints


HTTP Method	Endpoint	  Description
GET	/api/students/{id}	  Get student by ID
POST	/api/students	          Add a new student
PUT	/api/students/{id}	  Update student details
DELETE	/api/students/{id}	  Delete student by ID
GET.    /api/students/search/{id} Search Student By name


