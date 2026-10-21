package org.example.designpatternslab.commands;

import java.util.concurrent.CompletableFuture;

public interface CommandExecutor {

    <T> CompletableFuture<T> execute(Command<T> command);
}