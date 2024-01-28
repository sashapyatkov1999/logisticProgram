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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class ApplicationDomainServiceTest {

    @Mock
    private ApplicationRepository applicationRepository;
    @Mock
    private ApplicationResponseMapper applicationResponseMapper;
    @Mock
    private ApplicationMapper applicationMapper;
    @InjectMocks
    private ApplicationDomainService service;

    private final ApplicationAddRequest applicationAddRequestAdd = new ApplicationAddRequest();
    private final List<Application> applications = new ArrayList<>();
    private final Application application = new Application(1L);
    private final List<ApplicationResponse> applicationResponses = new ArrayList<>();
    private final Long ID = 0L;
    private final Long id = 1L;


    @Test
    void getApplicationTest() {

        when(applicationResponseMapper.from((Application) any())).thenReturn(getApplicationResponse());
        when(applicationRepository.getReferenceById(anyLong())).thenReturn(getApplication());

        var result = service.getApplication(ID);

        assertNotNull(result);

        verify(applicationRepository).getReferenceById(anyLong());
        verify(applicationResponseMapper).from((Application) any());
        verifyNoMoreInteractions(applicationRepository, applicationResponseMapper);
        verifyNoInteractions(applicationMapper);
    }

    @Test
    void getAllApplicationsTest() {
        applications.add(new Application(1L));
        applications.add(new Application(2L));
        applicationResponses.add(new ApplicationResponse());
        applicationResponses.add(new ApplicationResponse());

        when(applicationRepository.findAll()).thenReturn(applications);
        when(applicationResponseMapper.from(applications)).thenReturn(applicationResponses);

        List<ApplicationResponse> result = service.getAllApplications();

        assertEquals(applicationResponses, result);
        assertNotNull(result);
        verify(applicationRepository).findAll();
        verify(applicationResponseMapper).from(applications);

        verifyNoMoreInteractions(applicationRepository, applicationResponseMapper);
        verifyNoInteractions(applicationMapper);

    }

    @Test
    void deleteApplicationTest() {
        service.deleteApplication(id);
        verify(applicationRepository).deleteById(id);

        verifyNoMoreInteractions(applicationRepository, applicationResponseMapper);
        verifyNoInteractions(applicationMapper);
    }

    @Test
    void addApplicationTest() {
        when(applicationMapper.from(applicationAddRequestAdd)).thenReturn(application);
        when(applicationRepository.save(application)).thenReturn(application);
        Long id = service.addApplication(applicationAddRequestAdd);
        assertEquals(application.getId(), id.longValue());
        verify(applicationMapper).from(applicationAddRequestAdd);
        verify(applicationRepository).save(application);
        verifyNoMoreInteractions(applicationRepository, applicationResponseMapper);
    }

    private ApplicationResponse getApplicationResponse() {
        return new ApplicationResponse()
                .setId(ID);
    }

    private Application getApplication() {
        return new Application(ID);
    }
}


