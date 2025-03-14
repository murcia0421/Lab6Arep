# Workshop6_AREP: Individual Workshop on Architectural Patterns

This project is a Spring Boot application focused on implementing security best practices in web applications. It integrates authentication, authorization, and secure communication mechanisms to ensure data protection and prevent vulnerabilities.

---

## Getting Started

### Prerequisites

Before you begin, make sure you have the following installed:

- **Java JDK 17** (or higher)
Download it from [Oracle](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) or use OpenJDK.
- **Apache Maven**
Download it from [Maven Official](https://maven.apache.org/download.cgi) and follow the installation instructions.
- **Git** (optional, to clone the repository)
- **Docker** (for containerization and deployment)
- **AWS CLI** (for AWS CodeBuild and deployment)

### Installation

1. **Clone the repository:**

```bash
git clone https://github.com/murcia0421/Lab6Arep.git
```

2. **Navigate to the project directory:**

```bash
cd Lab6Arep
```

3. **Build and package the project with Maven:**

```bash
mvn clean package
```

4. **Run the server with Docker:**

```bash
docker-compose up --build
```

5. **Verify that the server is running:**

```bash
Server running on port 8080...
```

---

## Technologies Used

- **Java 17**
- **Apache Maven**
- **JUnit 5** (for unit testing)
- **Reflections** (for automatic classpath scanning)

---

## Security Features Implemented

### 1️ Authentication & Authorization

- **JWT**-based authentication to secure API endpoints.
- **Role-based access control** (**RBAC**) to restrict user actions.
- **BCrypt** password hashing for secure credential storage.

### 2️ Secure Communication

- **HTTPS** enforcement to protect data transmission.
- **CORS** policies used to prevent unauthorized cross-origin requests.

### 3️ Data Protection

- Implementation of **parameterized queries** to prevent **SQL Injection**.
- Input validation to mitigate **Cross-Site Scripting (XSS)**.
- Configuration of **security headers** to prevent attacks such as **Clickjacking**.

---

## Architecture

The project follows a **microservices**-based architecture and is designed to be deployed on **AWS EC2** using **Docker**. The structure and main components are described below:

![Architecture](https://github.com/user-attachments/assets/0c8e76a6-e9c3-4f57-87df-7afb2a6f50e6)

### Architecture Components

### 1️ **EC2: Spring Boot (Backend App)**

#### `PropertyController`
- REST controller that handles HTTP requests (`GET`, `POST`, `PUT`, `DELETE`).
- Exposes API endpoints for property management.

#### `PropertyService`
- Contains the business logic for property management.
- Communicates with the repository to access the database.

#### `PropertyRepository`
- Data access layer that interacts with the **MySQL** database.
- Uses **Spring Data JPA** to perform CRUD operations.

#### `Property.java`
- JPA entity that represents a property in the database.
- Defines the structure of the `property` table with the attributes: `id`, `address`, `price`, `size`, `description`.

#### `AccessingDataJpaApplication`
- Main class that launches the **Spring Boot** application.
- Configures the application context and loads necessary dependencies.

### 2 **EC2: MySQL (Database)**

#### MySQL Server
- Hosts the `property_management` database, where properties are stored.
- Communicates with the Spring Boot application over port `3306`.

#### `property` Table
- Table in the database that stores property data.
- Columns: `id`, `address`, `price`, `size`, `description`.

### 3 **Architecture Flow**

**Client (Frontend or Postman)**
- Makes HTTP requests (`GET`, `POST`, `PUT`, `DELETE`) to the Spring Boot server (**EC2 1**).

**Spring Boot Server (EC2 1)**
- `PropertyController` receives requests and delegates them to `PropertyService`.
- `PropertyService` uses `PropertyRepository` to interact with the database.
- `PropertyRepository` executes queries against the MySQL database (**EC2 2**) using the `Property.java` entity.

**MySQL Database (EC2 2)**
- Stores property data in the `property` table.
- Responds to queries from the Spring Boot server.

**Response**
- The Spring Boot server returns an HTTP response (JSON) to the client with the requested data.

---

## Deployment

- The application is deployed on AWS EC2 with a PostgreSQL/MySQL database.
- Uses Docker for containerization and AWS CodeBuild for continuous integration.

---

## Author

- **Juan Daniel Murcia**
-
