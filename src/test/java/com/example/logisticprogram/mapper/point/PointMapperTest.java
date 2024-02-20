package com.example.logisticprogram.mapper.point;

import com.example.logisticprogram.dto.request.point.PointAddRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PointMapperTest {
    @InjectMocks
    private PointMapper mapper;

    private static final Long APPLICATION_ID = 1L;
    private static final String FIELD = " ";
    private static final Long ORDINAL = 0L;
    private static final Boolean STATUS_OF_ORDINAL_WITH_GEO = true;
    private static final String NAME = "NAME";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final LocalDateTime TIME_START  = LocalDateTime.now();
    private static final LocalDateTime TIME_END  = LocalDateTime.now();

    @Test
    void from(){
        var source = spy(source());
        var result = mapper.from(source);

        assertThat(result.getId()).isNull();
        assertThat(result.getApplication().getId()).isEqualTo(APPLICATION_ID);
        assertThat(result.getField()).isEqualTo(FIELD);
        assertThat(result.getOrdinal()).isEqualTo(ORDINAL);
        assertThat(result.getStatusOfOrdinalWithGeo()).isEqualTo(STATUS_OF_ORDINAL_WITH_GEO);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(result.getTimeStart()).isEqualTo(TIME_START);
        assertThat(result.getTimeEnd()).isEqualTo(TIME_END);

        verify(source).getApplicationId();
        verify(source).getField();
        verify(source).getOrdinal();
        verify(source).getStatusOfOrdinalWithGeo();
        verify(source).getName();
        verify(source).getDescription();
        verify(source).getTimeStart();
        verify(source).getTimeEnd();
        verifyNoMoreInteractions(source);
    }

    @Test
    void fromList(){
        var source = spy(source());
        var resultList = mapper.from(List.of(source, source, source));

        assertThat(resultList).isNotEmpty();

        var result = resultList.get(0);

        assertThat(result.getId()).isNull();
        assertThat(result.getApplication().getId()).isEqualTo(APPLICATION_ID);
        assertThat(result.getField()).isEqualTo(FIELD);
        assertThat(result.getOrdinal()).isEqualTo(ORDINAL);
        assertThat(result.getStatusOfOrdinalWithGeo()).isEqualTo(STATUS_OF_ORDINAL_WITH_GEO);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(result.getTimeStart()).isEqualTo(TIME_START);
        assertThat(result.getTimeEnd()).isEqualTo(TIME_END);

        verify(source,times(3)).getApplicationId();
        verify(source,times(3)).getField();
        verify(source,times(3)).getOrdinal();
        verify(source,times(3)).getStatusOfOrdinalWithGeo();
        verify(source,times(3)).getName();
        verify(source,times(3)).getDescription();
        verify(source,times(3)).getTimeStart();
        verify(source,times(3)).getTimeEnd();
        verifyNoMoreInteractions(source);
    }
    private PointAddRequest source(){
        return new PointAddRequest()
                .setApplicationId(APPLICATION_ID)
                .setField(FIELD)
                .setOrdinal(Math.toIntExact(ORDINAL))
                .setStatusOfOrdinalWithGeo(STATUS_OF_ORDINAL_WITH_GEO)
                .setName(NAME)
                .setDescription(DESCRIPTION)
                .setTimeStart(TIME_START)
                .setTimeEnd(TIME_END);
    }
}
