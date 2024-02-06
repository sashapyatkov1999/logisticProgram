package com.example.logisticprogram.mappers.application;

import com.example.logisticprogram.dto.response.application.ApplicationResponse;
import com.example.logisticprogram.dto.response.driver.DriverResponse;
import com.example.logisticprogram.dto.response.user.UserResponse;
import com.example.logisticprogram.entity.Application;
import com.example.logisticprogram.entity.Driver;
import com.example.logisticprogram.entity.User;
import com.example.logisticprogram.mapper.application.ApplicationResponseMapper;
import com.example.logisticprogram.mapper.driver.DriverResponseMapper;
import com.example.logisticprogram.mapper.user.UserResponseMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ApplicationResponseMapperTest {
    @Mock
    private DriverResponseMapper driverResponseMapper;

    @Mock
    private UserResponseMapper userResponseMapper;
    private final Long id = 1L;
    Long driverId = 2L;
    Long managerId = 3L;
    String name = "";
    String description = "";
    LocalDateTime created = LocalDateTime.now();
    LocalDateTime modified = LocalDateTime.now();

    @Test
     void ApplicationResponseTest() {
        when(driverResponseMapper.from(any(Driver.class))).thenReturn(new DriverResponse());
        when(userResponseMapper.from(any(User.class))).thenReturn(new UserResponse());

        ApplicationResponse result = mapper().from(source());

        assertEquals(response().getId(), result.getId());
        assertEquals(response().getDriver(), result.getDriver());
        assertEquals(response().getManager(), result.getManager());
        assertEquals(response().getName(), result.getName());
        assertEquals(response().getDescription(), result.getDescription());
        assertEquals(response().getCreated(), result.getCreated());
        assertEquals(response().getModified(), result.getModified());
    }
    ApplicationResponse response(){
    ApplicationResponse response = new ApplicationResponse();
        return response.setId(id)
                .setDriver(new DriverResponse())
                .setManager(new UserResponse())
                .setName(name)
                .setDescription(description)
                .setCreated(created)
                .setModified(modified);
    }
    Application source() {
        Application source = new Application();
        return source.setId(id)
                .setDriver(new Driver(driverId))
                .setManager(new User(managerId))
                .setName(name)
                .setDescription(description)
                .setCreated(created)
                .setModified(modified);
    }
    ApplicationResponseMapper mapper(){
       return new ApplicationResponseMapper(driverResponseMapper, userResponseMapper);
    }
}