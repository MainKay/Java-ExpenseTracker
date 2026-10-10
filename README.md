# Expense Tracker API
## About the Project

Expense Tracker is a simple REST API built with Java and Spring Boot. It allows users to manage their expenses and organize them by date and category.

The application supports basic CRUD operations: creating, reading, updating, and deleting expenses.

It also allows users to filter expenses by date, category, and month, and retrieve all available expense categories.

The project has two data storage options:
- **JSON** – loads initial expenses from a JSON file and stores changes in memory.
- **H2 Database** – stores expenses in an H2 database using Spring Data JPA.

## Technologies 
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- H2 Database
- Jackson
- Lombok
- Gradle
- Postman

## Expense Data
Each expense contains the following fields:

- `id` – unique identifier
- `expenseType` – expense type
- `date` – expense date
- `amount` – expense amount
- `category` – expense category
- `account` – account name
- `note` – additional information

## API Endpoints
The default base URL is:

`http://localhost:8080`

### 1. Get Expenses by Date
**GET** `/expenses/day/{date}` -> Returns all expenses for a specific date.

Example:
`GET http://localhost:8080/expenses/day/2026-10-10`

### 2. Get Expenses by Category and Month
**GET** `/expenses/category/{category}/month?month={month}` -> Returns expenses matching a category and a month.

Example:
`GET http://localhost:8080/expenses/category/Food/month?month=2026-10`
The month should match the beginning of the date stored in the expense.

### 3. Get All Expense Categories
**GET** `/expenses/categories` -> Returns a list of all unique expense categories.

Example:
`GET http://localhost:8080/expenses/categories`
Returns `200 OK` when categories are available, or `204 No Content` when the list is empty.

### 4. Get an Expense by ID
**GET** `/expenses/{id}` -> Returns an expense with the specified ID.

Example:
`GET http://localhost:8080/expenses/1`
Returns `404 Not Found` if the expense does not exist.

### 5. Add a New Expense

**POST** `/expenses` -> Adds a new expense. Select **Body → raw → JSON** in Postman.

Example request body:

{
  "expenseType": 1,
  "date": "2026-10-10",
  "amount": 45.50,
  "category": "Food",
  "account": "Personal",
  "note": "Lunch"
}

Returns `201 Created` if the expense was created correctly.

### 6. Update an Expense
**PUT** `/expenses/{id}` <- Updates an existing expense. The ID in the URL is used as the expense ID.

Example:
`PUT http://localhost:8080/expenses/1`

Example request body:

{
  "expenseType": 1,
  "date": "2026-10-10",
  "amount": 50.00,
  "category": "Food",
  "account": "Personal",
  "note": "Updated lunch expense"
}

Returns `200 OK` if the expense is updated, or `404 Not Found` if it does not exist.

### 7. Delete an Expense
**DELETE** `/expenses/{id}` -> Deletes an expense with the specified ID.

Example:
`DELETE http://localhost:8080/expenses/1`
Returns `204 No Content` if the expense is deleted, or `404 Not Found` if it does not exist.

## Running the Application:
1. Clone or download the repository.
2. Open the project in your IDE.
3. Configure the desired Spring profile: `json` or `db`.
4. Run `ExpenseTrackerApplication`.
5. Open Postman and send requests to `http://localhost:8080`.

The selected profile must match the available service implementation. Database configuration is required when using the `db` profile.

## H2 Database Console
When using the `db` profile, you can access the H2 database console at:

`http://localhost:8080/h2-console`

Use the JDBC URL and credentials configured in `application.properties` to connect to the database and view stored expenses.

## Project Goals
This project was created to practise Java backend development and learn how to build REST APIs with Spring Boot.
It demonstrates the use of controllers, services, repositories, dependency injection, Java Streams, JSON processing, and database persistence.


