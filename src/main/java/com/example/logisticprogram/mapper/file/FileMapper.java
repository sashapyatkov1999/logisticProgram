package com.example.logisticprogram.mapper.file;

import com.example.logisticprogram.dto.request.file.FileAddRequest;
import com.example.logisticprogram.entity.File;
import com.example.logisticprogram.entity.Role;
import com.example.logisticprogram.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileMapper implements Mapper<File, FileAddRequest> {
    @Override
    public File from(FileAddRequest source) {
        return new File()
                .setName(source.getName())
                .setDescription(source.getDescription());
    }
}
