package com.example.aiqa.controller;

import com.example.aiqa.service.OpenAiService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/summary")
public class SummaryController {

    private final OpenAiService openAiService;

    public SummaryController(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    @PostMapping
    public Map<String, String> summarize(@RequestBody String text) {
        return Map.of("summary", openAiService.ask("Summarize:\n" + text));
    }
}

