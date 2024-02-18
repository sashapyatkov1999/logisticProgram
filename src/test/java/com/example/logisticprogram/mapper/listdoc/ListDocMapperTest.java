package com.example.logisticprogram.mapper.listdoc;

import com.example.logisticprogram.dto.request.listdoc.ListDocAddRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ListDocMapperTest {
    @InjectMocks
    private ListDocMapper mapper;

    private static final Long POINT_ID = 1L;
    private static final Long APPLICATION_ID = 2L;
    private static final Long TYPE_DOC_ID = 3L;

    @Test
    void from(){
        var source = spy(source());
        var result = mapper.from(source);

        assertThat(result.getId()).isNull();
        assertThat(result.getModified()).isNull();
        assertThat(result.getCreated()).isNull();
        assertThat(result.getPoint().getId()).isEqualTo(POINT_ID);
        assertThat(result.getApplication().getId()).isEqualTo(APPLICATION_ID);
        assertThat(result.getTypeDoc().getId()).isEqualTo(TYPE_DOC_ID);

        verify(source).getPointId();
        verify(source).getApplicationId();
        verify(source).getTypeDocId();
        verifyNoMoreInteractions(source);
    }

    @Test
    void fromList(){
        var source = spy(source());
        var resultList = mapper.from(List.of(source, source, source));

        assertThat(resultList).isNotEmpty();

        var result = resultList.get(0);

        assertThat(result.getId()).isNull();
        assertThat(result.getModified()).isNull();
        assertThat(result.getCreated()).isNull();
        assertThat(result.getPoint().getId()).isEqualTo(POINT_ID);
        assertThat(result.getApplication().getId()).isEqualTo(APPLICATION_ID);
        assertThat(result.getTypeDoc().getId()).isEqualTo(TYPE_DOC_ID);

        verify(source,times(3)).getPointId();
        verify(source,times(3)).getApplicationId();
        verify(source,times(3)).getTypeDocId();
        verifyNoMoreInteractions(source);
    }
    private ListDocAddRequest source(){
        return new ListDocAddRequest()
                .setPointId(POINT_ID)
                .setApplicationId(APPLICATION_ID)
                .setTypeDocId(TYPE_DOC_ID);
    }
}
