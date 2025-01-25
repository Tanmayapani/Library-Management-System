package com.example.database;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Admin;
import com.example.model.Student;
import com.example.model.Book;
import com.example.model.User;

public class Database {
    public List<Admin> admins;
    public List<Student> students;
    public List<Book> books;

    public Database() {
        this.admins = new ArrayList<>();
        this.students = new ArrayList<>();
        this.books = new ArrayList<>();
    }

    public void addAdmin(Admin admin) {
        admins.add(admin);
        System.out.println("Admin added: "+ admin.getName());
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added: " + student.getName());
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void deleteUser(String userId) {
        admins.removeIf(admin -> admin.getUserId().equals(userId));
        students.removeIf(student -> student.getUserId().equals(userId));
        System.out.println("User with ID " + userId + " has been deleted.");
    }

    public void deleteBook(String title) {
        books.removeIf(book -> book.getTitle().equals(title));
        System.out.println("Book with title '" + title + "' has been deleted.");
    }

    public User searchUser(String userId) {
        for (Admin admin : admins) {
            if (admin.getUserId().equals(userId)) {
                return admin;
            }
        }
        for (Student student : students) {
            if (student.getUserId().equals(userId)) {
                return student;
            }
        }
        System.out.println("User with ID " + userId + " not found.");
        return null;
    }

    public void searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                System.out.println("Book with title '"+ title + "' found.");
                System.out.println("Author of the book: "+ book.getAuthor());
                System.out.println("Book is available? "+ book.isAvailable());
            }   
        }
        System.out.println("Book with title '" + title + "' not found.");
    }

    public void displayBooks() {
        System.out.println("Books in the library:");
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Available: " + book.isAvailable());
        }
    }
}

