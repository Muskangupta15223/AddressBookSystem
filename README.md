# 📒 AddressBookApp

AddressBookApp is a **Spring Boot based Java application** developed using the **Test-Driven Development (TDD)** approach. The goal of this project is to progressively build a digital Address Book system that manages contact information efficiently.

The project follows an **incremental development strategy**, where features are introduced step-by-step through different use cases. This approach helps maintain a **clean architecture, better testability, and scalability** as the application grows.

---

## 📖 Project Overview

This project is a **modular Spring Boot application** designed to manage contacts within an Address Book system.

Development is organized around **progressive use cases**, starting with basic functionality such as creating contacts and later expanding to advanced features like searching, sorting, persistence, and database integration.

The application follows a **layered architecture**, which includes:

- `Controller Layer` – Handles incoming requests and responses.
- `Service Layer` – Contains the business logic of the application.
- `Repository Layer` – Responsible for data storage and retrieval.

This structure ensures the application remains **maintainable, scalable, and easy to extend**.

---
## 🧩 UC1 – Create Contact

This use case introduces the **Contact domain model**, which represents an individual entry in the Address Book.

The Contact entity includes essential details about a person, such as:

- `First Name`
- `Last Name`
- `Address`
- `City`
- `State`
- `Zip Code`
- `Phone Number`
- `Email`

This model serves as the **foundation for all Address Book operations** that will be implemented in later stages of the project.

---

## ⚙️ Implementation

- Implemented a `Contact` model class in the **model layer** of the application.
- The class encapsulates all contact fields with appropriate **constructors, getters, and setters**.
- Added **unit tests (`ContactTest`)** to verify correct object creation and ensure that contact attributes are stored properly.
- The `Contact` class acts as the **core domain object** that will be used by future **service, repository, and controller layers**.

---
