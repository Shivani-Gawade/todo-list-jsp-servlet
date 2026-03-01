# To-Do List Web Application

## Project Description

The **To-Do List Web Application** is a dynamic full-stack Java web project that allows users to manage daily tasks efficiently using **CRUD (Create, Read, Update, Delete)** operations.
The application is built using **JSP** for the view layer, **Servlets** for controller logic, and **JDBC** for database connectivity with an **Oracle Database** backend.

This project follows an **MVC-based layered architecture**, helping to maintain clean code structure and separation of concerns—an important concept for real-world Java web development and campus placements.

The project is version-controlled and hosted on GitHub.

---

## Features

1. User Registration and Login System
2. Session Management (Login / Logout)
3. Add New Tasks
4. Update Existing Tasks
5. Delete Tasks
6. View Task List Dashboard
7. Form Validation using JavaScript
8. Clean UI using HTML & CSS

---

## Technologies Used

**Frontend**

- HTML
- CSS
- JavaScript (Basic validation & alerts)

**Backend**

- Java
- JSP
- Servlets
- JDBC

**Database**

- Oracle Database (by Oracle Corporation)

**Tools & Server**

- Apache Tomcat (from Apache Software Foundation)
- Eclipse IDE (by Eclipse Foundation)

---

## Project Architecture / Flow (MVC Pattern)

```
Client (Browser)
      ↓
JSP Pages (View Layer)
      ↓
Servlets (Controller Layer)
      ↓
DAO Classes (Business Logic)
      ↓
JDBC Connectivity
      ↓
Oracle Database (Data Layer)
```

### Architecture Highlights

- **Model:** Java classes representing data objects
- **DAO:** Database operations (CRUD logic)
- **Controller:** Servlets handling request/response
- **View:** JSP pages for UI


## Folder Structure

```
ToDoListApp
│
├── src/main/java
│   ├── com.todo.controller
│   │   ├── AddTaskServlet.java
│   │   ├── DeleteTaskServlet.java
│   │   ├── EditTaskServlet.java
│   │   ├── LoginServlet.java
│   │   ├── LogoutServlet.java
│   │   ├── RegisterServlet.java
│   │   └── UpdateTaskServlet.java
│   │
│   ├── com.todo.dao
│   │   ├── TaskDAO.java
│   │   └── UserDAO.java
│   │
│   ├── com.todo.model
│   │   ├── Task.java
│   │   └── User.java
│   │
│   └── com.todo.util
│       └── DBConnection.java
│
├── src/main/webapp
│   ├── META-INF
│   ├── WEB-INF
│   │
│   ├── login.jsp
│   ├── register.jsp
│   ├── dashboard.jsp
│   ├── addTask.jsp
│   ├── editTask.jsp
│   │
│   ├── style.css
│   ├── dashboard.css
│   ├── addTask.css
│   └── editTask.css
│
├── screenshots
│   ├── home_page.png
│   ├── registration.png
│   ├── before_dashboard.png
│   ├── after_dashboard.png
│   ├── addtask.png
│   └── update_task.png
│
├── Libraries
├── build
└── README.md
```

---

## How to Run the Project Locally

### 1. Prerequisites

- Java JDK installed
- Apache Tomcat Server
- Oracle Database installed
- Eclipse IDE

### 2. Database Setup

- Create a database in Oracle.
- Create required tables:

Example:

```sql
CREATE TABLE users(
id NUMBER PRIMARY KEY,
username VARCHAR2(50),
password VARCHAR2(50)
);

CREATE TABLE tasks(
id NUMBER PRIMARY KEY,
title VARCHAR2(100),
description VARCHAR2(200)
);
```

- Update database credentials in:

```
DBConnection.java
```

### 3. Run the Project

1. Import project into Eclipse
2. Configure Apache Tomcat Server
3. Add project to Tomcat server
4. Run the server
5. Open in browser:

```
http://localhost:8080/ToDoListApp
```

## Screenshots

```
screenshots/
   login.png
   dashboard.png
   add-task.png
```
## Live Demo



## Author

	Shivani Gawade
	Aspiring Full Stack Developer
	Java | JDBC | Servlets | JavaScript | Oracle | Web Development


