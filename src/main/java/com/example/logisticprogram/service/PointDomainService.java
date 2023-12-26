package com.example.logisticprogram.service;

import com.example.logisticprogram.dto.request.file.FileAddRequest;
import com.example.logisticprogram.dto.request.point.PointAddRequest;
import com.example.logisticprogram.dto.response.file.FileResponse;
import com.example.logisticprogram.dto.response.point.PointResponse;
import com.example.logisticprogram.mapper.point.PointMapper;
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
}
