package com.example.model;

public class Student extends User {
    public Student(String name, String userId) {
        super(name, userId);
    }

    public void borrowBook() {
        System.out.println(getName() + " has borrowed a book.");
    }

    public void returnBook() {
        System.out.println(getName() + " has returned a book.");
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Student Name: " + getName());
        System.out.println("Student ID: " + getUserId());
    }
}