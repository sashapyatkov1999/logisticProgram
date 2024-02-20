package com.example.logisticprogram.mapper.userrole;

import com.example.logisticprogram.dto.response.role.RoleResponse;
import com.example.logisticprogram.dto.response.user.UserResponse;
import com.example.logisticprogram.entity.Role;
import com.example.logisticprogram.entity.User;
import com.example.logisticprogram.entity.UserRole;
import com.example.logisticprogram.mapper.role.RoleResponseMapper;
import com.example.logisticprogram.mapper.user.UserResponseMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserRoleResponseMapperTest {
    @InjectMocks
    private UserRoleResponseMapper mapper;
    @Mock
    private UserResponseMapper userResponseMapper;
    @Mock
    private RoleResponseMapper roleResponseMapper;

    private static final Long USER_ID = 1L;
    private static final Long ROLE_ID = 2L;


    @Test
    void from(){
        when(userResponseMapper.from(any(User.class))).thenReturn(new UserResponse().setId(USER_ID));
        when(roleResponseMapper.from(any(Role.class))).thenReturn(new RoleResponse().setId(ROLE_ID));

        var source = spy(source());
        var result = mapper.from(source);

        assertThat(result.getId()).isNull();
        assertThat(result.getUser().getId()).isEqualTo(USER_ID);
        assertThat(result.getRole().getId()).isEqualTo(ROLE_ID);

        verify(source).getUser();
        verify(source).getRole();
        verify(source).getCreated();
        verify(source).getModified();
        verify(userResponseMapper).from(any(User.class));
        verify(roleResponseMapper).from(any(Role.class));
        verifyNoMoreInteractions(source);
    }
    @Test
    void fromList() {
        when(userResponseMapper.from(any(User.class))).thenReturn(new UserResponse().setId(USER_ID));
        when(roleResponseMapper.from(any(Role.class))).thenReturn(new RoleResponse().setId(ROLE_ID));

        var source = spy(source());
        var resultList = mapper.from(List.of(source, source, source));

        assertThat(resultList).isNotEmpty();

        var result = resultList.get(0);

        assertThat(result.getId()).isNull();
        assertThat(result.getUser().getId()).isEqualTo(USER_ID);
        assertThat(result.getRole().getId()).isEqualTo(ROLE_ID);

        verify(source,times(3)).getUser();
        verify(source,times(3)).getRole();
        verify(source,times(3)).getCreated();
        verify(source,times(3)).getModified();
        verify(userResponseMapper,times(3)).from(any(User.class));
        verify(roleResponseMapper,times(3)).from(any(Role.class));
        verifyNoMoreInteractions(source);

    }
        private UserRole source(){
        return new UserRole()
                .setUser(new User(USER_ID))
                .setRole(new Role(ROLE_ID));
    }
}
