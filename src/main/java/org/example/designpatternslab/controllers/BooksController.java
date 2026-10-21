package org.example.designpatternslab.controllers;

import org.example.designpatternslab.commands.*;
import org.example.designpatternslab.services.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;
    private final SynchronousCommandExecutor synchronousCommandExecutor;
    private final AsynchronousCommandExecutor asynchronousCommandExecutor;

    public BooksController(
            BooksService booksService,
            SynchronousCommandExecutor synchronousCommandExecutor,
            AsynchronousCommandExecutor asynchronousCommandExecutor) {

        this.booksService = booksService;
        this.synchronousCommandExecutor = synchronousCommandExecutor;
        this.asynchronousCommandExecutor = asynchronousCommandExecutor;
    }

    @GetMapping
    public List<String> getAllBooks() {

        GetAllBooksCommand command =
                new GetAllBooksCommand(booksService);

        return synchronousCommandExecutor.execute(command).join();
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable Long id) {

        GetBookByIdCommand command =
                new GetBookByIdCommand(booksService, id);

        return synchronousCommandExecutor.execute(command).join();
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createBook(
            @RequestBody String book) {

        CreateBookCommand command =
                new CreateBookCommand(booksService, book);

        String requestId =
                asynchronousCommandExecutor.executeAsync(command);

        return ResponseEntity.accepted().body(
                Map.of(
                        "requestId", requestId,
                        "status", "PENDING"
                )
        );
    }

    @PutMapping("/{id}")
    public String updateBook(
            @PathVariable Long id,
            @RequestBody String book) {

        UpdateBookCommand command =
                new UpdateBookCommand(booksService, id, book);

        return synchronousCommandExecutor.execute(command).join();
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {

        DeleteBookCommand command =
                new DeleteBookCommand(booksService, id);

        return synchronousCommandExecutor.execute(command).join();
    }
}