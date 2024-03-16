package com.example.logisticprogram.mapper.driver;

import com.example.logisticprogram.dto.response.car.CarResponse;
import com.example.logisticprogram.dto.response.user.UserResponse;
import com.example.logisticprogram.entity.Car;
import com.example.logisticprogram.entity.Driver;
import com.example.logisticprogram.entity.DriverStatus;
import com.example.logisticprogram.entity.User;
import com.example.logisticprogram.mapper.car.CarResponseMapper;
import com.example.logisticprogram.mapper.user.UserResponseMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DriverResponseMapperTest {

    @InjectMocks
    private DriverResponseMapper mapper;

    @Mock
    private UserResponseMapper userResponseMapper;
    @Mock
    private CarResponseMapper carResponseMapper;

    private static final Long ID = 0L;
    private static final Long USER_ID = 1L;
    private static final String DRIVER_STATUS = "2L";
    private static final Long CAR_ID = 3L;
    private static final String PASSPORT_NUMBER = "ABC123";
    private static final String PASSPORT_DATE = "2010-10-11";
    private static final String PASSPORT_REGISTRATION = "ABC123";
    private static final String DRIVER_LICENSE = "ABC123";
    private final LocalDateTime CREATED = LocalDateTime.now();
    private final LocalDateTime MODIFIED = LocalDateTime.now();

    @Test
    void from(){
        when(carResponseMapper.from(any(Car.class))).thenReturn(new CarResponse().setId(CAR_ID));
        when(userResponseMapper.from(any(User.class))).thenReturn(new UserResponse().setId(USER_ID));

        var source = spy(source());
        var result = mapper.from(source);

        assertThat(result.getId()).as("Id не совпадают").isEqualTo(ID);
        assertThat(result.getUser().getId()).isEqualTo(USER_ID);
        assertThat(result.getDriverStatus()).isEqualTo(DRIVER_STATUS);
        assertThat(result.getCar().getId()).isEqualTo(CAR_ID);
        assertThat(result.getPassportNumber()).isEqualTo(PASSPORT_NUMBER);
        assertThat(result.getPassportDate()).isEqualTo(PASSPORT_DATE);
        assertThat(result.getRegistration()).isEqualTo(PASSPORT_REGISTRATION);
        assertThat(result.getDriverLicense()).isEqualTo(DRIVER_LICENSE);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);

        verify(source).getId();
        verify(source).getUser();
        verify(source).getDriverStatus();
        verify(source).getCar();
        verify(source).getPassportNumber();
        verify(source).getPassportDate();
        verify(source).getPassportRegistration();
        verify(source).getDriverLicense();
        verify(source).getCreated();
        verify(source).getModified();
        verify(carResponseMapper).from(any(Car.class));
        verify(userResponseMapper).from(any(User.class));

        verifyNoMoreInteractions(source);

    }

    @Test
    void fromList(){
        when(carResponseMapper.from(any(Car.class))).thenReturn(new CarResponse().setId(CAR_ID));
        when(userResponseMapper.from(any(User.class))).thenReturn(new UserResponse().setId(USER_ID));

        var source = spy(source());
        var resultList = mapper.from(List.of(source, source, source));

        assertThat(resultList).isNotEmpty();

        var result = resultList.get(0);

        assertThat(result.getId()).as("Id не совпадают").isEqualTo(ID);
        assertThat(result.getUser().getId()).isEqualTo(USER_ID);
        assertThat(result.getDriverStatus()).isEqualTo(DRIVER_STATUS);
        assertThat(result.getCar().getId()).isEqualTo(CAR_ID);
        assertThat(result.getPassportNumber()).isEqualTo(PASSPORT_NUMBER);
        assertThat(result.getPassportDate()).isEqualTo(PASSPORT_DATE);
        assertThat(result.getRegistration()).isEqualTo(PASSPORT_REGISTRATION);
        assertThat(result.getDriverLicense()).isEqualTo(DRIVER_LICENSE);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);

        verify(source,times(3)).getId();
        verify(source,times(3)).getUser();
        verify(source,times(3)).getDriverStatus();
        verify(source,times(3)).getCar();
        verify(source,times(3)).getPassportNumber();
        verify(source,times(3)).getPassportDate();
        verify(source,times(3)).getPassportRegistration();
        verify(source,times(3)).getDriverLicense();
        verify(source,times(3)).getCreated();
        verify(source,times(3)).getModified();
        verify(carResponseMapper,times(3)).from(any(Car.class));
        verify(userResponseMapper,times(3)).from(any(User.class));

        verifyNoMoreInteractions(source);
    }

    private Driver source(){
        return new Driver()
                .setId(ID)
                .setUser(new User(USER_ID))
                .setDriverStatus(new DriverStatus().setName(DRIVER_STATUS))
                .setCar(new Car(CAR_ID))
                .setPassportNumber(PASSPORT_NUMBER)
                .setPassportDate(LocalDate.parse(PASSPORT_DATE))
                .setPassportRegistration(PASSPORT_REGISTRATION)
                .setDriverLicense(DRIVER_LICENSE)
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }
}
