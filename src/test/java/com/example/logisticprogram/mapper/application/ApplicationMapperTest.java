package com.example.logisticprogram.mapper.application;

import com.example.logisticprogram.dto.request.application.ApplicationAddRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
 class ApplicationMapperTest {
    @InjectMocks
    private ApplicationMapper applicationMapper;

    private final Long MANAGER_ID = 1L;
    private final Long DRIVER_ID = 2L;
    private final String NAME = "";
    private final String DESCRIPTION = "";

    @Test
    void from() {

        var source = spy(applicationAddRequest());
        var result = applicationMapper.from(source);

        assertThat(result.getId()).isNull();
        assertThat(result.getCreated()).isNull();
        assertThat(result.getModified()).isNull();
        assertThat(result.getManager().getId()).isEqualTo(MANAGER_ID);
        assertThat(result.getDriver().getId()).isEqualTo(DRIVER_ID);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);

        verify(source).getName();
        verify(source).getDescription();
        verify(source).getDriverId();
        verify(source).getManagerId();
        verifyNoMoreInteractions(source);
    }
    @Test
    void fromList(){
        var source = spy(applicationAddRequest());
        var resultList = applicationMapper.from(List.of(source,source,source));

        assertThat(resultList).isNotEmpty();

        var result = resultList.get(0);

        assertThat(result.getId()).isNull();
        assertThat(result.getCreated()).isNull();
        assertThat(result.getModified()).isNull();
        assertThat(result.getManager().getId()).isEqualTo(MANAGER_ID);
        assertThat(result.getDriver().getId()).isEqualTo(DRIVER_ID);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);

        verify(source,times(3)).getName();
        verify(source,times(3)).getDescription();
        verify(source,times(3)).getDriverId();
        verify(source,times(3)).getManagerId();
        verifyNoMoreInteractions(source);

    }


    private ApplicationAddRequest applicationAddRequest() {
        return new ApplicationAddRequest()
                .setName(NAME)
                .setDriverId(DRIVER_ID)
                .setManagerId(MANAGER_ID)
                .setDescription(DESCRIPTION);
    }
}
