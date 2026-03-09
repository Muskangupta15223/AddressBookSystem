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

---
## 🧩 UC6 – Multiple Address Books

This use case extends the system to **manage multiple Address Books simultaneously**.  
Each Address Book is identified by a unique name and maintains its contacts independently.

---

## 🎯 Purpose

- Allow the system to organize contacts across different Address Books such as `Personal`, `Work`, or `Family`.
- Ensure contacts remain **separate within their respective Address Books**.

---

## ⚙️ Implementation

- Refactored the service layer to manage Address Books using `Map<String, AddressBook>`.
- Implemented service methods to **create new Address Books** and **retrieve existing ones**.
- Added REST endpoints in `AddressBookController`:

---
## 🧩 UC7 – Prevent Duplicate Contacts

This use case enhances the Address Book system by **preventing duplicate contacts within the same Address Book**.  
- Each contact is uniquely identified using `First Name` and `Last Name`.
- Maintain **data integrity** by avoiding duplicate contact entries.

## ⚙️ Implementation

- Added validation logic in `AddressBookService` to check existing contacts before adding a new one.
- Implemented duplicate detection using **Java Streams** with `anyMatch()` to verify if a contact with the same `firstName` and `lastName` already exists.
- Throws an **exception** when a duplicate contact is detected, preventing the entry from being added.
- Added **unit tests** to verify:
  - Detection of duplicate contacts
  - Successful addition of unique contacts
  - Allowing identical contacts in different Address Books

---

## 🧩 UC8 – Search Person by City or State :
  - Introduces the ability to search contacts by city or state across multiple Address Books.
  - Enables efficient filtering of contacts based on location information.

## 🎯 Purpose
  - Allow users to quickly find contacts belonging to a specific city or state.
  - Support searching across all Address Books in the system.

## ⚙️ Implementation
  - Implemented search functionality in `AddressBookService` using Java Streams.
  - Combined contacts from all Address Books and filtered them based on the specified city or state.
  - Added REST endpoints in `AddressBookController`:
  
    ```
    GET /addressbooks/search/city/{city}
    GET /addressbooks/search/state/{state}
    ```
  - Added unit tests to validate search results, case-insensitive matching, multiple results, and scenarios where no contacts are found.

---

## 🧩 UC9 – View Persons by City or State :
  - Introduces the ability to view contacts grouped by city or state across Address Books.
  - Organizes contacts based on location for easier viewing and analysis.

## 🎯 Purpose
  - Allow users to see all contacts grouped by their city or state.
  - Provide a structured way to organize contacts based on location.

## ⚙️ Implementation
  - Implemented grouping logic in `AddressBookService` using Java Streams and `Collectors.groupingBy()`.
  - Contacts are grouped into a dictionary structure:
    ```
    Map<String, List<Contact>>
    ```
  - Added REST endpoints in `AddressBookController`:
    ```
    GET /addressbooks/view/city
    GET /addressbooks/view/state
    ```
  - Added unit tests to verify grouping functionality, handling of multiple Address Books, and scenarios with empty datasets.

----

# 🧩 UC10 – Count Contacts by City or State :**
  - Introduces the ability to count the number of contacts grouped by city or state across Address Books.
  - Provides statistical insight into how contacts are distributed across locations.

  ## Purpose
  - Allow users to determine how many contacts belong to each city or state.
  - Provide aggregated contact statistics across all Address Books.

  ## Implementation
  - Implemented counting logic in `AddressBookService` using Java Streams with `Collectors.groupingBy()` and `Collectors.counting()`.
  - Contacts are aggregated into the structure:
  - Added REST endpoints in `AddressBookController`:
  - Added unit tests to validate counting across multiple Address Books, handling of empty datasets, and contacts belonging to different locations.

---

## 🧩 UC11 –Sort Contacts Alphabetically by Name :
  - Introduces the ability to sort contacts alphabetically by their first name within an Address Book.
  - Improves usability by presenting contacts in an organized and readable order.

## 🎯 Purpose
  - Allow users to view contacts arranged alphabetically for easier navigation.
  - Provide a consistent way to display contact lists within an Address Book.

## ⚙️ Implementation
  - Implemented sorting logic in `AddressBookService` using Java Streams and `Comparator.comparing()` based on the `firstName` field.
  - Added a REST endpoint in `AddressBookController`:
    ```
    GET /addressbooks/{bookName}/sort/name
    ```
  - Override the `toString()` method in the `Contact` model to produce readable output when displaying contact entries.
---
