Exam Enrollment System RESTful API Documentation
Overview
Develop a RESTful API service using Spring Boot to manage the exam enrollment process for a Learning Management System (LMS) with MySQL as the database.

Requirements
Functional Requirements
CRUD Operations:

Handle Create, Read, Update, and Delete operations for Students, Subjects, and Exams.
Business Logic:

Students can register for exams only if they are enrolled in the corresponding subjects.
Error Handling:

Handle common errors gracefully using @ControllerAdvice and GlobalExceptionHandler.
Testing:

Include unit tests using MockMvc and Mockito.
Entities
Student:

Student Registration ID (Unique Identifier)
Student Name
List of enrolled Subjects
List of registered Exams
Subject:

Subject ID (Unique Identifier)
Subject Name
List of registered Students
Exam:

Exam ID (Unique Identifier)
Subject
List of enrolled Students
Relationships
Student-Subject: Many-to-Many
Student-Exam: Many-to-Many
Subject-Exam: One-to-Many
Implementation Steps
Project Setup:

Create a Spring Boot project with dependencies: Spring Web, Spring Data JPA, MySQL Driver, Lombok, Spring Boot DevTools.
Configure MySQL Database:

Set up the database connection in application.properties.
Define Entities:

Create entities for Student, Subject, and Exam with appropriate annotations.
Create Repositories:

Define JPA repositories for each entity.
Implement Service Layer:

Create services for handling business logic for each entity.
Implement Controller Layer:

Develop REST controllers to handle HTTP requests.
Exception Handling:

Use @ControllerAdvice and GlobalExceptionHandler to manage exceptions and return appropriate HTTP status codes.
Testing:

Write unit tests for controllers and services using MockMvc and Mockito.
