package com.example.logisticprogram.service.domain;

import com.example.logisticprogram.dto.request.point.PointAddRequest;
import com.example.logisticprogram.dto.response.point.PointResponse;
import com.example.logisticprogram.entity.Point;
import com.example.logisticprogram.mapper.point.PointMapper;
import com.example.logisticprogram.mapper.point.PointResponseMapper;
import com.example.logisticprogram.repository.PointRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class PointDomainServiceTest {

    @Mock
    private PointRepository pointRepository;

    @Mock
    private PointResponseMapper pointResponseMapper;
    @Mock
    private PointMapper pointMapper;
    @InjectMocks
    private PointDomainService service;

    private final PointAddRequest pointAddRequestAdd = new PointAddRequest();
    private final List<Point> points = new ArrayList<>();
    private final Point pointAdd = new Point(1L);
    private final List<PointResponse> pointResponses = new ArrayList<>();
    private final Long ID = 0L;


    @Test
    void getPointTest() {

        when(pointResponseMapper.from((Point) any())).thenReturn(getPointResponse());
        when(pointRepository.getReferenceById(anyLong())).thenReturn(getPoint());

        var result = service.getPoint(ID);

        assertNotNull(result);

        verify(pointRepository).getReferenceById(anyLong());
        verify(pointResponseMapper).from((Point) any());
        verifyNoMoreInteractions(pointRepository, pointResponseMapper);
        verifyNoInteractions(pointMapper);
    }

    @Test
    void getAllPointsTest() {
        points.add(new Point(1L));
        points.add(new Point(2L));
        pointResponses.add(new PointResponse());
        pointResponses.add(new PointResponse());

        when(pointRepository.findAll()).thenReturn(points);
        when(pointResponseMapper.from(points)).thenReturn(pointResponses);

        List<PointResponse> result = service.getAllPoints();

        assertEquals(pointResponses, result);
        assertNotNull(result);
        verify(pointRepository).findAll();
        verify(pointResponseMapper).from(points);

        verifyNoMoreInteractions(pointRepository, pointResponseMapper);
        verifyNoInteractions(pointMapper);
    }

    @Test
    void deletePointTest() {
        service.deletePoint(ID);
        verify(pointRepository).deleteById(ID);

        verifyNoMoreInteractions(pointRepository, pointResponseMapper);
        verifyNoInteractions(pointMapper);
    }

    @Test
    void addPointTest() {

        when(pointMapper.from(pointAddRequestAdd)).thenReturn(pointAdd);
        when(pointRepository.save(pointAdd)).thenReturn(pointAdd);
        Long id = service.addPoint(pointAddRequestAdd);
        assertEquals(pointAdd.getId(), id.longValue());
        verify(pointMapper).from(pointAddRequestAdd);
        verify(pointRepository).save(pointAdd);
        verifyNoMoreInteractions(pointRepository, pointResponseMapper);
    }

    private PointResponse getPointResponse() {
        return new PointResponse()
                .setId(ID);
    }

    private Point getPoint() {
        return new Point(ID);
    }
}
