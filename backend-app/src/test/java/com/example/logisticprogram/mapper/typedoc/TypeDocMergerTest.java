package com.example.logisticprogram.mapper.typedoc;

import com.example.logisticprogram.dto.request.typedoc.TypeDocAddRequest;
import com.example.logisticprogram.entity.TypeDoc;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TypeDocMergerTest {
    @InjectMocks
    private TypeDocMerger merger;
    private static final Long ID = 0L;
    private static  final String NAME = "NAME";
    private static  final String DESCRIPTION  = "DESCRIPTION";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now();

    @Test
    void merge(){
        var source = spy(source());
        var target = spy(target());
        var result = merger.merge(target,source);

        verify(source).getName();
        verify(source).getDescription();

        verify(target).setName(any());
        verify(target).setDescription(any());

        assertThat(result.getId()).as("Id не совпадают").isEqualTo(ID);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);

    }
    private TypeDocAddRequest source(){
        return new TypeDocAddRequest()
                .setName(NAME)
                .setDescription(DESCRIPTION);
    }
    private TypeDoc target(){
        return new TypeDoc()
                .setId(ID)
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }
}
