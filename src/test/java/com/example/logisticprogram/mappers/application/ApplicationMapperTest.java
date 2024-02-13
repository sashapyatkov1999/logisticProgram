package com.example.logisticprogram.mappers.application;

import com.example.logisticprogram.dto.request.application.ApplicationAddRequest;
import com.example.logisticprogram.entity.Application;
import com.example.logisticprogram.mapper.application.ApplicationMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
 class ApplicationMapperTest {
    @InjectMocks
    private ApplicationMapper applicationMapper;

    private final Long managerId = 1L;
    private final Long driverId = 2L;
    private final String name = "";
    private final String description = "";

    @Test
    void from() {



        var source = spy(applicationAddRequest());
        var result = applicationMapper.from(source);

        assertNull(result.getId());
        assertNull(result.getCreated());
        assertNull(result.getModified());
        assertEquals(managerId, result.getManager().getId());
        assertEquals(driverId, result.getDriver().getId());
        assertEquals(name, result.getName());
        assertEquals(description, result.getDescription());

        verify(source).getName();
        verify(source).getDescription();
        verify(source).getDriverId();
        verify(source).getManagerId();
        verifyNoMoreInteractions(source);
    }


    private ApplicationAddRequest applicationAddRequest() {
        return new ApplicationAddRequest()
                .setName(name)
                .setDriverId(driverId)
                .setManagerId(managerId)
                .setDescription(description);
    }
}
