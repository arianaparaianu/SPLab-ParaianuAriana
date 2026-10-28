package org.example.designpatternslab.commands;

public class DeleteBookCommand implements Command<String> {

    private final CommandContext context;
    private final Integer id;

    public DeleteBookCommand(CommandContext context, Integer id) {
        this.context = context;
        this.id = id;
    }

    @Override
    public String execute() {
        context.getBooksRepository().deleteById(id);
        return "Book deleted with id: " + id;
    }
}