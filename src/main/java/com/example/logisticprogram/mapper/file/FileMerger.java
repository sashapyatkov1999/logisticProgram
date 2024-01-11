package com.example.logisticprogram.mapper.file;

import com.example.logisticprogram.dto.request.file.FileAddRequest;
import com.example.logisticprogram.entity.Application;
import com.example.logisticprogram.entity.File;
import com.example.logisticprogram.entity.Point;
import com.example.logisticprogram.entity.User;
import com.example.logisticprogram.mapper.Merger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileMerger implements Merger<File, FileAddRequest> {
    @Override
    public File merge(File target, FileAddRequest source) {
        return target
                .setPoint(new Point(source.getPointId()))
                .setApplication(new Application(source.getApplicationId()))
                .setUser(new User(source.getUserId()))
                .setDescription(source.getDescription())
                .setName(source.getName());
    }
}
