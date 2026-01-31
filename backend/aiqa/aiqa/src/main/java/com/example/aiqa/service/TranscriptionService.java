package com.example.aiqa.service;

import org.hibernate.query.restriction.Path;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TranscriptionService {

    public List<Map<String, Object>> transcribe(Path<String, String> mediaPath) {
        // Stub for now
        return List.of(
                Map.of("text", "Sample transcript", "start", 10, "end", 20)
        );
    }
}
