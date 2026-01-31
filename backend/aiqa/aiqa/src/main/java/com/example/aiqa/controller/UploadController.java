package com.example.aiqa.controller;

import com.example.aiqa.model.FileMetadata;
import com.example.aiqa.repository.FileMetadataRepository;
import com.example.aiqa.service.FileStorageService;
import com.example.aiqa.service.PdfService;
import com.example.aiqa.service.TranscriptionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

    private final FileStorageService storageService;
    private final PdfService pdfService;
    private final TranscriptionService transcriptionService;
    private final FileMetadataRepository repo;

    public UploadController(FileStorageService storageService, PdfService pdfService, TranscriptionService transcriptionService, FileMetadataRepository repo) {
        this.storageService = storageService;
        this.pdfService = pdfService;
        this.transcriptionService = transcriptionService;
        this.repo = repo;
    }

    @PostMapping
    public Map<String, Object> upload(@RequestParam MultipartFile file) throws Exception {

        Path path = storageService.save(file);

        FileMetadata meta = new FileMetadata();
        meta.setFilename(file.getOriginalFilename());
        meta.setFileType(file.getContentType());
        meta.setSize(file.getSize());
        meta.setUploadedAt(LocalDateTime.now());
        repo.save(meta);

        if (file.getOriginalFilename().endsWith(".pdf")) {
            String text = pdfService.extractText(path);
            return Map.of("status", "PDF processed", "textLength", text.length());
        } else {
            var segments = transcriptionService.transcribe((org.hibernate.query.restriction.Path<String, String>) (Object) path.toAbsolutePath());
            return Map.of("status", "Media processed", "segments", segments);
        }
    }
}

