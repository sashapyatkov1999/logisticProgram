package com.example.logisticprogram.mapper.file;

import com.example.logisticprogram.dto.response.file.FileResponse;
import com.example.logisticprogram.dto.response.role.RoleResponse;
import com.example.logisticprogram.entity.File;
import com.example.logisticprogram.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileResponseMapper implements Mapper<FileResponse, File> {
    @Override
    public FileResponse from(File source) {
        return new FileResponse()
                .setId(source.getId())
                .setName(source.getName())
                .setDescription(source.getDescription())
                .setCreated(source.getCreated())
                .setModified(source.getModified());
    }
}
