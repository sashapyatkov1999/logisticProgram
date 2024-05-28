package com.example.logisticprogram.mapper.point;

import com.example.logisticprogram.dto.request.point.PointAddRequest;
import com.example.logisticprogram.entity.Application;
import com.example.logisticprogram.entity.Point;
import com.example.logisticprogram.mapper.Merger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointMerger implements Merger<Point, PointAddRequest> {
    @Override
    public Point merge(Point target, PointAddRequest source) {

        return target
                .setField(source.getField())
                .setOrdinal(Long.valueOf(source.getOrdinal()))
                .setApplication(new Application(source.getApplicationId()))
                .setName(source.getName())
                .setStatusOfOrdinalWithGeo(source.getStatusOfOrdinalWithGeo())
                .setDescription(source.getDescription())
                .setTimeStart(source.getTimeStart())
                .setTimeEnd(source.getTimeEnd());
    }
}
