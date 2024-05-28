package com.example.logisticprogram.mapper.car;

import com.example.logisticprogram.entity.Car;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarResponseMapperTest {
    @InjectMocks
    private CarResponseMapper mapper;
    private static final Long ID = 0L;
    private static final String CAR_NUMBER = "";
    private static final String TRAILER_NUMBER = "";
    private final LocalDateTime CREATED = LocalDateTime.now();
    private final LocalDateTime MODIFIED = LocalDateTime.now();

    @Test
    void from(){

        var source = spy(source());
        var result = mapper.from(source);

        assertThat(result.getId()).as("Id не совпадают").isEqualTo(ID);
        assertThat(result.getCarNumber()).isEqualTo(CAR_NUMBER);
        assertThat(result.getTrailerNumber()).isEqualTo(TRAILER_NUMBER);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);

        verify(source).getId();
        verify(source).getCarNumber();
        verify(source).getTrailerNumber();
        verify(source).getCreated();
        verify(source).getModified();
        verifyNoMoreInteractions(source);

    }
    @Test
    void fromList(){
        var source = spy(source());
        var resultList = mapper.from(List.of(source, source, source));

        assertThat(resultList).isNotEmpty();

        var result = resultList.get(0);

        assertThat(result.getId()).as("Id не совпадают").isEqualTo(ID);
        assertThat(result.getCarNumber()).isEqualTo(CAR_NUMBER);
        assertThat(result.getTrailerNumber()).isEqualTo(TRAILER_NUMBER);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);

        verify(source,times(3)).getId();
        verify(source,times(3)).getCarNumber();
        verify(source,times(3)).getTrailerNumber();
        verify(source,times(3)).getCreated();
        verify(source,times(3)).getModified();
        verifyNoMoreInteractions(source);
    }

    private Car source(){
        return new Car()
                .setId(ID)
                .setCarNumber(CAR_NUMBER)
                .setTrailerNumber(TRAILER_NUMBER)
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }
}
