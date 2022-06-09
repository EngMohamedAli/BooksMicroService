package com.books.micro.service.service;

import com.books.micro.service.model.Book;
import com.books.micro.service.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplEndpoint {

    @Autowired
    private BookRepository bookRepository;

    /**
     * add new books
     * @param book
     * @return insertion status
     */
    public Book addNewBooks(Book book) {
        return bookRepository.save(book);
    }

    /**
     * list all books
     * @return Books list
     */
    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }

}
