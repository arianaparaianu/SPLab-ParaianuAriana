package org.example.designpatternslab.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksService {

    private final List<String> books = new ArrayList<>();

    public BooksService() {
        books.add("Design Patterns");
        books.add("Clean Code");
        books.add("Effective Java");
    }

    public List<String> getAllBooks() {
        return books;
    }

    public String getBookById(Long id) {
        return books.get(id.intValue());
    }

    public void createBook(String book) {
        books.add(book);
    }

    public void updateBook(Long id, String book) {
        books.set(id.intValue(), book);
    }

    public void deleteBook(Long id) {
        books.remove(id.intValue());
    }
}