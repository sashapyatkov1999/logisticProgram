package com.example.logisticprogram.service.domain;

import com.example.logisticprogram.dto.request.application.ApplicationAddRequest;
import com.example.logisticprogram.dto.response.application.ApplicationResponse;
import com.example.logisticprogram.entity.Application;
import com.example.logisticprogram.mapper.application.ApplicationMapper;
import com.example.logisticprogram.mapper.application.ApplicationResponseMapper;
import com.example.logisticprogram.repository.ApplicationRepository;
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
class ApplicationDomainServiceTest {

    @Mock
    private ApplicationRepository applicationRepository;
    @Mock
    private ApplicationResponseMapper applicationResponseMapper;
    @Mock
    private ApplicationMapper applicationMapper;
    @InjectMocks
    private ApplicationDomainService service;
    private final Long ID = 0L;

    @Test
    void getApplicationTest() {

        when(applicationResponseMapper.from(any(Application.class))).thenReturn(getApplicationResponse());
        when(applicationRepository.getReferenceById(anyLong())).thenReturn(getApplication());

        var result = service.getApplication(ID);

        assertThat(result).isNotNull();

        verify(applicationRepository).getReferenceById(anyLong());
        verify(applicationResponseMapper).from(any(Application.class));
        verifyNoMoreInteractions(applicationRepository, applicationResponseMapper);
        verifyNoInteractions(applicationMapper);
    }

    @Test
    void getAllApplicationsTest() {
        when(applicationRepository.findAll()).thenReturn(Collections.singletonList(getApplication()));
        when(applicationResponseMapper.from(anyList())).thenReturn(Collections.singletonList(getApplicationResponse()));

        List<ApplicationResponse> result = service.getAllApplications();

        assertThat(result).isNotNull();

        verify(applicationRepository).findAll();
        verify(applicationResponseMapper).from(anyList());
        verifyNoMoreInteractions(applicationRepository, applicationResponseMapper);
        verifyNoInteractions(applicationMapper);

    }

    @Test
    void deleteApplicationTest() {
        service.deleteApplication(ID);
        verify(applicationRepository).deleteById(ID);

        verifyNoMoreInteractions(applicationRepository, applicationResponseMapper);
        verifyNoInteractions(applicationMapper);
    }

    @Test
    void addApplicationTest() {
        when(applicationMapper.from(any(ApplicationAddRequest.class))).thenReturn(getApplication());
        when(applicationRepository.save(any())).thenReturn(getApplication());

        Long id = service.addApplication(applicationAddRequestAdd());

        assertThat(id).isEqualTo(ID);

        verify(applicationMapper).from(any(ApplicationAddRequest.class));
        verify(applicationRepository).save(any());
        verifyNoMoreInteractions(applicationRepository, applicationResponseMapper);
    }

    private ApplicationResponse getApplicationResponse() {
        return new ApplicationResponse()
                .setId(ID);
    }
    private ApplicationAddRequest applicationAddRequestAdd(){
        return new ApplicationAddRequest();
    }

    private Application getApplication() {
        return new Application(ID);
    }
}


