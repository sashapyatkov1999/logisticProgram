package com.example.logisticprogram.mapper.listdoc;

import com.example.logisticprogram.dto.response.application.ApplicationResponse;
import com.example.logisticprogram.dto.response.point.PointResponse;
import com.example.logisticprogram.dto.response.typedoc.TypeDocResponse;
import com.example.logisticprogram.entity.Application;
import com.example.logisticprogram.entity.ListDoc;
import com.example.logisticprogram.entity.Point;
import com.example.logisticprogram.entity.TypeDoc;
import com.example.logisticprogram.mapper.application.ApplicationResponseMapper;
import com.example.logisticprogram.mapper.point.PointResponseMapper;
import com.example.logisticprogram.mapper.typedoc.TypeDocResponseMapper;
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

@ExtendWith(MockitoExtension.class)
class ListDocResponseMapperTest {
    @InjectMocks
    private ListDocResponseMapper mapper;

    @Mock
    private ApplicationResponseMapper applicationResponseMapper;
    @Mock
    private TypeDocResponseMapper typeDocResponseMapper;
    @Mock
    private PointResponseMapper pointResponseMapper;

    private final Long ID = 0L;
    private static final Long POINT_ID = 1L;
    private static final Long APPLICATION_ID = 2L;
    private static final Long TYPE_DOC_ID = 3L;
    private final LocalDateTime CREATED = LocalDateTime.now();
    private final LocalDateTime MODIFIED = LocalDateTime.now();

    @Test
    void from(){
        when(applicationResponseMapper.from(any(Application.class))).thenReturn(new ApplicationResponse().setId(APPLICATION_ID));
        when(pointResponseMapper.from(any(Point.class))).thenReturn(new PointResponse().setId(POINT_ID));
        when(typeDocResponseMapper.from(any(TypeDoc.class))).thenReturn(new TypeDocResponse().setId(TYPE_DOC_ID));

        var source = spy(source());
        var result = mapper.from(source);

        assertThat(result.getId()).as("Id не совпадают").isEqualTo(ID);
        assertThat(result.getPoint().getId()).isEqualTo(POINT_ID);
        assertThat(result.getApplication().getId()).isEqualTo(APPLICATION_ID);
        assertThat(result.getTypeDoc().getId()).isEqualTo(TYPE_DOC_ID);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);

        verify(source).getId();
        verify(source).getPoint();
        verify(source).getApplication();
        verify(source).getTypeDoc();
        verify(source).getCreated();
        verify(source).getModified();
        verify(applicationResponseMapper).from(any(Application.class));
        verify(pointResponseMapper).from(any(Point.class));
        verify(typeDocResponseMapper).from(any(TypeDoc.class));
        verifyNoMoreInteractions(source);
    }
    @Test
    void fromList(){
        when(applicationResponseMapper.from(any(Application.class))).thenReturn(new ApplicationResponse().setId(APPLICATION_ID));
        when(pointResponseMapper.from(any(Point.class))).thenReturn(new PointResponse().setId(POINT_ID));
        when(typeDocResponseMapper.from(any(TypeDoc.class))).thenReturn(new TypeDocResponse().setId(TYPE_DOC_ID));

        var source = spy(source());
        var resultList = mapper.from(List.of(source, source, source));

        assertThat(resultList).isNotEmpty();

        var result = resultList.get(0);

        assertThat(result.getId()).as("Id не совпадают").isEqualTo(ID);
        assertThat(result.getPoint().getId()).isEqualTo(POINT_ID);
        assertThat(result.getApplication().getId()).isEqualTo(APPLICATION_ID);
        assertThat(result.getTypeDoc().getId()).isEqualTo(TYPE_DOC_ID);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);

        verify(source,times(3)).getId();
        verify(source,times(3)).getPoint();
        verify(source,times(3)).getApplication();
        verify(source,times(3)).getTypeDoc();
        verify(source,times(3)).getCreated();
        verify(source,times(3)).getModified();
        verify(applicationResponseMapper,times(3)).from(any(Application.class));
        verify(pointResponseMapper,times(3)).from(any(Point.class));
        verify(typeDocResponseMapper,times(3)).from(any(TypeDoc.class));
        verifyNoMoreInteractions(source);
    }
    private ListDoc source(){
        return new ListDoc()
                .setId(ID)
                .setPoint(new Point(POINT_ID))
                .setApplication(new Application(APPLICATION_ID))
                .setTypeDoc(new TypeDoc(TYPE_DOC_ID))
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }
}
