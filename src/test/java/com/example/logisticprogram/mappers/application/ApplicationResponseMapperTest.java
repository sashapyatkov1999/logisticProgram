package com.example.logisticprogram.mappers.application;

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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ApplicationResponseMapperTest {
    @Mock
    private DriverResponseMapper driverResponseMapper;
    @Mock
    private UserResponseMapper userResponseMapper;
    @InjectMocks
    private ApplicationResponseMapper mapper;
    private final Long ID = 0L;
    private final Long MANAGER_ID = 1L;
    private final Long DRIVER_ID = 2L;
    private final String NAME = "";
    private final String DESCRIPTION = "";
    private final LocalDateTime CREATED = LocalDateTime.now();
    private final LocalDateTime MODIFIED = LocalDateTime.now();


    @Test
    void ApplicationResponseTest() {
        when(driverResponseMapper.from(any(Driver.class))).thenReturn(new DriverResponse().setId(DRIVER_ID));
        when(userResponseMapper.from(any(User.class))).thenReturn(new UserResponse().setId(MANAGER_ID));


        var source = spy(source());
        var result = mapper.from(source);

        assertThat(result.getId()).as("Id не совпадают").isEqualTo(ID);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(result.getDriver().getId()).isEqualTo(DRIVER_ID);
        assertThat(result.getManager().getId()).isEqualTo(MANAGER_ID);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);

        verify(source).getDriver();
        verify(source).getId();
        verify(source).getManager();
        verify(source).getName();
        verify(source).getDescription();
        verify(source).getCreated();
        verify(source).getModified();
        verify(driverResponseMapper).from(any(Driver.class));
        verify(userResponseMapper).from(any(User.class));

        verifyNoMoreInteractions(source);
    }


    @Test
    void fromList() {

        when(driverResponseMapper.from(any(Driver.class))).thenReturn(new DriverResponse().setId(DRIVER_ID));
        when(userResponseMapper.from(any(User.class))).thenReturn(new UserResponse().setId(MANAGER_ID));

        var source = spy(source());
        var resultList = mapper.from(List.of(source, source, source));

        assertThat(resultList).isNotEmpty();

        var result = resultList.get(0);

        assertThat(result.getId()).as("Id не совпадают").isEqualTo(ID);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(result.getDriver().getId()).isEqualTo(DRIVER_ID);
        assertThat(result.getManager().getId()).isEqualTo(MANAGER_ID);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);

        verify(source, times(3)).getDriver();
        verify(source, times(3)).getId();
        verify(source, times(3)).getManager();
        verify(source, times(3)).getName();
        verify(source, times(3)).getDescription();
        verify(source, times(3)).getCreated();
        verify(source, times(3)).getModified();
        verify(driverResponseMapper, times(3)).from(any(Driver.class));
        verify(userResponseMapper, times(3)).from(any(User.class));

        verifyNoMoreInteractions(source);
    }


    private Application source() {
        Application source = new Application();
        return source.setId(ID)
                .setDriver(new Driver(DRIVER_ID))
                .setManager(new User(MANAGER_ID))
                .setName(NAME)
                .setDescription(DESCRIPTION)
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }
}