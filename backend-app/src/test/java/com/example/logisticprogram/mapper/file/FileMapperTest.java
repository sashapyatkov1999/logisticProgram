package com.example.logisticprogram.mapper.file;

import com.example.logisticprogram.dto.request.file.FileAddRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FileMapperTest {
    @InjectMocks
    private FileMapper mapper;

    private static final Long USER_ID = 0L;
    private static final Long APPLICATION_ID = 1L;
    private static final Long POINT_ID = 2L;
    private static final String NAME = "NAME";
    private static final String DESCRIPTION = "NAME";

    @Test
    void from(){
        var source = spy(source());
        var result = mapper.from(source);

        assertThat(result.getId()).isNull();
        assertThat(result.getCreated()).isNull();
        assertThat(result.getModified()).isNull();
        assertThat(result.getUser().getId()).isEqualTo(USER_ID);
        assertThat(result.getApplication().getId()).isEqualTo(APPLICATION_ID);
        assertThat(result.getPoint().getId()).isEqualTo(POINT_ID);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);

        verify(source).getUserId();
        verify(source).getApplicationId();
        verify(source).getPointId();
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
        assertThat(result.getUser().getId()).isEqualTo(USER_ID);
        assertThat(result.getApplication().getId()).isEqualTo(APPLICATION_ID);
        assertThat(result.getPoint().getId()).isEqualTo(POINT_ID);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);

        verify(source,times(3)).getUserId();
        verify(source,times(3)).getApplicationId();
        verify(source,times(3)).getPointId();
        verify(source,times(3)).getName();
        verify(source,times(3)).getDescription();
        verifyNoMoreInteractions(source);
    }

    private FileAddRequest source(){
        return new FileAddRequest()
                .setUserId(USER_ID)
                .setApplicationId(APPLICATION_ID)
                .setPointId(POINT_ID)
                .setName(NAME)
                .setDescription(DESCRIPTION);
    }
}
