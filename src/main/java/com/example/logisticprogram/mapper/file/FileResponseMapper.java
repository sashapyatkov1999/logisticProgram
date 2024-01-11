package com.example.logisticprogram.mapper.file;

import com.example.logisticprogram.dto.response.file.FileResponse;
import com.example.logisticprogram.dto.response.role.RoleResponse;
import com.example.logisticprogram.entity.File;
import com.example.logisticprogram.entity.User;
import com.example.logisticprogram.mapper.Mapper;
import com.example.logisticprogram.mapper.application.ApplicationResponseMapper;
import com.example.logisticprogram.mapper.point.PointResponseMapper;
import com.example.logisticprogram.mapper.user.UserResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileResponseMapper implements Mapper<FileResponse, File> {
   private final UserResponseMapper userResponseMapper;
   private final PointResponseMapper pointResponseMapper;
   private final ApplicationResponseMapper applicationResponseMapper;
    @Override
    public FileResponse from(File source) {
        return new FileResponse()
                .setId(source.getId())
                .setUser(userResponseMapper.from(source.getUser()))
                .setApplication(applicationResponseMapper.from(source.getApplication()))
                .setPoint(pointResponseMapper.from(source.getPoint()))
                .setName(source.getName())
                .setDescription(source.getDescription())
                .setCreated(source.getCreated())
                .setModified(source.getModified());
    }
}
