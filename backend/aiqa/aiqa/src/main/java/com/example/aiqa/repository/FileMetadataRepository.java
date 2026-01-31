package com.example.aiqa.repository;

import com.example.aiqa.model.FileMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileMetadataRepository
        extends JpaRepository<FileMetadata, Long> {
}
