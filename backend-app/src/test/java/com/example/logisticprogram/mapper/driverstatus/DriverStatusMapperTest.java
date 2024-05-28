package com.example.logisticprogram.mapper.driverstatus;

import com.example.logisticprogram.dto.request.driverstatus.DriverStatusAddRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DriverStatusMapperTest {
    @InjectMocks
    private DriverStatusMapper mapper;

    private static final String NAME = " ";
    private static final String DESCRIPTION = " ";

    @Test
    void from(){

        var source = spy(source());
        var result = mapper.from(source);

        assertThat(result.getId()).isNull();
        assertThat(result.getCreated()).isNull();
        assertThat(result.getModified()).isNull();
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);

        verify(source).getName();
        verify(source).getDescription();
        verifyNoMoreInteractions(source);
    }

    @Test
    void fromList(){
        var source = spy(source());
        var resultList = mapper.from(List.of(source, source, source));

        assertThat(resultList).isNotEmpty();

        var result = resultList.get(0);

        assertThat(result.getId()).isNull();
        assertThat(result.getCreated()).isNull();
        assertThat(result.getModified()).isNull();
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);

        verify(source,times(3)).getName();
        verify(source,times(3)).getDescription();
        verifyNoMoreInteractions(source);
    }

    private DriverStatusAddRequest source(){
        return new DriverStatusAddRequest()
                .setName(NAME)
                .setDescription(DESCRIPTION);
    }
}
