package com.example.logisticprogram.service.domain;

import com.example.logisticprogram.dto.request.role.RoleAddRequest;
import com.example.logisticprogram.dto.response.role.RoleResponse;
import com.example.logisticprogram.entity.Role;
import com.example.logisticprogram.mapper.role.RoleMapper;
import com.example.logisticprogram.mapper.role.RoleMerger;
import com.example.logisticprogram.mapper.role.RoleResponseMapper;
import com.example.logisticprogram.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class RoleDomainServiceTest {

        @Mock
        private RoleRepository roleRepository;
        @Mock
        private RoleMerger roleMerger;
        @Mock
        private RoleResponseMapper roleResponseMapper;
        @Mock
        private RoleMapper roleMapper;
        @InjectMocks
        private RoleDomainService service;
        private final Long ID = 0L;



        @Test
        void getRoleTest() {
            when(roleRepository.findById(anyLong())).thenReturn(Optional.of(getRole()));
            when(roleResponseMapper.from(any(Role.class))).thenReturn(getRoleResponse());
            RoleResponse result = service.getRole(ID)
                    ;
            assertThat(result).isNotNull();

            verify(roleRepository).findById(ID);
            verify(roleResponseMapper).from(any(Role.class));
            verifyNoMoreInteractions(roleRepository, roleResponseMapper);
        }


        @Test
        void getAllRolesTest() {
            when(roleRepository.findAll()).thenReturn(Collections.singletonList(getRole()));
            when(roleResponseMapper.from(anyList())).thenReturn(Collections.singletonList(getRoleResponse()));

            List<RoleResponse> result = service.getAllRoles();

            assertThat(result).isNotNull();

            verify(roleRepository).findAll();
            verify(roleResponseMapper).from(anyList());

            verifyNoMoreInteractions(roleRepository, roleResponseMapper);
            verifyNoInteractions(roleMapper);
        }

        @Test
        void deleteRoleTest() {
            service.deleteRole(ID);
            verify(roleRepository).deleteById(ID);

            verifyNoMoreInteractions(roleRepository, roleResponseMapper);
            verifyNoInteractions(roleMapper);
        }
        @Test
        void editRoleTest(){
        when(roleRepository.getReferenceById(anyLong())).thenReturn(getRole());
        when(roleMerger.merge(any(),any())).thenReturn(getRole());
        when(roleRepository.save(any())).thenReturn(getRole());

        Long result = service.editRole(getRoleAddRequest());

        assertThat(result).isEqualTo(ID);

        verify(roleRepository).getReferenceById(anyLong());
        verify(roleRepository).save(any());
        verify(roleMerger).merge(any(),any());
        verifyNoMoreInteractions(roleRepository,roleMerger);

    }

        @Test
        void addRoleTest() {
            when(roleMapper.from(any(RoleAddRequest.class))).thenReturn(getRole());
            when(roleRepository.save(any())).thenReturn(getRole());

            Long id = service.addRole(getRoleAddRequest());
            assertThat(id).isEqualTo(ID);

            verify(roleMapper).from(any(RoleAddRequest.class));
            verify(roleRepository).save(any());
            verifyNoMoreInteractions(roleRepository, roleResponseMapper);
        }

        private RoleResponse getRoleResponse(){
            return  new RoleResponse()
                    .setId(ID);
        }

        private Role getRole(){
            return new Role(ID);
        }

        private RoleAddRequest getRoleAddRequest(){
             return new RoleAddRequest().setId(ID);
    }
}
