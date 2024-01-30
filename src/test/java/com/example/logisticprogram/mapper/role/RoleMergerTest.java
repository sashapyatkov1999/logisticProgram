package com.example.logisticprogram.mapper.role;

import com.example.logisticprogram.dto.request.role.RoleAddRequest;
import com.example.logisticprogram.entity.Role;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class RoleMergerTest {

    private static final Long ID = 0L;
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now();


    @InjectMocks
    private RoleMerger merger;

    @Test
    void merge() {

        var source = spy(getRoleAddRequest());
        var target = spy(getRole());

        var result = merger.merge(target, source);

        verify(source).getName();
        verify(source).getDescription();

        verify(target).setName(any());
        verify(target).setDescription(any());
        verifyNoMoreInteractions(source, target);

        assertEquals(ID, result.getId());
        assertEquals(NAME, result.getName());
        assertEquals(DESCRIPTION, result.getDescription());
        assertEquals(CREATED, result.getCreated());
        assertEquals(MODIFIED, result.getModified());
    }

    private Role getRole() {
        return new Role()
                .setId(ID)
                .setName("")
                .setDescription("")
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }

    private RoleAddRequest getRoleAddRequest() {
        return new RoleAddRequest()
                .setId(ID)
                .setName(NAME)
                .setDescription(DESCRIPTION);
    }

}
