# Student Management System

## Project Description

The **Student Management System** is an application designed to manage student records efficiently. It provides the ability to perform CRUD (Create, Read, Update, Delete) operations on student data through a simple and user-friendly interface.

## Core Functions

1. **Add a New Student Record**:
   - **Fields**:
     - **Name** (string, required)
     - **Age** (string, required)
     - **Class** (string, required)
     - **Phone Number** (number, required)

2. **Display All Student Records**

3. **Search Student Records by Name**

4. **Modify Existing Student Data**

5. **Remove Student Data**

---

## Key Design and Implementation Highlights

1. **Scalable and Clean Architecture**:
   - The application follows a clean architecture with well-defined layers:
     - **Controller Layer**: Handles API requests and responses.
     - **Service Layer**: Implements the business logic.
     - **Repository Layer**: Manages database operations.
   - Ensures separation of concerns, making the system maintainable and scalable.

2. **Object-Oriented Programming (OOP)**:
   - Employed OOP principles such as:
     - **Encapsulation**: Ensures data integrity by restricting direct access to fields.
     - **Abstraction**: Hides implementation details and exposes only necessary functionalities.
     - **Polymorphism**: Simplifies code modifications and enhances flexibility.
     - **Inheritance**: Reduces redundancy by sharing common functionalities across components.

3. **Caching with Redis**:
   - Implements caching to optimize performance by storing frequently accessed data.
   - Reduces load on the database and accelerates API response times.

4. **Database Management with MySQL**:
   - Utilizes a relational database to store student records.
   - Provides robust data consistency and supports complex queries for efficient data retrieval.

5. **Testing**:
   - Ensures code quality and functionality with:
     - **JUnit**: For unit testing.
     - **Mockito**: For mocking dependencies and testing isolated components.

6. **API-First Approach**:
   - Designed APIs before implementing the back-end to ensure seamless integration.
   - Ensures clear documentation and consistency across services.


7. **Error Handling and Logging**:
   - Implements robust error handling mechanisms to provide meaningful error messages to users and developers.
   - Integrated logging for tracking application behavior and debugging.

---

## Technologies Used

### Backend:
- Spring Boot
- Java

### Database:
- MySQL

### Build Tools:
- Maven

### Testing:
- JUnit
- Mockito

### Cache:
- Redis

---

## API Endpoints

| HTTP Method | Endpoint                      | Description            |
|-------------|-------------------------------|------------------------|
| GET         | `/api/students/{id}`          | Get student by ID      |
| POST        | `/api/students`               | Add a new student      |
| PUT         | `/api/students/{id}`          | Update student details |
| DELETE      | `/api/students/{id}`          | Delete student by ID   |
| GET         | `/api/students/search/{name}` | Search student by name |

---

## How to Run the Project

### Prerequisites:
1. Install Java (JDK 8 or above).
2. Install MySQL and create a database for the application.
3. Install Maven for build management.
4. Install Redis for caching.

### Steps to Run:
1. Clone the repository from [GitHub](#).
2. Configure the application properties file (`application.properties`) with your MySQL and Redis credentials.
3. Build the project using Maven:
   ```bash
   mvn clean install
