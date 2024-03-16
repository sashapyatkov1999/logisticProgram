package com.example.logisticprogram.mapper.point;

import com.example.logisticprogram.dto.response.application.ApplicationResponse;
import com.example.logisticprogram.entity.Application;
import com.example.logisticprogram.entity.Point;
import com.example.logisticprogram.mapper.application.ApplicationResponseMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PointResponseMapperTest {
    @InjectMocks
    private PointResponseMapper mapper;
    @Mock
    private ApplicationResponseMapper applicationResponseMapper;
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
    void from(){
        when(applicationResponseMapper.from(any(Application.class))).thenReturn(new ApplicationResponse().setId(APPLICATION_ID));

        var source = spy(source());
        var result = mapper.from(source);

        assertThat(result.getId()).isEqualTo(ID);
        assertThat(result.getField()).isEqualTo(FIELD);
        assertThat(result.getOrdinal().longValue()).isEqualTo(ORDINAL);
        assertThat(result.getApplication().getId()).isEqualTo(APPLICATION_ID);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getStatusOfOrdinalWithGeo()).isEqualTo(STATUS_OF_ORDINAL_WITH_GEO);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(result.getTimeStart()).isEqualTo(TIME_START);
        assertThat(result.getTimeEnd()).isEqualTo(TIME_END);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);

        verify(source).getId();
        verify(source).getField();
        verify(source).getOrdinal();
        verify(source).getApplication();
        verify(source).getName();
        verify(source).getStatusOfOrdinalWithGeo();
        verify(source).getDescription();
        verify(source).getTimeStart();
        verify(source).getTimeEnd();
        verify(source).getCreated();
        verify(source).getModified();
        verify(applicationResponseMapper).from(any(Application.class));

        verifyNoMoreInteractions(source);

    }

    @Test
    void fromList() {
        when(applicationResponseMapper.from(any(Application.class))).thenReturn(new ApplicationResponse().setId(APPLICATION_ID));

        var source = spy(source());
        var resultList = mapper.from(List.of(source, source, source));

        assertThat(resultList).isNotEmpty();

        var result = resultList.get(0);

        assertThat(result.getId()).isEqualTo(ID);
        assertThat(result.getField()).isEqualTo(FIELD);
        assertThat(result.getOrdinal().longValue()).isEqualTo(ORDINAL);
        assertThat(result.getApplication().getId()).isEqualTo(APPLICATION_ID);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getStatusOfOrdinalWithGeo()).isEqualTo(STATUS_OF_ORDINAL_WITH_GEO);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(result.getTimeStart()).isEqualTo(TIME_START);
        assertThat(result.getTimeEnd()).isEqualTo(TIME_END);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);

        verify(source,times(3)).getId();
        verify(source,times(3)).getField();
        verify(source,times(3)).getOrdinal();
        verify(source,times(3)).getApplication();
        verify(source,times(3)).getName();
        verify(source,times(3)).getStatusOfOrdinalWithGeo();
        verify(source,times(3)).getDescription();
        verify(source,times(3)).getTimeStart();
        verify(source,times(3)).getTimeEnd();
        verify(source,times(3)).getCreated();
        verify(source,times(3)).getModified();
        verify(applicationResponseMapper,times(3)).from(any(Application.class));

        verifyNoMoreInteractions(source);

    }
        private Point source(){
        return new Point()
                .setId(ID)
                .setApplication(new Application(APPLICATION_ID))
                .setField(FIELD)
                .setOrdinal(ORDINAL)
                .setStatusOfOrdinalWithGeo(STATUS_OF_ORDINAL_WITH_GEO)
                .setName(NAME)
                .setDescription(DESCRIPTION)
                .setCreated(CREATED)
                .setModified(MODIFIED)
                .setTimeStart(TIME_START)
                .setTimeEnd(TIME_END);
    }
}
