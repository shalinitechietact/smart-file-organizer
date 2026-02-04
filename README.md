📂 Smart File Organizer Backend

Smart File Organizer Backend is a Spring Boot REST API that allows users to upload files, automatically organize them based on file type, and store file metadata in a MySQL database.
This backend service handles file processing, storage, and database operations for the Smart File Organizer system.

# Features
Upload files using REST API
Automatically categorize files by type
Store file metadata in MySQL database
RESTful API design
Clean layered architecture (Controller, Service, Repository)

# Technologies Used
Java 17
Spring Boot
Spring Data JPA (Hibernate)
MySQL
Maven

# Project Structure
smart-file-organizer-backend/
│
├── controller
├── service
├── repository
├── model
├── SmartFileOrganizerApplication.java
└── pom.xml

# How It Works
Client sends file upload request.
Backend receives file through REST API.
File is stored in folder based on its type.
Metadata is saved in MySQL database.
Client can retrieve file details.

# Setup Instructions
git clone https://github.com/your-username/smart-file-organizer-backend.git

# Configure Database
Update application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/smartfiledb
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update

# Run Application
mvn spring-boot:run
Server runs on:
http://localhost:8080

# API Endpoints
| Method | Endpoint | Description           |
| ------ | -------- | --------------------- |
| POST   | /upload  | Upload file           |
| GET    | /files   | Get all file metadata |

# Testing
Use Postman to test APIs.

# Author

Shalini V
Java Developer
GitHub: https://github.com/shalinitechietact


