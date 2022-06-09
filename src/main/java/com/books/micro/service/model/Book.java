package com.books.micro.service.model;

import lombok.Data;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * Book
 */
@Entity
@Data
@Table (name = "books")
public class Book {

    private long bookId;
    @NotEmpty(message = "Please provide a book name")
    private String bookName;
    @NotEmpty(message = "Please provide a book size")
    private String bookSize;
    @NotEmpty(message = "Please provide a author name")
    private String authorName;
    @NotEmpty(message = "Please provide a book category")
    private String bookCategory;
    @NotNull(message = "Please provide the number of copies")
    @Min(0)
    @Max(1000000000)
    private Integer copiesNumber;
    @NotNull(message = "Please provide a book availability")
    private boolean availability;
    private Timestamp timestamp;

    public Book() {

    }

    public Book(String bookName, String bookSize, String authorName, String bookCategory, Integer copiesNumber, boolean availability) {
        this.bookName = bookName;
        this.bookSize = bookSize;
        this.authorName = authorName;
        this.bookCategory = bookCategory;
        this.copiesNumber = copiesNumber;
        this.availability = availability;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    @Column(name = "book_name", nullable = false)
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Column(name = "book_size", nullable = false)
    public String getBookSize() {
        return bookSize;
    }

    public void setBookSize(String bookSize) {
        this.bookSize = bookSize;
    }

    @Column(name = "author_name", nullable = false)
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Column(name = "book_category", nullable = false)
    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    @Column(name = "copies_number", nullable = false)
    public Integer getCopiesNumber() {
        return copiesNumber;
    }

    public void setCopiesNumber(Integer copiesNumber) {
        this.copiesNumber = copiesNumber;
    }

    @Column(name = "availability", nullable = false)
    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Column(name="timestamp", insertable = false, updatable = false,
            columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookSize='" + bookSize + '\'' +
                ", authorName='" + authorName + '\'' +
                ", bookCategory='" + bookCategory + '\'' +
                ", copiesNumber=" + copiesNumber +
                ", availability=" + availability +
                ", timestamp=" + timestamp +
                '}';
    }
}
