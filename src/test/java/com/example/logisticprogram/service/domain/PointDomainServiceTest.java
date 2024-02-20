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

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
    private final Long ID = 0L;


    @Test
    void getPointTest() {

        when(pointResponseMapper.from(any(Point.class))).thenReturn(getPointResponse());
        when(pointRepository.getReferenceById(anyLong())).thenReturn(getPoint());

        var result = service.getPoint(ID);

        assertThat(result).isNotNull();

        verify(pointRepository).getReferenceById(anyLong());
        verify(pointResponseMapper).from(any(Point.class));
        verifyNoMoreInteractions(pointRepository, pointResponseMapper);
        verifyNoInteractions(pointMapper);
    }

    @Test
    void getAllPointsTest() {
        when(pointRepository.findAll()).thenReturn(Collections.singletonList(getPoint()));
        when(pointResponseMapper.from(anyList())).thenReturn(Collections.singletonList(getPointResponse()));

        List<PointResponse> result = service.getAllPoints();

        assertThat(result).isNotNull();

        verify(pointRepository).findAll();
        verify(pointResponseMapper).from(anyList());

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

        when(pointMapper.from(any(PointAddRequest.class))).thenReturn(getPoint());
        when(pointRepository.save(any())).thenReturn(getPoint());
        Long id = service.addPoint(pointAddRequestAdd());

        assertThat(id).isEqualTo(ID);

        verify(pointMapper).from(any(PointAddRequest.class));
        verify(pointRepository).save(any());
        verifyNoMoreInteractions(pointRepository, pointResponseMapper);
    }

    private PointResponse getPointResponse() {
        return new PointResponse()
                .setId(ID);
    }

    private PointAddRequest pointAddRequestAdd(){
        return  new PointAddRequest();
    }


    private Point getPoint() {
        return new Point(ID);
    }
}
