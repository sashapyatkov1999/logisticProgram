package com.example.logisticprogram.mapper.role;

import com.example.logisticprogram.entity.Role;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoleResponseMapperTest {
    @InjectMocks
    private RoleResponseMapper mapper;

    private final Long ID = 0L;

    private final String NAME = "";
    private final String DESCRIPTION = "";
    private final LocalDateTime CREATED = LocalDateTime.now();
    private final LocalDateTime MODIFIED = LocalDateTime.now();

    @Test
    void from(){
        var source = spy(source());
        var result = mapper.from(source);

        assertThat(result.getId()).as("Id не совпадают").isEqualTo(ID);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);

        verify(source).getId();
        verify(source).getName();
        verify(source).getDescription();
        verify(source).getCreated();
        verify(source).getModified();


        verifyNoMoreInteractions(source);
    }
    @Test
    void fromList() {
        var source = spy(source());
        var resultList = mapper.from(List.of(source, source, source));

        assertThat(resultList).isNotEmpty();

        var result = resultList.get(0);

        assertThat(result.getId()).as("Id не совпадают").isEqualTo(ID);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);

        verify(source, times(3)).getId();
        verify(source, times(3)).getName();
        verify(source, times(3)).getDescription();
        verify(source, times(3)).getCreated();
        verify(source, times(3)).getModified();

        verifyNoMoreInteractions(source);
    }
    private Role source() {
        Role source = new Role();
        return source.setId(ID)
                .setName(NAME)
                .setDescription(DESCRIPTION)
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }

}
