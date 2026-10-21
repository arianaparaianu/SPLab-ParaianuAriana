package org.example.designpatternslab.commands;

import org.example.designpatternslab.services.BooksService;

public class UpdateBookCommand implements Command<String> {

    private final BooksService booksService;
    private final Long id;
    private final String book;

    public UpdateBookCommand(BooksService booksService, Long id, String book) {
        this.booksService = booksService;
        this.id = id;
        this.book = book;
    }

    @Override
    public String execute() {
        booksService.updateBook(id, book);
        return "Book updated: " + book;
    }
}