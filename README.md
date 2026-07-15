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

---

# 🗄 Database Design

The application uses **MySQL** as the relational database to store user information, shortened URLs, and click analytics.

## Entity Relationship

```text
User (1)
   │
   └──────────────► Link (Many)
                         │
                         └────────────► ClickAnalytics (Many)
```

---

## User

| Column | Description |
|---------|-------------|
| `id` | Unique identifier for the user |
| `full_name` | User's full name |
| `email` | User email address |
| `password` | Encrypted password using BCrypt |

---

## Link

| Column | Description |
|---------|-------------|
| `id` | Unique identifier for the shortened link |
| `original_url` | Original URL provided by the user |
| `short_code` | Generated unique short code |
| `click_count` | Total number of clicks |
| `created_at` | Link creation timestamp |
| `last_accessed` | Most recent access timestamp |
| `user_id` | Foreign key referencing the owner of the link |

---

## ClickAnalytics

| Column | Description |
|---------|-------------|
| `id` | Unique identifier |
| `clicked_at` | Timestamp of the click event |
| `link_id` | Foreign key referencing the associated link |

---

## Relationships

- One **User** can create multiple shortened links.
- Each **Link** belongs to exactly one user.
- Each **Link** can have multiple click analytics records.
- Click analytics data is used to generate dashboard statistics and track URL performance.
- ---

# 🔌 REST API Documentation

The backend exposes RESTful APIs for authentication, URL management, analytics, and redirection.

## Authentication APIs

| Method | Endpoint | Authentication | Description |
|---------|----------|---------------|-------------|
| POST | `/api/auth/register` | yes | Register a new user account |
| POST | `/api/auth/login` | yes | Authenticate user and generate JWT token |

---

## URL Management APIs

| Method | Endpoint | Authentication | Description |
|---------|----------|---------------|-------------|
| POST | `/api/links` | Yes | Create a new shortened URL |
| GET | `/api/links` | Yes | Retrieve all URLs created by the authenticated user |
| DELETE | `/api/links/{id}` | Yes | Delete a shortened URL |

---

## Analytics APIs

| Method | Endpoint | Authentication | Description |
|---------|----------|---------------|-------------|
| GET | `/api/analytics` | Yes | Retrieve dashboard analytics and link statistics |

---

## Redirect API

| Method | Endpoint | Authentication | Description |
|---------|----------|---------------|-------------|
| GET | `/r/{shortCode}` | No | Redirect users to the original URL and record click analytics |
---

# 🔒 Security

The application uses **Spring Security** with **JWT (JSON Web Token)** to provide secure authentication and authorization.

## Security Features

- JWT-based Authentication
- Stateless Session Management
- BCrypt Password Encryption
- Protected REST APIs
- User-specific Authorization
- Role-based request validation using Spring Security
- Unauthorized request handling
- Secure password storage

---

## Authentication Flow

1. The user registers with a unique email address.
2. The password is encrypted using BCrypt before being stored in the database.
3. The user logs in with valid credentials.
4. The backend authenticates the user and generates a JWT token.
5. The client stores the JWT token.
6. Every protected API request includes the JWT token in the Authorization header.
7. Spring Security validates the token before processing the request.
8. Authorized users can access only their own resources.
---

# 🧠 Business Logic

The application implements several backend functionalities beyond basic CRUD operations to ensure secure and efficient URL management.

## Core Business Logic

- Generates a unique short code for every URL.
- Prevents duplicate URLs from being created for the same user.
- Validates URL format before storing it in the database.
- Tracks every successful URL redirection.
- Maintains click counts for each shortened URL.
- Records click analytics for every URL access.
- Calculates dashboard statistics, including:
  - Total Links
  - Total Clicks
  - Average Clicks
  - Top Performing Link
- Supports pagination for efficient retrieval of user links.
- Restricts users to accessing and managing only their own URLs.
- Provides centralized exception handling for consistent API responses.
