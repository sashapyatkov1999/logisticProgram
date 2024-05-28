package com.example.logisticprogram.mapper.point;

import com.example.logisticprogram.dto.request.point.PointAddRequest;
import com.example.logisticprogram.entity.Point;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PointMergerTest {
    @InjectMocks
    private PointMerger merger;

    private static final Long ID = 0L;
    private static final Long APPLICATION_ID = 1L;
    private static final String FIELD = " ";
    private static final Long ORDINAL = 0L;
    private static final Boolean STATUS_OF_ORDINAL_WITH_GEO = true;
    private static final String NAME = "NAME";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final LocalDateTime TIME_START  = LocalDateTime.now();
    private static final LocalDateTime TIME_END  = LocalDateTime.now();
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now();

    @Test
    void merge() {

        var source = spy(source());
        var target = spy(target());
        var result = merger.merge(target, source);

        verify(source).getField();
        verify(source).getOrdinal();
        verify(source).getApplicationId();
        verify(source).getName();
        verify(source).getStatusOfOrdinalWithGeo();
        verify(source).getDescription();
        verify(source).getTimeStart();
        verify(source).getTimeEnd();

        verify(target).setField(any());
        verify(target).setOrdinal(any());
        verify(target).setApplication(any());
        verify(target).setName(any());
        verify(target).setStatusOfOrdinalWithGeo(any());
        verify(target).setDescription(any());
        verify(target).setTimeStart(any());
        verify(target).setTimeEnd(any());

        verifyNoMoreInteractions(source, target);

        assertThat(result.getField()).isEqualTo(FIELD);
        assertThat(result.getOrdinal()).isEqualTo(ORDINAL);
        assertThat(result.getApplication().getId()).isEqualTo(APPLICATION_ID);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getStatusOfOrdinalWithGeo()).isEqualTo(STATUS_OF_ORDINAL_WITH_GEO);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(result.getTimeStart()).isEqualTo(TIME_START);
        assertThat(result.getTimeEnd()).isEqualTo(TIME_END);

    }
    private PointAddRequest source(){
        return new PointAddRequest()
                .setField(FIELD)
                .setOrdinal(Math.toIntExact(ORDINAL))
                .setApplicationId(APPLICATION_ID)
                .setName(NAME)
                .setStatusOfOrdinalWithGeo(STATUS_OF_ORDINAL_WITH_GEO)
                .setDescription(DESCRIPTION)
                .setTimeStart(TIME_START)
                .setTimeEnd(TIME_END);
    }

    private Point target(){
        return new Point()
                .setId(ID)
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }
}
