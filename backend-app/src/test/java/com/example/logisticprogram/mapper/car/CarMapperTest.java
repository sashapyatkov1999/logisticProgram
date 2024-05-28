package com.example.logisticprogram.mapper.car;

import com.example.logisticprogram.dto.request.car.CarAddRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarMapperTest {
    @InjectMocks
    private CarMapper mapper;


    private static final String CAR_NUMBER = "";
    private static final String TRAILER_NUMBER = "";


    @Test
    void from(){
        var source = spy(source());
        var result = mapper.from(source);

        assertThat(result.getId()).isNull();
        assertThat(result.getCreated()).isNull();
        assertThat(result.getModified()).isNull();
        assertThat(result.getCarNumber()).isEqualTo(CAR_NUMBER);
        assertThat(result.getTrailerNumber()).isEqualTo(TRAILER_NUMBER);

        verify(source).getCarNumber();
        verify(source).getTrailerNumber();
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
        assertThat(result.getCarNumber()).isEqualTo(CAR_NUMBER);
        assertThat(result.getTrailerNumber()).isEqualTo(TRAILER_NUMBER);

        verify(source,times(3)).getCarNumber();
        verify(source,times(3)).getTrailerNumber();
        verifyNoMoreInteractions(source);
    }

    private CarAddRequest source(){
        return new CarAddRequest()
                .setCarNumber(CAR_NUMBER)
                .setTrailerNumber(TRAILER_NUMBER);
    }
}
