package com.example.logisticprogram.mapper.userrole;

import com.example.logisticprogram.dto.request.userrole.UserRoleAddRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserRoleMapperTest {
    @InjectMocks
    private UserRoleMapper mapper;

    private static final Long USER_ID = 1L;
    private static final Long ROLE_ID = 2L;

    @Test
    void from(){
        var source = spy(source());
        var result = mapper.from(source);

        assertThat(result.getId()).isNull();
        assertThat(result.getUser().getId()).isEqualTo(USER_ID);
        assertThat(result.getRole().getId()).isEqualTo(ROLE_ID);

        verify(source).getUserId();
        verify(source).getRoleId();
        verifyNoMoreInteractions(source);
    }

    @Test
    void fromList(){
        var source = spy(source());
        var resultList = mapper.from(List.of(source, source, source));

        assertThat(resultList).isNotEmpty();

        var result = resultList.get(0);

        assertThat(result.getId()).isNull();
        assertThat(result.getUser().getId()).isEqualTo(USER_ID);
        assertThat(result.getRole().getId()).isEqualTo(ROLE_ID);

        verify(source,times(3)).getUserId();
        verify(source,times(3)).getRoleId();
        verifyNoMoreInteractions(source);
    }
    private UserRoleAddRequest source(){
        return new UserRoleAddRequest()
                .setUserId(USER_ID)
                .setRoleId(ROLE_ID);
    }
}
