# OneToMany
This is a project for learning One To Many Mapping
# Bookstore Spring Boot Project

This Spring Boot project is designed for learning and understanding the concepts of One-to-Many and Many-to-One mapping in JPA, focusing on the relationship between categories and books in a bookstore application.

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Database Configuration](#database-configuration)
- [Running the Application](#build-and-run-the-application)
- [Contributing](#contributing)

## Introduction

The primary goal of this project is to provide a practical understanding of One-to-Many and Many-to-One mapping in Spring Boot, specifically demonstrating the association between categories and books in a bookstore management system.

## Features

- **Category Management:**
  - Create, read, update, and delete category details.
  - Retrieve all categories.
  - Retrieve category by ID or name.
  - Update category by ID or name.
  - Delete category by ID or name.

- **Book Management:**
  - Create, read, update, and delete book details.
  - Retrieve all books.
  - Retrieve book by ID or title.
  - Update book by ID or title.
  - Delete book by ID or title.

## Technologies Used

- Spring Boot
- Spring Data JPA
- RESTful API
- MySQL Database
- Gradle

## Getting Started

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/your-repository.git

  ## Database Configuration:

Configure your MySQL database settings in the src/main/resources/application.properties file.

## Build and Run the Application:

  ```bash
    cd your-repository
    ./gradlew bootRun
```

## Access the API:
The application will be accessible at http://localhost:8080.

## API Endpoints:
**Category Controller**

Create Category:
POST /api/1.0/category/

Get All Categories:
GET /api/1.0/category/getall

Get Category by ID:
GET /api/1.0/category/id/{id}

Get Category by Name:
GET /api/1.0/category/{name}

Update Category by ID:
PUT /api/1.0/category/updateById/{id}

Update Category by Name:
PUT /api/1.0/category/updateCategoryByName/{name}

Delete Category by ID:
DELETE /api/1.0/category/deleteById/{id}

Delete Category by Name:
DELETE /api/1.0/category/deleteCategoryByName/{name}

**Book Controller**

Create Book:
POST /api/1.0/books/

Get All Books:
GET /api/1.0/books/

Get Book by ID:
GET /api/1.0/books/id/{id}

Get Book by Title:
GET /api/1.0/books/{title}

Update Book by ID:
PUT /api/1.0/books/updateById/{id}

Update Book by Title:
PUT /api/1.0/books/updateBookByTitle/{title}

Delete Book by ID:
DELETE /api/1.0/books/deleteById/{id}

Delete Book by Title:
DELETE /api/1.0/books/deleteBookByTitle/{title}

**Running the Application:**
To run the application, execute the main method in the BookstoreApplication class.

## Contributing:
Feel free to contribute to the project by opening issues or submitting pull requests. Any feedback or suggestions are welcome!
