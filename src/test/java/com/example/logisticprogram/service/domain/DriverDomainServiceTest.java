package com.example.logisticprogram.service.domain;

import com.example.logisticprogram.dto.request.driver.DriverAddRequest;
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
import java.util.List;

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

    private final DriverAddRequest driverAddRequestAdd = new DriverAddRequest();
    private final List<Driver> drivers = new ArrayList<>();
    private final Driver driver = new Driver(1L);
    private final List<DriverResponse> driverResponses = new ArrayList<>();
    private final Long ID = 0L;



    @Test
    void getDriverTest() {

        when(driverResponseMapper.from((Driver) any())).thenReturn(getDriverResponse());
        when(driverRepository.getReferenceById(anyLong())).thenReturn(getDriver());

        var result = service.getDriverById(ID);

        assertNotNull(result);

        verify(driverRepository).getReferenceById(anyLong());
        verify(driverResponseMapper).from((Driver) any());
        verifyNoMoreInteractions(driverRepository, driverResponseMapper);
        verifyNoInteractions(driverMapper);
    }

    @Test
    void getAllDriversTest() {
        drivers.add(new Driver(1L));
        drivers.add(new Driver(2L));
        driverResponses.add(new DriverResponse());
        driverResponses.add(new DriverResponse());

        when(driverRepository.findAll()).thenReturn(drivers);
        when(driverResponseMapper.from(drivers)).thenReturn(driverResponses);

        List<DriverResponse> result = service.getAllDrivers();

        assertEquals(driverResponses, result);
        assertNotNull(result);
        verify(driverRepository).findAll();
        verify(driverResponseMapper).from(drivers);

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
        when(driverMapper.from(driverAddRequestAdd)).thenReturn(driver);
        when(driverRepository.save(driver)).thenReturn(driver);
        Long id = service.addDriver(driverAddRequestAdd);
        assertEquals(driver.getId(),id.longValue());
        verify(driverMapper).from(driverAddRequestAdd);
        verify(driverRepository).save(driver);
        verifyNoMoreInteractions(driverRepository, driverResponseMapper);
    }
    @Test
    void editDriverTest(){
        driverAddRequestAdd.setId(1L);
        driver.setId(1L);

        when(driverRepository.getReferenceById(driverAddRequestAdd.getId())).thenReturn(driver);
        when(driverMerger.merge(driver, driverAddRequestAdd)).thenReturn(driver);
        when(driverRepository.saveAndFlush(driver)).thenReturn(driver);

        service.editDrivers(driverAddRequestAdd);

        verify(driverRepository).getReferenceById(driverAddRequestAdd.getId());
        verify(driverMerger).merge(driver, driverAddRequestAdd);


    }

    private DriverResponse getDriverResponse(){
        return  new DriverResponse()
                .setId(ID);
    }

    private Driver getDriver(){
        return new Driver(ID);
    }

}

