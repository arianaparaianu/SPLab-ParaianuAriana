package org.example.designpatternslab.commands;

import org.example.designpatternslab.services.BooksService;

public class CreateBookCommand implements Command<String> {

    private final BooksService booksService;
    private final String book;

    public CreateBookCommand(BooksService booksService, String book) {
        this.booksService = booksService;
        this.book = book;
    }

    @Override
    public String execute() {
        booksService.createBook(book);
        return "Book created: " + book;
    }
}