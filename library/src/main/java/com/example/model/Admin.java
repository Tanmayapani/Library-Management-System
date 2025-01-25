package com.example.model;

public class Admin extends User {
    public Admin(String name, String userId) {
        super(name, userId);
    }

    public void addBook() {
        System.out.println(getName() + " has added a new book to the library.");
    }

    public void uploadBook() {
        System.out.println(getName() + " has uploaded a digital copy of a book.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Admin Name: " + getName());
        System.out.println("Admin ID: " + getUserId());
    }
}