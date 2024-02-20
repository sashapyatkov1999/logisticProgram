package com.example.logisticprogram.mapper.car;

import com.example.logisticprogram.dto.request.car.CarAddRequest;
import com.example.logisticprogram.entity.Car;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

class CarMergerTest {
    @InjectMocks
    private CarMerger merger;

    private final Long ID = 0L;

    private static final String CAR_NUMBER = "";
    private static final String TRAILER_NUMBER = "";
    private final LocalDateTime CREATED = LocalDateTime.now();
    private final LocalDateTime MODIFIED = LocalDateTime.now();

    @Test
    void merge() {

        var source = spy(source());
        var target = spy(target());
        var result = merger.merge(target, source);

        verify(source).getCarNumber();
        verify(source).getTrailerNumber();

        verify(target).setTrailerNumber(any());
        verify(target).setCarNumber(any());

        verifyNoMoreInteractions(source, target);

        assertThat(result.getId()).as("Id не совпадают").isEqualTo(ID);
        assertThat(result.getCarNumber()).isEqualTo(CAR_NUMBER);
        assertThat(result.getTrailerNumber()).isEqualTo(TRAILER_NUMBER);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);
        //зачем проверяем на id? ctrated modified

    }


    private Car target(){
        return new Car()
                .setId(ID)
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }

    private CarAddRequest source(){
        return new CarAddRequest()
                .setCarNumber(CAR_NUMBER)
                .setTrailerNumber(TRAILER_NUMBER);
    }
}
