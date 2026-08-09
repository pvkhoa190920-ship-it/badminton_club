# Badminton Club Management System

A web application for managing badminton clubs, members, and related activities.

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Spring Security
- PostgreSQL
- Maven
- HTML / CSS / JavaScript
## Features

- User authentication and authorization
- Member management
- Badminton club management
- RESTful API
- Role-based access control
- Global exception handling
- PostgreSQL database integration
- Docker support
## 🛠️ Tech Stack

### Backend
- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA / Hibernate
- RESTful API
- Maven

### Database
- PostgreSQL

### Frontend
- HTML
- CSS
- JavaScript
- Bootstrap

### Deployment
- Docker
- Render
## 📁 Project Structure

```text
src/main/java/com/badminton/badminton_club
├── config/          # Spring Security, application configuration
├── controller/      # REST API controllers
├── dto/             # Request / Response DTOs
├── entity/          # JPA entities
├── exception/       # Exception handling
├── repository/      # Data access layer
└── service/         # Business logic

src/main/resources
├── static/          # CSS, JavaScript, images
├── templates/       # HTML templates
└── application.properties
```

## 🚀 Installation

### 1. Clone repository

```bash
git clone https://github.com/pvkhoa190920-ship-it/badminton_club.git
cd badminton_club
```

### 2. Configure environment variables

Create a `.env` file in the project root with the following variables:

```env
DB_URL=your_database_url
DB_USERNAME=your_database_username
DB_PASSWORD=your_database_password
```
## 📡 API Endpoints

### Authentication

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/auth/login` | User login |
| GET | `/api/auth/me` | Validate authentication token |

### Users

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/users` | Create a user account |
| GET | `/api/users` | Get all users |
| PUT | `/api/users/{userId}/password` | Change user password |

### Members

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/members` | Get all members |
| POST | `/api/members` | Create a member |
| PUT | `/api/members/{id}` | Update a member |
| DELETE | `/api/members/{id}` | Delete a member |
| GET | `/api/members/generations` | Get distinct generations |

### Types

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/types` | Get all types |
| POST | `/api/types` | Create a type |
| PUT | `/api/types/{id}` | Update a type |
| DELETE | `/api/types/{id}` | Delete a type |