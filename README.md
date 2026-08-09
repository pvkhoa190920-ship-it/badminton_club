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

## 🔐 Authentication

The application uses Spring Security for authentication and authorization.

### Login

Send a POST request to:

```http
POST /api/auth/login
```

Request body:

```json
{
  "userId": "your_user_id",
  "password": "your_password"
}
```

A successful login returns an authentication token:

```json
{
  "message": "Đăng nhập thành công!",
  "token": "your_token"
}
```

For protected requests, include the token in the request header:

```http
Authorization: Bearer your_token
```

### Validate Token

```http
GET /api/auth/me
```

The endpoint verifies whether the provided Bearer token is currently valid.
## 🗄️ Database

The application uses PostgreSQL as the relational database.

### Main Entities

- `User` - Stores user account and authentication information.
- `Member` - Stores badminton club member information.
- `DmType` - Stores member type / classification information.

### Data Access

The project uses:

- Spring Data JPA
- Hibernate
- Repository pattern
- JPA Entity mapping

Database configuration is provided through environment variables:

```env
DB_URL=your_database_url
DB_USERNAME=your_database_username
DB_PASSWORD=your_database_password
```

Sensitive database credentials are excluded from Git using `.gitignore`.
## 🐳 Docker

The application can be containerized and deployed using Docker.

### Build Docker Image

```bash
docker build -t badminton-club .
```

### Run Docker Container

```bash
docker run -p 8080:8080 badminton-club
```

The application will be available at:

```text
http://localhost:8080
```

### Deployment

The application can be deployed to cloud platforms such as Render.

Environment variables should be configured in the deployment environment:

```text
DB_URL
DB_USERNAME
DB_PASSWORD
```

Database credentials should never be committed to the repository.