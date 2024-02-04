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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
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

        private final RoleAddRequest roleAddRequestAdd = new RoleAddRequest();
        private final List<Role> roles = new ArrayList<>();
        private final Role roleAdd = new Role(1L);
        private final List<RoleResponse> roleResponses = new ArrayList<>();
        private final Long ID = 0L;
        private final Long id = 1L;



        @Test
        void getRoleTest() {

            when(roleResponseMapper.from((Role) any())).thenReturn(getRoleResponse());
            when(roleRepository.getReferenceById(anyLong())).thenReturn(getRole());

            var result = service.getRole(ID);

            assertNotNull(result);

            verify(roleRepository).getReferenceById(anyLong());
            verify(roleResponseMapper).from((Role) any());
            verifyNoMoreInteractions(roleRepository, roleResponseMapper);
            verifyNoInteractions(roleMapper);
        }

        @Test
        void getAllRolesTest() {
            roles.add(new Role(1L));
            roles.add(new Role(2L));
            roleResponses.add(new RoleResponse());
            roleResponses.add(new RoleResponse());

            when(roleRepository.findAll()).thenReturn(roles);
            when(roleResponseMapper.from(roles)).thenReturn(roleResponses);

            List<RoleResponse> result = service.getAllRoles();

            assertEquals(roleResponses, result);
            assertNotNull(result);
            verify(roleRepository).findAll();
            verify(roleResponseMapper).from(roles);

            verifyNoMoreInteractions(roleRepository, roleResponseMapper);
            verifyNoInteractions(roleMapper);
        }

        @Test
        void deleteRoleTest() {
            service.deleteRole(id);
            verify(roleRepository).deleteById(id);

            verifyNoMoreInteractions(roleRepository, roleResponseMapper);
            verifyNoInteractions(roleMapper);
        }
        @Test
        void editRoleTest(){
        roleAddRequestAdd.setId(1L);
        roleAdd.setId(1L);

        when(roleRepository.getReferenceById(roleAddRequestAdd.getId())).thenReturn(roleAdd);
        when(roleMerger.merge(roleAdd,roleAddRequestAdd)).thenReturn(roleAdd);
        when(roleRepository.save(roleAdd)).thenReturn(roleAdd);

        Long result = service.editRole(roleAddRequestAdd);

        verify(roleRepository).getReferenceById(roleAddRequestAdd.getId());
        verify(roleRepository).save(roleAdd);
        verify(roleMerger).merge(roleAdd,roleAddRequestAdd);

        assertEquals(1L, result);

    }

        @Test
        void addRoleTest() {
            when(roleMapper.from(roleAddRequestAdd)).thenReturn(roleAdd);
            when(roleRepository.save(roleAdd)).thenReturn(roleAdd);
            Long id = service.addRole(roleAddRequestAdd);
            assertEquals(roleAdd.getId(),id.longValue());
            verify(roleMapper).from(roleAddRequestAdd);
            verify(roleRepository).save(roleAdd);
            verifyNoMoreInteractions(roleRepository, roleResponseMapper);
        }

        private RoleResponse getRoleResponse(){
            return  new RoleResponse()
                    .setId(ID);
        }

        private Role getRole(){
            return new Role(ID);
        }
}
