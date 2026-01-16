# Tutor Session Management System

A Java console application that manages students and tutoring sessions using clean **Object-Oriented Programming** principles and the **MVC (Model-View-Controller)** architecture.

## 📌 Project Overview
The Tutor Session Management System allows a tutor to:
- Register students
- Schedule tutoring sessions
- Prevent duplicate sessions on the same date
- Mark sessions as completed
- Persist data using file storage
- Safely handle invalid user input

The project focuses on **clean design, maintainability and defensive programming**.

---

## 🧠 Concepts Used
- Object-Oriented Programming (Classes, Objects, Encapsulation)
- MVC Architecture
- Java Packages
- Collections (`ArrayList`)
- `LocalDate` for safe date handling
- File I/O for data persistence
- Input validation and error handling
- Method overriding (`toString()`)

---

## ⚙️ Technologies
- Java
- Standard Java Libraries
- Console-based UI

---

## 📂 Project Structure (MVC with Packages)
```
TutorSessionManager/
 ├── src/
 │   ├── controller/
 │   │   └── TutorController.java
 │   ├── model/
 │   │   ├── Student.java
 │   │   ├── Session.java
 │   │   └── TutorManager.java
 │   ├── view/
 │   │   └── ConsoleView.java
 │   ├── Main.java
 │   └── database.txt  <-- auto-created when program runs
 └── README.md
```

### Package Responsibilities
- **model** → Business logic and data (Student, Session, TutorManager)
- **view** → Console-based user interface (ConsoleView)
- **controller** → Application flow and coordination (TutorController)
- **Main** → Application entry point

---

## ▶️ How to Compile and Run (Windows)

### Compile all Java files
```bash
javac src\controller\*.java src\model\*.java src\view\*.java src\Main.java
```

### Run the program
```bash
java -cp src Main
```

> The program will automatically create `src/database.txt` the first time you add a session and exit.

---

## 🧪 Sample Menu
```
--- TUTOR SESSION MANAGEMENT ---
1. add student
2. view students
3. schedule session
4. view sessions
5. mark session as completed
6. exit
```

---

## 🚀 Future Improvements
- GUI (JavaFX or Swing)
- Database integration (MySQL / PostgreSQL)
- Authentication & user roles
- Sorting and filtering sessions
- Reporting and analytics

---

## 👨‍💻 Author
**Milton Mushi**

Computer Science Graduate | Java Developer
