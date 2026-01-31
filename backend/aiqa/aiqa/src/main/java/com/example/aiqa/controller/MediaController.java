package com.example.aiqa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/media")
public class MediaController {

    @GetMapping("/timestamp")
    public Map<String, Object> timestamp(@RequestParam String topic) {
        return Map.of(
                "topic", topic,
                "startTime", 30,
                "endTime", 60
        );
    }
}