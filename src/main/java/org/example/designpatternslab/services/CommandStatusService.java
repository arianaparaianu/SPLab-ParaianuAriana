package org.example.designpatternslab.services;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CommandStatusService {

    private final Map<String, String> statuses =
            new ConcurrentHashMap<>();

    public String createRequest() {
        String id = UUID.randomUUID().toString();
        statuses.put(id, "PENDING");
        return id;
    }

    public void markCompleted(String id) {
        statuses.put(id, "COMPLETED");
    }

    public void markFailed(String id) {
        statuses.put(id, "FAILED");
    }

    public String getStatus(String id) {
        return statuses.getOrDefault(id, "NOT_FOUND");
    }
}