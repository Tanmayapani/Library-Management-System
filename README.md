# **Library Management System**

A simple and interactive Java-based Library Management System designed to manage books, users (admins & students), and borrowing and returning operations. This system utilizes object-oriented principles to handle core functionalities efficiently.

---

## **Features**

- **Admin and Student Management**
  - Add new users (Admins or Students).
  - Display all registered users.
  - Delete users by their ID.

- **Book Management**
  - Add new books with details such as title and author.
  - Display all available books in the library.
  - Borrow books by users with real-time availability checks.
  - Return borrowed books, updating the library inventory.

- **Interactive Menu**
  - Easy-to-navigate menu-driven interface for all operations.
  - Provides feedback for invalid operations or IDs.

---

## **Tech Stack**

- **Language**: Java
- **Concepts**: Object-Oriented Programming (OOP)
- **Tools**: Scanner for user input, ArrayList for data storage, Stream API for operations.

---

## **How It Works**

1. The program starts with a welcome message and displays the current count of admins, students, and books.
2. Users can interact with the system through a dynamic menu to perform various operations:
   - Borrow a book.
   - Return a book.
   - Add or delete users.
   - View all users or books.
   - Add new books to the inventory.
3. Data is dynamically stored in memory during runtime (using `ArrayList`).

---

## **Getting Started**

### Prerequisites
- Java Development Kit (JDK) 11 or above.
- A Java IDE or text editor (e.g., IntelliJ IDEA, Eclipse, VS Code).

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/Tanmayapani/Library-Management-System.git
   cd Library-Management-System
