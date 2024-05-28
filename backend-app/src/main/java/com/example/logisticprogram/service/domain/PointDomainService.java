package com.example.logisticprogram.service.domain;

import com.example.logisticprogram.dto.request.application.ApplicationAddRequest;
import com.example.logisticprogram.dto.request.point.PointAddRequest;
import com.example.logisticprogram.dto.response.point.PointResponse;
import com.example.logisticprogram.mapper.point.PointMapper;
import com.example.logisticprogram.mapper.point.PointMerger;
import com.example.logisticprogram.mapper.point.PointResponseMapper;
import com.example.logisticprogram.repository.PointRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PointDomainService {
    private final PointRepository pointRepository;
    private final PointMapper pointMapper;
    private final PointResponseMapper pointResponseMapper;
    private final PointMerger pointMerger;

    @Transactional
    public PointResponse getPoint(Long id) {
        return pointResponseMapper.from(pointRepository.getReferenceById(id));
    }

    @Transactional
    public List<PointResponse> getAllPoints() {
        return pointResponseMapper.from(pointRepository.findAll());

    }

    @Transactional
    public void deletePoint(Long id) {
        pointRepository.deleteById(id);
    }

    @Transactional
    public Long addPoint(PointAddRequest request) {
        return pointRepository.save(pointMapper.from(request)).getId();
    }
    @Transactional
    public void editPoint(PointAddRequest request) {
        var application = pointRepository.getReferenceById(request.getId());
        pointRepository.save(pointMerger.merge(application, request)).getId();
    }
}
