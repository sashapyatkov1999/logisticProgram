package com.example.logisticprogram.mapper.driverstatus;

import com.example.logisticprogram.entity.DriverStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DriverStatusResponseMapperTest {
    @InjectMocks
    private DriverStatusResponseMapper mapper;

    private static final Long ID = 0L;
    private static final String NAME = " ";
    private static final String DESCRIPTION = " ";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now();

    @Test
    void from(){
        var source = spy(source());
        var result = mapper.from(source);

        assertThat(result.getId()).isEqualTo(ID);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);

        verify(source).getId();
        verify(source).getCreated();
        verify(source).getModified();
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

        assertThat(result.getId()).isEqualTo(ID);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);

        verify(source,times(3)).getId();
        verify(source,times(3)).getCreated();
        verify(source,times(3)).getModified();
        verify(source,times(3)).getName();
        verify(source,times(3)).getDescription();
        verifyNoMoreInteractions(source);
    }

    private DriverStatus source(){
        return new DriverStatus()
                .setId(ID)
                .setName(NAME)
                .setDescription(DESCRIPTION)
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }
}
