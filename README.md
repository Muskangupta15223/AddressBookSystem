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
# 🧩 UC12 – Sort Contacts by City, State, or Zip 
  - Extends the sorting capability to allow contacts to be ordered by city, state, or zip code within an Address Book.
  - Provides flexible ways to organize contacts based on location attributes.

  ## Purpose
  - Allow users to view contacts sorted by city, state, or zip code.
  - Improve organization and accessibility of contact information based on geographical attributes.

## ⚙️ Implementation
  - Implemented sorting logic in `AddressBookService` using Java Streams and `Comparator.comparing()` for the fields `city`, `state`, and `zip`.
  - Added REST endpoints in `AddressBookController`:
    ```
    GET /addressbooks/{bookName}/sort/city
    GET /addressbooks/{bookName}/sort/state
    GET /addressbooks/{bookName}/sort/zip
    ```
  - Added unit tests to validate sorting functionality, including handling empty Address Books and single contact scenarios.

---

# 🧩 UC13 – File IO Support :
  - Introduces file persistence for Address Book contacts using Java File IO.
  - Enables saving contacts to a file and loading them back into memory.

  ## Purpose
  - Allow the Address Book data to be stored permanently outside application memory.
  - Enable restoring contacts from a saved file when required.

  ## Implementation
  - Created a utility class `FileUtil` to manage file operations using `BufferedWriter` and `BufferedReader`.
  - Implemented functionality to save contacts from an Address Book to a file and load contacts from a file into memory.
  - Added REST endpoints in `AddressBookController`:
    ```
    POST /addressbooks/{bookName}/save
    GET /addressbooks/load
    ```
  - Added unit tests to validate file creation, file reading, handling of empty files, and persistence of multiple contacts.

---

# 🧩 UC14 – CSV File Support :
  - Introduces structured CSV-based persistence for Address Book contacts using the OpenCSV library.
  - Enables exporting contacts to CSV files and loading them back into the system.

  ## Purpose
  - Allow contacts to be stored and retrieved using a structured CSV file format.
  - Provide a standardized and portable format for contact data storage.

  ## Implementation
  - Created a utility class `CSVUtil` to manage CSV operations using OpenCSV's `CSVReader` and `CSVWriter`.
  - Implemented functionality to save contacts from an Address Book to a CSV file and load contacts from a CSV file into memory.
  - Added REST endpoints in `AddressBookController`:
    ```
    POST /addressbooks/{bookName}/save-csv
    GET /addressbooks/load-csv
    ```
  - Added unit tests to validate CSV file creation, reading contacts from CSV, handling multiple contacts, and empty CSV file scenarios.

- 🧩 **UC16 – Retrieve Contacts from Database & Storage Layer Refactor :**
  - Introduces database integration to retrieve contacts using JDBC and refactors the storage design to support multiple persistence formats through a storage abstraction layer.

  **Purpose**
  - Enable retrieval of contacts stored in a relational database.
  - Decouple storage logic from business logic to support multiple storage formats such as file, CSV, and JSON.

  **Implementation**
  - Externalized database configuration in `application.properties`, allowing Spring Boot to automatically configure a `DataSource`.
  - Implemented a `ContactRepository` to execute SQL queries and map database rows to `Contact` objects.
  - Added a REST endpoint in `AddressBookController`:
    ```
    GET /addressbooks/db/contacts
    ````
  - Introduced a storage abstraction using the `ContactStorage` interface defining common operations for saving and loading contacts.
  - Implemented three storage strategies:
    - `FileStorage` – Handles standard Java File IO operations.
    - `CSVStorage` – Supports CSV persistence using the OpenCSV library.
    - `JSONStorage` – Supports JSON serialization and deserialization using the Gson library.
  - Added integration tests using `@SpringBootTest` to validate database connectivity and data retrieval.

---
# 🧩 **UC16 – Retrieve Contacts from Database & Storage Layer Refactor :**
  - Introduces database integration to retrieve contacts using JDBC and refactors the storage design to support multiple persistence formats through a storage abstraction layer.

  ## Purpose
  - Enable retrieval of contacts stored in a relational database.
  - Decouple storage logic from business logic to support multiple storage formats such as file, CSV, and JSON.

  ## Implementation
  - Externalized database configuration in `application.properties`, allowing Spring Boot to automatically configure a `DataSource`.
  - Implemented a `ContactRepository` to execute SQL queries and map database rows to `Contact` objects.
  - Added a REST endpoint in `AddressBookController`:
    ```
    GET /addressbooks/db/contacts
    ````
  - Introduced a storage abstraction using the `ContactStorage` interface defining common operations for saving and loading contacts.
  - Implemented three storage strategies:
    - `FileStorage` – Handles standard Java File IO operations.
    - `CSVStorage` – Supports CSV persistence using the OpenCSV library.

---
 # 🧩 UC17 – Updating Contact Information in the Database
 
 ## Purpose:
   - Enable the system to modify existing contact records stored in the database.
   - Support updating specific attributes, such as city, based on a contact’s name.
 
  ## Implementation:
   - Extended ContactRepository to execute SQL UPDATE statements using JDBC PreparedStatement.
   - Added logic to update the city of a contact identified by firstName and lastName.
   - Exposed a REST endpoint in AddressBookController:
         PUT /addressbooks/db/update-city
   - Added integration tests to verify successful updates and correct JDBC behavior.
 