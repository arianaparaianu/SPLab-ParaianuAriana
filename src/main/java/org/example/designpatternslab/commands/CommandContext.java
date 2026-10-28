package org.example.designpatternslab.commands;

import org.example.designpatternslab.Book;
import org.example.designpatternslab.persistence.CrudRepository;

public class CommandContext {

    private final CrudRepository<Book, Integer> booksRepository;

    public CommandContext(CrudRepository<Book, Integer> booksRepository) {
        this.booksRepository = booksRepository;
    }

    public CrudRepository<Book, Integer> getBooksRepository() {
        return booksRepository;
    }
}