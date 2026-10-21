package org.example.designpatternslab.commands;

import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class SynchronousCommandExecutor implements CommandExecutor {

    @Override
    public <T> CompletableFuture<T> execute(Command<T> command) {
        T result = command.execute();
        return CompletableFuture.completedFuture(result);
    }
}