package com.example.aiqa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.jspecify.annotations.Nullable;

import java.time.LocalDateTime;

@Entity
public class FileMetadata {

    @Id
    @GeneratedValue
    private Long id;

    public FileMetadata() {
    }

    private String filename;
    private String fileType;
    private Long size;
    private LocalDateTime uploadedAt;

    public void setFilename(@Nullable String originalFilename) {
        this.filename = originalFilename;
    }

    public void setFileType(@Nullable String contentType) {
        this.fileType = contentType;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setUploadedAt(LocalDateTime now) {
        this.uploadedAt = now;
    }

    public String getFilename() {
        return filename;
    }

    public String getFileType() {
        return fileType;
    }

    public Long getSize() {
        return size;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    // getters and setters
}
