package com.books.micro.service.controller;

import com.books.micro.service.model.Book;
import com.books.micro.service.service.BookServiceImplEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.books.micro.service.Util.Constants;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BookController
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
@Validated
public class BookController {

    @Autowired
    private BookServiceImplEndpoint bookServiceImplEndpoint;

    /**
     * add new books
     * @param inputBook
     * @return Insertion status
     */
    @PostMapping("/books")
    public ResponseEntity<Map<String, Object>> addNewBooks(@Valid @RequestBody Book inputBook) {
        Map<String, Object> response = new HashMap<>();
        try {
            boolean valid = true;
            List<String> messages = new ArrayList<>();

            if (inputBook != null) {

                if (StringUtils.isEmpty(inputBook.getBookName())) {
                    messages.add("Please enter valid book name");
                    valid = false;
                }
                if (StringUtils.isEmpty(inputBook.getBookSize())) {
                    messages.add("Please enter valid book size");
                    valid = false;
                }
                if (StringUtils.isEmpty(inputBook.getAuthorName())) {
                    messages.add("Please enter valid author name");
                    valid = false;
                }
                if (StringUtils.isEmpty(inputBook.getBookCategory())) {
                    messages.add("Please enter valid book category");
                    valid = false;
                }
                if (StringUtils.isEmpty(String.valueOf(inputBook.getCopiesNumber()))) {
                    messages.add("Please enter valid number of copies");
                    valid = false;
                }
                if (StringUtils.isEmpty(String.valueOf(inputBook.isAvailability()))) {
                    messages.add("Please enter valid book availability");
                    valid = false;
                }

                if (valid) {

                    Book newBook = new Book(inputBook.getBookName(), inputBook.getBookSize(), inputBook.getAuthorName(),
                            inputBook.getBookCategory(), inputBook.getCopiesNumber(), inputBook.isAvailability());
                    bookServiceImplEndpoint.addNewBooks(newBook);
                    messages.add("The Data Saved Correctly");
                }

                response.put(Constants.STATUS, "ok");
                response.put(Constants.VALID, String.valueOf(valid));
                response.put(Constants.VALIDATION, "passed");
                response.put(Constants.MESSAGES, messages);

                return new ResponseEntity<>(response, HttpStatus.CREATED);

            } else {

                response.put(Constants.STATUS, "not inserted");
                response.put(Constants.VALID, "false");
                response.put(Constants.VALIDATION, "The data is empty or null");
                response.put(Constants.MESSAGES, "Please Enter Valid Book Data");

                return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);

            }

        } catch (Exception e) {
            response.put(Constants.STATUS, "exception");
            response.put(Constants.VALID, "false");
            response.put(Constants.VALIDATION, "failed");
            response.put(Constants.MESSAGES, e.getLocalizedMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * list all books
     * @return Books list
     */
    @GetMapping("/books")
    public ResponseEntity<List<Book>> listAllBooks() {
        try {
            List<Book> booksList = bookServiceImplEndpoint.listAllBooks();
            if (booksList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(booksList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
