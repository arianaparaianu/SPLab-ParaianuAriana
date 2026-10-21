package org.example.designpatternslab.controllers;

import org.example.designpatternslab.services.CommandStatusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commands")
public class CommandStatusController {

    private final CommandStatusService commandStatusService;

    public CommandStatusController(
            CommandStatusService commandStatusService) {
        this.commandStatusService = commandStatusService;
    }

    @GetMapping("/{id}/status")
    public String getStatus(@PathVariable String id) {
        return commandStatusService.getStatus(id);
    }
}