package com.example.logisticprogram.mapper.driver;

import com.example.logisticprogram.dto.request.driver.DriverAddRequest;
import com.example.logisticprogram.entity.Driver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DriverMergerTest {
    @InjectMocks
    private DriverMerger merger;

    private static final Long ID = 0L;

    private static final Long DRIVER_STATUS_ID = 2L;
    private static final Long CAR_ID = 3L;
    private static final String PASSPORT_NUMBER = "ABC123";
    private static final String PASSPORT_DATE = "2010-10-11";
    private static final String PASSPORT_REGISTRATION = "ABC123";
    private static final String DRIVER_LICENSE = "ABC123";
    private final LocalDateTime CREATED = LocalDateTime.now();
    private final LocalDateTime MODIFIED = LocalDateTime.now();

    @Test
    void merge() {

        var source = spy(source());
        var target = spy(target());
        var result = merger.merge(target,source);

        verify(source).getPassportNumber();
        verify(source).getPassportDate();
        verify(source).getRegistration();
        verify(source).getDriverStatusId();
        verify(source).getCarId();
        verify(source).getDriverLicense();

        verify(target).setPassportNumber(any());
        verify(target).setPassportDate(any());
        verify(target).setPassportRegistration(any());
        verify(target).setDriverStatus(any());
        verify(target).setCar(any());
        verify(target).setDriverLicense(any());

        verifyNoMoreInteractions(source, target);

        assertThat(result.getId()).isEqualTo(ID);
        assertThat(result.getPassportNumber()).isEqualTo(PASSPORT_NUMBER);
        assertThat(result.getPassportDate()).isEqualTo(PASSPORT_DATE);
        assertThat(result.getPassportRegistration()).isEqualTo(PASSPORT_REGISTRATION);
        assertThat(result.getDriverStatus().getId()).isEqualTo(DRIVER_STATUS_ID);
        assertThat(result.getCar().getId()).isEqualTo(CAR_ID);
        assertThat(result.getDriverLicense()).isEqualTo(DRIVER_LICENSE);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);


    }

    private DriverAddRequest source(){
        return new DriverAddRequest()
                .setPassportNumber(PASSPORT_NUMBER)
                .setPassportDate(PASSPORT_DATE)
                .setRegistration(PASSPORT_REGISTRATION)
                .setDriverStatusId(DRIVER_STATUS_ID)
                .setCarId(CAR_ID)
                .setDriverLicense(DRIVER_LICENSE);
    }

    private Driver target(){
        return new Driver()
                .setId(ID)
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }
}
