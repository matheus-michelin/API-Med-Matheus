# 🩺 Medical Management API (API-Med Matheus)

[![Java](https://img.shields.io/badge/Java-21%2B-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15%2B-blue.svg)](https://www.postgresql.org/)
[![Swagger](https://img.shields.io/badge/Swagger-OpenAPI%203-brightgreen.svg)](https://swagger.io/)
[![License](https://img.shields.io/badge/License-NonCommercial-orange.svg)](LICENSE)

A robust RESTful API built with **Java 21** and **Spring Boot 3**, designed to streamline medical clinic management. This application handles doctor and patient registrations, appointment scheduling, access control, and business logic validations.

---

## ✨ Features

- **Doctor Management:** CRUD operations for medical staff with specialty categorization.
- **Patient Management:** Complete patient registration and record tracking.
- **Appointment Scheduling:** Book, cancel, and manage consultations with built-in validation rules (e.g., clinic operating hours, doctor availability).
- **Security & Authentication:** Stateless authentication using **Spring Security** and **JWT (JSON Web Tokens)**.
- **Database Migrations:** Version-controlled database schema changes using **Flyway**.
- **Interactive API Docs:** Full Swagger UI integration via **SpringDoc OpenAPI** for live endpoint testing and specification.

---

## 🛠️ Tech Stack

- **Language:** Java 21+
- **Framework:** Spring Boot 3
- **Security:** Spring Security + JWT
- **Persistence:** Spring Data JPA / Hibernate
- **Database:** PostgreSQL
- **Migration:** Flyway
- **Documentation:** SpringDoc OpenAPI 3 / Swagger UI
- **Build Tool:** Maven

---

## 🚀 Getting Started

### Prerequisites

Ensure you have the following installed on your machine:
- [Java Development Kit (JDK 21+)](https://www.oracle.com/java/technologies/downloads/)
- [Apache Maven](https://maven.apache.org/)
- [PostgreSQL](https://www.postgresql.org/) running locally or in a container

### Installation & Configuration

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/matheus-michelin/API-Med-Matheus.git](https://github.com/matheus-michelin/API-Med-Matheus.git)
   cd API-Med-Matheus
   ```

2. **Configure Database & Security in `application.properties`:**
   ```properties
   spring.datasource.url=jdbc:postgresql://${YOUR_HOST}/${YOUR_DB}
   spring.datasource.username=${YOUR_USER}
   spring.datasource.password=${YOUR_PASSWORD}

   api.security.token.secret=${YOUR_JWT_SECRET}
   ```

3. **Build the project:**
   ```bash
   mvn clean install
   ```

4. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```
   The API will start running at `http://localhost:8080`.

---

## 📚 API Documentation (Swagger UI)

Once the application is running, you can access the interactive API documentation and test endpoints directly from your browser:

- **Swagger UI:** `http://localhost:8080/swagger-ui.html`
- **OpenAPI Spec (JSON):** `http://localhost:8080/v3/api-docs`

---

## 📌 Main API Endpoints

| Method | Endpoint | Description | Auth Required |
| :--- | :--- | :--- | :---: |
| `POST` | `/login` | Authenticate user and receive JWT token | ❌ |
| `GET` | `/medicos` | List active doctors (paginated) | 🟢 |
| `POST` | `/medicos` | Register a new doctor | 🟢 |
| `PUT` | `/medicos` | Update doctor information | 🟢 |
| `DELETE` | `/medicos/{id}` | Inactivate a doctor | 🟢 |
| `GET` | `/pacientes` | List active patients (paginated) | 🟢 |
| `POST` | `/pacientes` | Register a new patient | 🟢 |
| `POST` | `/consultas` | Schedule a new appointment | 🟢 |
| `DELETE` | `/consultas` | Cancel an appointment | 🟢 |

---

## 📄 License

This project is licensed under a **Custom Non-Commercial License**. Free for personal, educational, and research use only. Commercial use, reproduction, or distribution for profit is strictly prohibited. See the [LICENSE](LICENSE) file for full details.

---

👨‍💻 Developed by [Matheus Michelin](https://github.com/matheus-michelin)
