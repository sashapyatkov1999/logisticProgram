package com.example.logisticprogram.mapper.driver;

import com.example.logisticprogram.dto.request.driver.DriverAddRequest;
import com.example.logisticprogram.entity.DriverStatusEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DriverMapperTest {
    @InjectMocks
    private DriverMapper mapper;

    private static final Long USER_ID = 1L;
    private static final Long DRIVER_STATUS_ID = 2L;
    private static final Long CAR_ID = 3L;
    private static final String PASSPORT_NUMBER = "ABC123";
    private static final String PASSPORT_DATE = "2010-10-11";
    private static final String PASSPORT_REGISTRATION = "ABC123";
    private static final String DRIVER_LICENSE = "ABC123";


    @Test
    void from(){
        var source = spy(source());
        var result = mapper.from(source);

        assertThat(result.getId()).isNull();
        assertThat(result.getUser().getId()).isEqualTo(USER_ID);
        assertThat(result.getDriverStatus().getId()).isEqualTo(DriverStatusEnum.WAIT_DOCS.getId());
        assertThat(result.getCar().getId()).isEqualTo(CAR_ID);
        assertThat(result.getPassportNumber()).isEqualTo(PASSPORT_NUMBER);
        assertThat(result.getPassportDate()).isEqualTo(PASSPORT_DATE);
        assertThat(result.getPassportRegistration()).isEqualTo(PASSPORT_REGISTRATION);
        assertThat(result.getDriverLicense()).isEqualTo(DRIVER_LICENSE);

        verify(source).getUserId();
        verify(source).getCarId();
        verify(source).getPassportNumber();
        verify(source).getPassportDate();
        verify(source).getRegistration();
        verify(source).getDriverLicense();
        verifyNoMoreInteractions(source);

    }
    @Test
    void fromList(){
        var source = spy(source());
        var resultList = mapper.from(List.of(source, source, source));

        assertThat(resultList).isNotEmpty();

        var result = resultList.get(0);

        assertThat(result.getId()).isNull();
        assertThat(result.getUser().getId()).isEqualTo(USER_ID);
        assertThat(result.getDriverStatus().getId()).isEqualTo(DriverStatusEnum.WAIT_DOCS.getId());
        assertThat(result.getCar().getId()).isEqualTo(CAR_ID);
        assertThat(result.getPassportNumber()).isEqualTo(PASSPORT_NUMBER);
        assertThat(result.getPassportDate()).isEqualTo(PASSPORT_DATE);
        assertThat(result.getPassportRegistration()).isEqualTo(PASSPORT_REGISTRATION);
        assertThat(result.getDriverLicense()).isEqualTo(DRIVER_LICENSE);

        verify(source,times(3)).getUserId();
        verify(source,times(3)).getCarId();
        verify(source,times(3)).getPassportNumber();
        verify(source,times(3)).getPassportDate();
        verify(source,times(3)).getRegistration();
        verify(source,times(3)).getDriverLicense();
        verifyNoMoreInteractions(source);
    }

    private DriverAddRequest source(){
        return new DriverAddRequest()
                .setUserId(USER_ID)
                .setDriverStatusId(DRIVER_STATUS_ID)
                .setCarId(CAR_ID)
                .setPassportNumber(PASSPORT_NUMBER)
                .setPassportDate(PASSPORT_DATE)
                .setRegistration(PASSPORT_REGISTRATION)
                .setDriverLicense(DRIVER_LICENSE);
    }
}
