package com.example.logisticprogram.mapper.listdoc;

import com.example.logisticprogram.dto.request.listdoc.ListDocAddRequest;
import com.example.logisticprogram.entity.ListDoc;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ListDocMergerTest {
    @InjectMocks
    private ListDocMerger merger;
    private static final Long ID = 0L;

    private static final Long POINT_ID = 1L;
    private static final Long APPLICATION_ID = 2L;
    private static final Long TYPE_DOC_ID = 3L;
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now();

    @Test
    void merge(){
        var source = spy(source());
        var target = spy(target());
        var result = merger.merge(target,source);

        verify(source).getPointId();
        verify(source).getApplicationId();
        verify(source).getTypeDocId();

        verify(target).setPoint(any());
        verify(target).setApplication(any());
        verify(target).setTypeDoc(any());

        verifyNoMoreInteractions(source, target);

        assertThat(result.getId()).as("Id не совпадают").isEqualTo(ID);
        assertThat(result.getPoint().getId()).isEqualTo(POINT_ID);
        assertThat(result.getApplication().getId()).isEqualTo(APPLICATION_ID);
        assertThat(result.getTypeDoc().getId()).isEqualTo(TYPE_DOC_ID);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);
    }
    private ListDocAddRequest source(){
        return new ListDocAddRequest()
                .setPointId(POINT_ID)
                .setApplicationId(APPLICATION_ID)
                .setTypeDocId(TYPE_DOC_ID);
    }
    private ListDoc target(){
        return new ListDoc()
                .setId(ID)
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }
}
