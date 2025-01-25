package com.example.services;

import java.util.Scanner;
import com.example.database.Database;
import com.example.model.Book;
import com.example.model.Admin;
import com.example.model.Student;

public class LibraryManagement {
    private final Database db;

    public LibraryManagement(Database db) {
        this.db = db;
    }

    public void start() {
        System.out.println("");
        System.out.println("Library Management System Started.");
        System.out.printf("Admins: %d | Students: %d | Books: %d\n",
                db.admins.size(), db.students.size(), db.books.size());
    }

    public void menu() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n--- Library Management Menu ---");
                System.out.println("1. Borrow Book");
                System.out.println("2. Return Book");
                System.out.println("3. Display All Books");
                System.out.println("4. Add Book");
                System.out.println("5. Add User (Admin or Student)");
                System.out.println("6. Display All Users");
                System.out.println("7. Delete User");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> handleBorrow(scanner);
                    case 2 -> handleReturn(scanner);
                    case 3 -> db.displayBooks();
                    case 4 -> handleAddBook(scanner);
                    case 5 -> handleAddUser(scanner);
                    case 6 -> handleDisplayUsers();
                    case 7 -> handleDeleteUser(scanner);
                    case 8 -> {
                        System.out.println("Exiting Library Management System. Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private void handleBorrow(Scanner scanner) {
        System.out.print("Enter Book ID to borrow: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        Book book = db.books.stream()
                .filter(b -> b.getTitle().equals(bookId))
                .findFirst()
                .orElse(null);

        if (book == null) {
            System.out.println("Book ID not found.");
        } else if (book.isAvailable()) {
            book.setAvailable(false);
            book.setBorrowedBy(userId);
            System.out.println("Book borrowed successfully by User ID: " + userId);
        } else {
            System.out.println("Book is already borrowed.");
        }
    }

    private void handleReturn(Scanner scanner) {
        System.out.print("Enter Book ID to return: ");
        String bookId = scanner.nextLine();
        Book book = db.books.stream()
                .filter(b -> b.getTitle().equals(bookId))
                .findFirst()
                .orElse(null);

        if (book == null) {
            System.out.println("Book ID not found.");
        } else if (!book.isAvailable()) {
            book.setAvailable(true);
            book.setBorrowedBy(null);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book was not borrowed.");
        }
    }

    private void handleAddBook(Scanner scanner) {
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        db.addBook(new Book(title, author, true, "path/to/book"));
        System.out.println("Book added successfully.");
    }

    private void handleAddUser(Scanner scanner) {
        System.out.print("Enter user type (Admin/Student): ");
        String userType = scanner.nextLine().toLowerCase();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();

        if (userType.equals("admin")) {
            db.addAdmin(new Admin(name, userId));
            System.out.println("Admin added successfully.");
        } else if (userType.equals("student")) {
            db.addStudent(new Student(name, userId));
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Invalid user type. Please enter 'Admin' or 'Student'.");
        }
    }

    private void handleDisplayUsers() {
        System.out.println("\n--- Admins ---");
        if (db.admins.isEmpty()) {
            System.out.println("No admins found.");
        } else {
            db.admins.forEach(admin -> System.out.printf("ID: %s | Name: %s%n", admin.getUserId(), admin.getName()));
        }

        System.out.println("\n--- Students ---");
        if (db.students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            db.students.forEach(student -> System.out.printf("ID: %s | Name: %s%n", student.getUserId(), student.getName()));
        }
    }

    private void handleDeleteUser(Scanner scanner) {
        System.out.print("Enter User ID to delete: ");
        String userId = scanner.nextLine();
        boolean removed = db.admins.removeIf(user -> user.getUserId().equals(userId)) ||
                         db.students.removeIf(user -> user.getUserId().equals(userId));
        if (removed) {
            System.out.println("User with ID " + userId + " has been deleted.");
        } else {
            System.out.println("User ID not found.");
        }
    }

    public static void main(String[] args) {
        Database db = new Database();

        db.addAdmin(new Admin("Tanmaya", "A001"));
        db.addStudent(new Student("Aarav", "S001"));
        db.addStudent(new Student("Abhiraj", "S002"));
        db.addStudent(new Student("Akshat", "S003"));
        db.addBook(new Book("Java Programming", "Author A", true, "path/to/book"));
        db.addBook(new Book("Data Structures", "Author B", true, "path/to/book"));

        LibraryManagement management = new LibraryManagement(db);
        management.start();
        management.menu();
    }
}
