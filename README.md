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

---
## 🧩 UC2 – Add Contact to Address Book

This use case introduces the functionality to **add contacts to an Address Book using a REST API**.  
It establishes the initial service structure required to manage contacts across multiple Address Books.

The system now supports storing contact information within a specific Address Book and allows interaction through a backend API.

- Enable the application to **store contacts inside an Address Book**.
- Provide a **REST API endpoint** to add contact details.
---

## ⚙️ Implementation

- Implemented an `AddressBook` model that maintains a `List<Contact>` representing all contacts stored in that Address Book.
- Created an `AddressBookService` responsible for managing Address Books using a `Map<String, AddressBook>`.
- Added logic to **automatically create an Address Book** if it does not already exist when a contact is added.
- Implemented an `AddressBookController` that exposes the REST endpoint:

---
## 🧩 UC3 – Edit Existing Contact

This use case introduces the functionality to **update an existing contact within an Address Book using a REST API**.  
It allows users to modify previously stored contact information while maintaining the identity of the contact inside the Address Book.

---

## 🎯 Purpose

- Enable users to **update contact details** such as:
  - `Address`
  - `City`
  - `State`
  - `Zip Code`
  - `Phone Number`
  - `Email`

- Provide a mechanism to **identify and locate a contact** using `First Name` and `Last Name` within a specific Address Book.

---

## ⚙️ Implementation

- Added an `updateContact()` method in `AddressBookService` to locate a contact using `firstName` and `lastName`, and update the corresponding contact details.
- Implemented a REST endpoint in `AddressBookController`:


---
## 🧩 UC4 – Delete Contact

This use case adds the functionality to **remove an existing contact from an Address Book using a REST API**.  
It helps maintain accurate and up-to-date contact records.

---

## 🎯 Purpose

- Allow users to **delete a contact** from an Address Book.
- Identify the contact using `First Name` and `Last Name`.

---

## ⚙️ Implementation

- Implemented a `deleteContact()` method in `AddressBookService` to locate and remove a contact from `List<Contact>` using `removeIf()`.
- Added a REST endpoint in `AddressBookController`:

---
## 🧩 UC5 – Add Multiple Contacts

This use case extends the Address Book to **store and manage multiple contacts** using Java collection classes.  
It also introduces the ability to **retrieve all contacts from a specific Address Book**.

---

## 🎯 Purpose

- Allow an Address Book to **store multiple contact entries**.
- Provide an API to **retrieve all contacts** from a given Address Book.

---

## ⚙️ Implementation

- Used `List<Contact>` inside the `AddressBook` model to maintain multiple contacts.
- Implemented a `getContacts()` method in `AddressBookService` to return all contacts for a specific Address Book.
- Added a REST endpoint in `AddressBookController`:
