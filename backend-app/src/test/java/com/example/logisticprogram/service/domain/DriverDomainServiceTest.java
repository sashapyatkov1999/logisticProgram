package com.example.logisticprogram.service.domain;

import com.example.logisticprogram.dto.request.driver.DriverAddRequest;
import com.example.logisticprogram.dto.request.user.UserAddRequest;
import com.example.logisticprogram.dto.response.driver.DriverResponse;
import com.example.logisticprogram.entity.Driver;
import com.example.logisticprogram.mapper.driver.DriverMapper;
import com.example.logisticprogram.mapper.driver.DriverMerger;
import com.example.logisticprogram.mapper.driver.DriverResponseMapper;
import com.example.logisticprogram.repository.DriverRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class DriverDomainServiceTest {
    @Mock
    private DriverRepository driverRepository;
    @Mock
    private DriverMerger driverMerger;
    @Mock
    private DriverResponseMapper driverResponseMapper;
    @Mock
    private DriverMapper driverMapper;
    @InjectMocks
    private DriverDomainService service;

    private final Long ID = 0L;



    @Test
    void getDriverTest() {

        when(driverResponseMapper.from(any(Driver.class))).thenReturn(getDriverResponse());
        when(driverRepository.getReferenceById(anyLong())).thenReturn(getDriver());

        var result = service.getDriverById(ID);

        assertThat(result).isNotNull();

        verify(driverRepository).getReferenceById(anyLong());
        verify(driverResponseMapper).from((Driver) any());
        verifyNoMoreInteractions(driverRepository, driverResponseMapper);
        verifyNoInteractions(driverMapper);
    }

    @Test
    void getAllDriversTest() {

        when(driverRepository.findAll()).thenReturn(Collections.singletonList(getDriver()));
        when(driverResponseMapper.from(any(List.class))).thenReturn(Collections.singletonList(getDriverResponse()));

        List<DriverResponse> result = service.getAllDrivers();

        assertThat(result).hasSize(1);

        verify(driverRepository).findAll();
        verify(driverResponseMapper).from(any(List.class));

        verifyNoMoreInteractions(driverRepository, driverResponseMapper);
        verifyNoInteractions(driverMapper);
    }

    @Test
    void deleteDriverTest() {
        service.deleteDriver(ID);
        verify(driverRepository).deleteById(ID);

        verifyNoMoreInteractions(driverRepository, driverResponseMapper);
        verifyNoInteractions(driverMapper);
    }

    @Test
    void addDriverTest() {
        when(driverMapper.from(any(DriverAddRequest.class))).thenReturn(getDriver());
        when(driverRepository.save(any())).thenReturn(getDriver());

        Long id = service.addDriver(driverAddRequestAdd());

        assertThat(id).isEqualTo(ID);

        verify(driverMapper).from(any(DriverAddRequest.class));
        verify(driverRepository).save(any());
        verifyNoMoreInteractions(driverRepository, driverResponseMapper);
    }
    @Test
    void editDriverTest(){

        when(driverRepository.getReferenceById(anyLong())).thenReturn(getDriver());
        when(driverMerger.merge(any(),any())).thenReturn(getDriver());
        when(driverRepository.saveAndFlush(any())).thenReturn(getDriver());

        Long result = service.editDrivers(driverAddRequestAdd());
        assertThat(result).isEqualTo(ID);

        verify(driverRepository).getReferenceById(anyLong());
        verify(driverRepository).saveAndFlush(any());
        verify(driverMerger).merge(any(),any());
        verifyNoMoreInteractions(driverRepository, driverMerger);
    }

    private DriverResponse getDriverResponse(){
        return  new DriverResponse()
                .setId(ID);
    }

    private Driver getDriver(){
        return new Driver(ID);
    }
    private DriverAddRequest driverAddRequestAdd(){
        return  new DriverAddRequest().setId(ID);
    }

}

