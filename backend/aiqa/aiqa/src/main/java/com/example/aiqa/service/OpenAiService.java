package com.example.aiqa.service;

import org.springframework.stereotype.Service;

@Service
public class OpenAiService {

    public String ask(String prompt) {
        return "AI response for: " + prompt;
    }
}
