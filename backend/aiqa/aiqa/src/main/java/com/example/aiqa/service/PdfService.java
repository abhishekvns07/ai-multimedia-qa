package com.example.aiqa.service;

import org.springframework.stereotype.Service;
import java.nio.file.Path;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

@Service
public class PdfService {

    public String extractText(Path path) {
        try (PDDocument doc = PDDocument.load(path.toFile())) {
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(doc);
        } catch (Exception e) {
            throw new RuntimeException("PDF processing failed", e);
        }
    }
}