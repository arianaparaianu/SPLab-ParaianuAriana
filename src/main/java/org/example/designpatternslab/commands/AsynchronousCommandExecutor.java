package org.example.designpatternslab.commands;

import org.example.designpatternslab.services.CommandStatusService;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class AsynchronousCommandExecutor implements CommandExecutor {

    private final ExecutorService executorService =
            Executors.newFixedThreadPool(2);

    private final CommandStatusService commandStatusService;

    public AsynchronousCommandExecutor(
            CommandStatusService commandStatusService) {
        this.commandStatusService = commandStatusService;
    }

    @Override
    public <T> CompletableFuture<T> execute(Command<T> command) {
        return CompletableFuture.supplyAsync(
                command::execute,
                executorService
        );
    }

    public <T> String executeAsync(Command<T> command) {

        String requestId = commandStatusService.createRequest();

        executorService.submit(() -> {
            try {
                command.execute();
                commandStatusService.markCompleted(requestId);
            } catch (Exception e) {
                commandStatusService.markFailed(requestId);
            }
        });

        return requestId;
    }
}