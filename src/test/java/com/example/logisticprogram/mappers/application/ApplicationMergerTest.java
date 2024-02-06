package com.example.logisticprogram.mappers.application;

import com.example.logisticprogram.dto.request.application.ApplicationAddRequest;
import com.example.logisticprogram.entity.Application;
import com.example.logisticprogram.mapper.application.ApplicationMapper;
import com.example.logisticprogram.mapper.application.ApplicationMerger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ApplicationMergerTest {
    @Mock
    private ApplicationAddRequest applicationAddRequest;

    Long managerId = 1L;
    Long driverId = 2L;
    String name = "";

    @Test
    void ApplicationMergerTest() {

        String description = "";

       //spy

        Application result = merger().merge(target(),applicationAddRequest);

        assertEquals(managerId, result.getManager().getId());
        assertEquals(driverId, result.getDriver().getId());
        assertEquals(name, result.getName());
        assertEquals(description, result.getDescription());
    }

    ApplicationMerger merger(){
        return new ApplicationMerger();
    }
    Application target(){
        return new Application();
    }
}
