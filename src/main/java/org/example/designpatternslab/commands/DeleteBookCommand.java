package org.example.designpatternslab.commands;

import org.example.designpatternslab.services.BooksService;

public class DeleteBookCommand implements Command<String> {

    private final BooksService booksService;
    private final Long id;

    public DeleteBookCommand(BooksService booksService, Long id) {
        this.booksService = booksService;
        this.id = id;
    }

    @Override
    public String execute() {
        booksService.deleteBook(id);
        return "Book deleted with id: " + id;
    }
}