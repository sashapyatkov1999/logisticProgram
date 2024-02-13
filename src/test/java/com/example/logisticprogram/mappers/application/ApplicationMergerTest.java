package com.example.logisticprogram.mappers.application;

import com.example.logisticprogram.dto.request.application.ApplicationAddRequest;
import com.example.logisticprogram.entity.Application;
import com.example.logisticprogram.mapper.application.ApplicationMapper;
import com.example.logisticprogram.mapper.application.ApplicationMerger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ApplicationMergerTest {
    @InjectMocks
    private ApplicationMerger merger;


    private final Long managerId = 1L;
    private final Long driverId = 2L;
    private final String name = "";
    private final String description = "";
    private final LocalDateTime CREATED = LocalDateTime.now();
    private final LocalDateTime MODIFIED = LocalDateTime.now();

    @Test
    void merge() {

        var source = spy(getApplicationAddRequest());
        var target = spy(target());
        var result = merger.merge(target,source);

        assertNull(result.getId());
        assertEquals(CREATED,result.getCreated());
        assertEquals(MODIFIED,result.getModified());
        assertEquals(managerId, result.getManager().getId());
        assertEquals(driverId, result.getDriver().getId());
        assertEquals(name, result.getName());
        assertEquals(description, result.getDescription());

    }

    private ApplicationAddRequest getApplicationAddRequest(){
        return new ApplicationAddRequest()
                .setManagerId(managerId)
                .setDriverId(driverId)
                .setName(name)
                .setDescription(description);
    }


    Application target(){
        return new Application()
                .setId(1L)
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }
}
