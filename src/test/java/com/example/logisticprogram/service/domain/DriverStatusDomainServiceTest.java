package com.example.logisticprogram.service.domain;

import com.example.logisticprogram.dto.request.driverstatus.DriverStatusAddRequest;
import com.example.logisticprogram.dto.response.driverstatus.DriverStatusResponse;
import com.example.logisticprogram.entity.DriverStatus;
import com.example.logisticprogram.mapper.driverstatus.DriverStatusMapper;
import com.example.logisticprogram.mapper.driverstatus.DriverStatusResponseMapper;
import com.example.logisticprogram.repository.DriverStatusRepository;
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
public class DriverStatusDomainServiceTest {

    @Mock
    private DriverStatusRepository driverStatusRepository;
    @Mock
    private DriverStatusResponseMapper driverStatusResponseMapper;
    @Mock
    private DriverStatusMapper driverStatusMapper;
    @InjectMocks
    private DriverStatusDomainService service;

    private final List<DriverStatus> driverStatuses = new ArrayList<>();
    private final List<DriverStatusResponse> driverStatusResponses = new ArrayList<>();
    private final Long ID = 0L;
    private final Long id = 1L;


    @Test
    void getDriverStatusByIdTest() {

        when(driverStatusResponseMapper.from((DriverStatus) any())).thenReturn(getDriverStatusResponse());
        when(driverStatusRepository.getReferenceById(anyLong())).thenReturn(getDriverStatus());

        var result = service.getDriverStatusById(ID);

        assertNotNull(result);

        verify(driverStatusRepository).getReferenceById(anyLong());
        verify(driverStatusResponseMapper).from((DriverStatus) any());
        verifyNoMoreInteractions(driverStatusRepository, driverStatusResponseMapper);
        verifyNoInteractions(driverStatusMapper);
    }

    @Test
    void getDriverStatusesTest() {
        driverStatuses.add(new DriverStatus(1L));
        driverStatuses.add(new DriverStatus(2L));
        driverStatusResponses.add(new DriverStatusResponse());
        driverStatusResponses.add(new DriverStatusResponse());

        when(driverStatusRepository.findAll()).thenReturn(driverStatuses);
        when(driverStatusResponseMapper.from(driverStatuses)).thenReturn(driverStatusResponses);

        List<DriverStatusResponse> result = service.getAllDriverStatus();

        assertEquals(driverStatusResponses, result);
        assertNotNull(result);
        verify(driverStatusRepository).findAll();
        verify(driverStatusResponseMapper).from(driverStatuses);

        verifyNoMoreInteractions(driverStatusRepository, driverStatusResponseMapper);
        verifyNoInteractions(driverStatusMapper);
    }



    private DriverStatusResponse getDriverStatusResponse() {
        return new DriverStatusResponse()
                .setId(ID);
    }

    private DriverStatus getDriverStatus() {
        return new DriverStatus(ID);
    }
}

