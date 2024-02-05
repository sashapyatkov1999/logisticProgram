package com.example.logisticprogram.mappers.application;

import com.example.logisticprogram.dto.request.application.ApplicationAddRequest;
import com.example.logisticprogram.entity.Application;
import com.example.logisticprogram.mapper.application.ApplicationMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
 class ApplicationMapperTest {
    @Mock
    private ApplicationAddRequest applicationAddRequest;

    Long managerId = 1L;
    Long driverId = 2L;
    String name = "";

    @Test
    void ApplicationTest() {

        String description = "";

        when(applicationAddRequest.getManagerId()).thenReturn(managerId);
        when(applicationAddRequest.getDriverId()).thenReturn(driverId);
        when(applicationAddRequest.getName()).thenReturn(name);
        when(applicationAddRequest.getDescription()).thenReturn(description);


        Application result = mapper().from(applicationAddRequest);

        assertEquals(managerId, result.getManager().getId());
        assertEquals(driverId, result.getDriver().getId());
        assertEquals(name, result.getName());
        assertEquals(description, result.getDescription());
    }

    public ApplicationMapper mapper(){
        return new ApplicationMapper();
    }
}
