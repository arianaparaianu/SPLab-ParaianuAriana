package org.example.designpatternslab.controllers;

import org.example.designpatternslab.difexamples.ClientComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final ClientComponent clientComponent;

    @Autowired
    public HelloController(ClientComponent clientComponent) {
        this.clientComponent = clientComponent;
    }

    @GetMapping("/")
    public String hello() {
        clientComponent.operation();
        return "Hello from Spring Boot";
    }
}