package com.example.model;

public class Book {
    private String title;
    private String author;
    private boolean available;
    private String filePath;
    private String borrowedBy;

    public Book(String title, String author, boolean available, String filePath) {
        this.title = title;
        this.author = author;
        this.available = available;
        this.filePath = filePath;
        this.borrowedBy = null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(String borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    public void borrow(String borrower) {
        if (available) {
            available = false;
            setBorrowedBy(borrower);
            System.out.println("The book '" + title + "' has been borrowed by " + borrowedBy + ".");
        } else {
            System.out.println("The book '" + title + "' is not available.");
        }
    }

    public void returnBook() {
        if (!available) {
            available = true;
            System.out.println("The book '" + title + "' has been returned by " + borrowedBy + ".");
            borrowedBy = null;
        } else {
            System.out.println("The book '" + title + "' was not borrowed.");
        }
    }
}
