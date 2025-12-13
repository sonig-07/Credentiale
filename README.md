# Lockr 🔐

*A Spring Boot based password manager*

Lockr is a backend password manager application built using Spring Boot.
It provides APIs to securely store and retrieve passwords while applying encryption before persistence.

The project was created to understand how real-world applications handle sensitive data, database interaction, and service-layer architecture.

---

## Features

* Store passwords securely using encryption
* Retrieve saved credentials via REST APIs
* Layered architecture (Controller, Service, Repository)
* Clean and structured backend design

---

## Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* Maven
* MySQL / H2 (configurable)

---

## Project Structure

```
password-manager/
│── src/main/java/com/soni/password_manager
│   ├── controller/
│   │   └── PasswordController.java
│   ├── service/
│   │   └── PasswordService.java
│   ├── repository/
│   │   └── PasswordRepository.java
│   ├── entity/
│   │   └── Password.java
│   └── util/
│       └── EncryptionUtil.java
│
│── src/main/resources/
│   └── application.properties
│
│── pom.xml
│── README.md
```

---

## How It Works

* Passwords are received through REST endpoints
* Data is encrypted using a utility class before saving
* Encrypted passwords are stored in the database
* Decryption is applied only when required

---

## How to Run the Project

1. Clone the repository

   ```bash
   git clone https://github.com/sonig-07/Lockr.git
   ```

2. Open the project in IntelliJ / Eclipse

3. Configure database settings in `application.properties`

4. Run the Spring Boot application

---

## Why This Project

This project helped me learn:

* Secure handling of sensitive data
* REST API development using Spring Boot
* Encryption basics
* Backend project structuring

---

## Author

**Soni G**
GitHub: [https://github.com/sonig-07](https://github.com/sonig-07)

---
