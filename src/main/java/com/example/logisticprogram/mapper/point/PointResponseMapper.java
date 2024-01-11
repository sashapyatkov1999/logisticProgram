package com.example.logisticprogram.mapper.point;

import com.example.logisticprogram.dto.response.point.PointResponse;
import com.example.logisticprogram.dto.response.role.RoleResponse;
import com.example.logisticprogram.entity.Point;
import com.example.logisticprogram.mapper.Mapper;
import com.example.logisticprogram.mapper.application.ApplicationResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointResponseMapper implements Mapper<PointResponse, Point> {
    private final ApplicationResponseMapper applicationResponseMapper;
    @Override
    public PointResponse from(Point source) {
        return new PointResponse()
                .setId(source.getId())
                .setApplication(applicationResponseMapper.from(source.getApplication()))
                .setField(source.getField())
                .setOrdinal(Math.toIntExact(source.getOrdinal()))
                .setStatusOfOrdinalWithGeo(source.getStatusOfOrdinalWithGeo())
                .setName(source.getName())
                .setDescription(source.getDescription())
                .setCreated(source.getCreated())
                .setModified(source.getModified())
                .setTimeStart(source.getTimeStart())
                .setTimeEnd(source.getTimeEnd());
    }


}
