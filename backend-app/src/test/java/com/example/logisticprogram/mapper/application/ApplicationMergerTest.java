package com.example.logisticprogram.mapper.application;

import com.example.logisticprogram.dto.request.application.ApplicationAddRequest;
import com.example.logisticprogram.entity.Application;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ApplicationMergerTest {
    @InjectMocks
    private ApplicationMerger merger;


    private static final Long ID = 0L;
    private static final Long MANAGER_ID = 1L;
    private static final Long DRIVER_ID = 2L;
    private static final String NAME = "";
    private static final String DESCRIPTION = "";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now();

    @Test
    void merge() {

        var source = spy(getApplicationAddRequest());
        var target = spy(target());
        var result = merger.merge(target,source);

        verify(source).getName();
        verify(source).getDescription();
        verify(source).getManagerId();
        verify(source).getDriverId();

        verify(target).setManager(any());
        verify(target).setDriver(any());
        verify(target).setName(any());
        verify(target).setDescription(any());

        assertThat(result.getId()).as("Id не совпадают").isEqualTo(ID);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(result.getDriver().getId()).isEqualTo(DRIVER_ID);
        assertThat(result.getManager().getId()).isEqualTo(MANAGER_ID);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);

    }

    private ApplicationAddRequest getApplicationAddRequest(){
        return new ApplicationAddRequest()
                .setManagerId(MANAGER_ID)
                .setDriverId(DRIVER_ID)
                .setName(NAME)
                .setDescription(DESCRIPTION);
    }


    private Application target(){
        return new Application()
                .setId(ID)
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }
}
