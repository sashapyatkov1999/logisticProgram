package com.example.logisticprogram.mapper.point;

import com.example.logisticprogram.dto.request.point.PointAddRequest;
import com.example.logisticprogram.dto.response.point.PointResponse;
import com.example.logisticprogram.entity.Point;
import com.example.logisticprogram.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointMapper implements Mapper<Point, PointAddRequest> {
    @Override
    public Point from(PointAddRequest source) {
        return new Point()
                .setField(source.getField())
                .setOrdinal(Long.valueOf(source.getOrdinal()))
                .setStatusOfOrdinalWithGeo(source.getStatusOfOrdinalWithGeo())
                .setName(source.getName())
                .setDescription(source.getDescription());
    }
}
