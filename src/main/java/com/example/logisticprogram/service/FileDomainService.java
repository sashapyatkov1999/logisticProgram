package com.example.logisticprogram.service;

import com.example.logisticprogram.dto.request.application.ApplicationAddRequest;
import com.example.logisticprogram.dto.request.file.FileAddRequest;
import com.example.logisticprogram.dto.response.application.ApplicationResponse;
import com.example.logisticprogram.dto.response.file.FileResponse;
import com.example.logisticprogram.mapper.file.FileMapper;
import com.example.logisticprogram.mapper.file.FileResponseMapper;
import com.example.logisticprogram.repository.FileRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileDomainService {
    private final FileRepository fileRepository;
    private final FileResponseMapper fileResponseMapper;
    private final FileMapper fileMapper;

    @Transactional
    public FileResponse getFile(Long id) {
        return fileResponseMapper.from(fileRepository.getReferenceById(id));
    }

    @Transactional
    public List<FileResponse> getAllFiles() {
        return fileResponseMapper.from(fileRepository.findAll());

    }

    @Transactional
    public void deleteFile(Long id) {
        fileRepository.deleteById(id);
    }

    @Transactional
    public Long addFile(FileAddRequest request) {
        return fileRepository.save(fileMapper.from(request)).getId();

    }
}
