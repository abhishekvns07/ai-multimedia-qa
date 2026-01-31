package com.example.aiqa.service;

import org.springframework.stereotype.Service;

@Service
public class VectorService {

    public void indexText(String text) {
    }

    public String semanticSearch(String query) {
        return "Relevant chunk for: " + query;
    }
}
