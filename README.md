# 🚀 Shortly – Secure URL Management & Analytics Platform

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Spring Security](https://img.shields.io/badge/Spring%20Security-6.x-green)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue)
![JWT](https://img.shields.io/badge/JWT-Security-red)
![Maven](https://img.shields.io/badge/Maven-Build-red)

Shortly is a secure full-stack URL management platform built using **Java, Spring Boot, Spring Security, JWT, Hibernate, MySQL, and React**. It enables authenticated users to create, manage, and analyze shortened URLs through a secure dashboard.

The backend follows a layered architecture with secure JWT-based authentication, RESTful APIs, and MySQL database integration, while the React frontend provides an intuitive interface for URL management and analytics.

---

# ✨ Features

## 🔐 Authentication & Security

- User Registration
- User Login
- JWT-based Authentication
- BCrypt Password Encryption
- Protected REST APIs
- User-specific Authorization

---

## 🔗 URL Management

- Generate Unique Short URLs
- URL Redirection
- Duplicate URL Prevention
- URL Validation
- Search Links
- Delete Links

---

## 📊 Analytics Dashboard

Monitor the performance of your shortened URLs with built-in analytics.

- Total Links
- Total Clicks
- Average Clicks
- Top Performing Link
- Click Count Tracking
- Created Date
- Last Accessed

---

## ⚙️ Backend Features

- Layered Architecture
- RESTful API Development
- Spring Security Integration
- Spring Data JPA and Hibernate
- Input Validation
- Global Exception Handling
- Pagination
- MySQL Database Integration
---

# 🛠 Tech Stack

## Backend

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- REST APIs
- JWT Authentication
- Maven

---

## Frontend

- React.js
- React Router
- Axios
- CSS3
- Vite

---

## Database

- MySQL

---

## Tools

- IntelliJ IDEA
- VS Code
- Postman
- MySQL Workbench
- Git
- GitHub
---

# 🏗 Architecture

The application follows a layered architecture to ensure separation of concerns, maintainability, and scalability.

```
                    React Frontend
                           │
                     Axios HTTP Client
                           │
                    Spring Boot Backend
                           │
                   Spring Security (JWT)
                           │
                     REST Controllers
                           │
                    Service Layer
                           │
                 Spring Data JPA Repository
                           │
                        Hibernate
                           │
                         MySQL
```

## Request Flow

1. The user interacts with the React frontend.
2. Axios sends HTTP requests to the Spring Boot REST APIs.
3. Spring Security validates the JWT token and authorizes the request.
4. Controllers receive the request and delegate business logic to the Service layer.
5. The Service layer processes the request and interacts with the Repository layer.
6. Spring Data JPA and Hibernate perform database operations on MySQL.
7. The processed response is returned to the frontend as JSON.

## Architecture Highlights

- Layered Architecture (Controller → Service → Repository)
- DTO-based request and response handling
- JWT-based Authentication and Authorization
- RESTful API Communication
- Spring Data JPA with Hibernate ORM
- Centralized Exception Handling
- Input Validation for API Requests
---

# 📂 Project Structure

## Backend

```
src
├── config
├── controller
├── dto
├── entity
├── exception
├── mapper
├── repository
├── security
├── service
│   └── impl
└── util
```

### Package Responsibilities

| Package | Purpose |
|----------|---------|
| `config` | Application and configuration classes. |
| `controller` | Exposes REST APIs and handles incoming HTTP requests. |
| `dto` | Defines request and response objects exchanged between the client and server. |
| `entity` | Represents database tables using JPA entities. |
| `exception` | Contains custom exceptions and global exception handling. |
| `mapper` | Converts DTOs to entities and entities to DTOs. |
| `repository` | Provides database access using Spring Data JPA repositories. |
| `security` | Implements JWT authentication, authorization, and Spring Security configuration. |
| `service` | Contains business logic and application services. |
| `service.impl` | Provides implementations of the service interfaces. |
| `util` | Contains reusable utility classes used across the application. |
