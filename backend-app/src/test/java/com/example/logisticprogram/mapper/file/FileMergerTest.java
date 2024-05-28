package com.example.logisticprogram.mapper.file;

import com.example.logisticprogram.dto.request.file.FileAddRequest;
import com.example.logisticprogram.entity.File;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FileMergerTest {
    @InjectMocks
    private FileMerger merger;
    private static final Long ID = 0L;
    private static final Long USER_ID = 0L;
    private static final Long APPLICATION_ID = 1L;
    private static final Long POINT_ID = 2L;
    private static final String NAME = "NAME";
    private static final String DESCRIPTION = "NAME";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now();

    @Test
    void merge(){
        var source = spy(source());
        var target = spy(target());
        var result = merger.merge(target,source);

        verify(source).getPointId();
        verify(source).getApplicationId();
        verify(source).getUserId();
        verify(source).getDescription();
        verify(source).getName();

        verify(target).setPoint(any());
        verify(target).setApplication(any());
        verify(target).setUser(any());
        verify(target).setDescription(any());
        verify(target).setName(any());

        verifyNoMoreInteractions(source, target);

        assertThat(result.getId()).as("Id не совпадают").isEqualTo(ID);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(result.getUser().getId()).isEqualTo(USER_ID);
        assertThat(result.getApplication().getId()).isEqualTo(APPLICATION_ID);
        assertThat(result.getPoint().getId()).isEqualTo(POINT_ID);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);
    }


    private FileAddRequest source(){
        return new FileAddRequest()
                .setPointId(POINT_ID)
                .setApplicationId(APPLICATION_ID)
                .setUserId(USER_ID)
                .setDescription(DESCRIPTION)
                .setName(NAME);
    }
    private File target(){
        return new File()
                .setId(ID)
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }
}
