package org.example.designpatternslab.controllers;

import org.example.designpatternslab.Book;
import org.example.designpatternslab.commands.*;
import org.example.designpatternslab.persistence.BooksRepositoryAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final CommandContext commandContext;
    private final SynchronousCommandExecutor synchronousCommandExecutor;
    private final AsynchronousCommandExecutor asynchronousCommandExecutor;

    public BooksController(
            BooksRepositoryAdapter booksRepositoryAdapter,
            SynchronousCommandExecutor synchronousCommandExecutor,
            AsynchronousCommandExecutor asynchronousCommandExecutor) {

        this.commandContext = new CommandContext(booksRepositoryAdapter);
        this.synchronousCommandExecutor = synchronousCommandExecutor;
        this.asynchronousCommandExecutor = asynchronousCommandExecutor;
    }

    @GetMapping
    public List<Book> getAllBooks() {

        GetAllBooksCommand command =
                new GetAllBooksCommand(commandContext);

        return synchronousCommandExecutor.execute(command).join();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id) {

        GetBookByIdCommand command =
                new GetBookByIdCommand(commandContext, id);

        return synchronousCommandExecutor.execute(command).join();
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createBook(
            @RequestBody String title) {

        CreateBookCommand command =
                new CreateBookCommand(commandContext, title);

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
    public Book updateBook(
            @PathVariable Integer id,
            @RequestBody String title) {

        UpdateBookCommand command =
                new UpdateBookCommand(commandContext, id, title);

        return synchronousCommandExecutor.execute(command).join();
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Integer id) {

        DeleteBookCommand command =
                new DeleteBookCommand(commandContext, id);

        return synchronousCommandExecutor.execute(command).join();
    }
}