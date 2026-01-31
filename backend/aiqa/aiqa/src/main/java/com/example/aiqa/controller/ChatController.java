package com.example.aiqa.controller;

import com.example.aiqa.service.OpenAiService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final OpenAiService openAiService ;

    public ChatController(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    @PostMapping
    public Map<String, String> chat(@RequestParam String query) {
        return Map.of("answer", openAiService.ask(query));
    }
}

