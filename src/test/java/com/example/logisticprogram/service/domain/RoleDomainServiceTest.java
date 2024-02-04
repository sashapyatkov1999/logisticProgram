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
import java.util.Optional;

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
        private final List<Role> roles = new ArrayList<>();
        private final Role roleAdd = new Role(1L);
        private final List<RoleResponse> roleResponses = new ArrayList<>();
        private final Long ID = 0L;
        private final Long id = 1L;



        @Test
        void getRoleTest() {
            when(roleRepository.findById(id)).thenReturn(Optional.of(getRole()));
            when(roleResponseMapper.from((Role) any())).thenReturn(roleResponse());
            RoleResponse result = service.getRole(id);
            assertNotNull(result);
            verify(roleRepository).findById(id);
            verify(roleResponseMapper).from((Role) any());
            verifyNoMoreInteractions(roleRepository, roleResponseMapper);
        }


        @Test
        void getAllRolesTest() {
            addRole();

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
        setRole();

        when(roleRepository.getReferenceById(roleAddRequestAdd().getId())).thenReturn(roleAdd);
        when(roleMerger.merge(roleAdd,roleAddRequestAdd())).thenReturn(roleAdd);
        when(roleRepository.save(roleAdd)).thenReturn(roleAdd);

        Long result = service.editRole(roleAddRequestAdd());

        verify(roleRepository).getReferenceById(roleAddRequestAdd().getId());
        verify(roleRepository).save(roleAdd);
        verify(roleMerger).merge(roleAdd,roleAddRequestAdd());

        assertEquals(1L, result);

    }

        @Test
        void addRoleTest() {
            when(roleMapper.from(roleAddRequestAdd())).thenReturn(roleAdd);
            when(roleRepository.save(roleAdd)).thenReturn(roleAdd);
            Long id = service.addRole(roleAddRequestAdd());
            assertEquals(roleAdd.getId(),id.longValue());
            verify(roleMapper).from(roleAddRequestAdd());
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
        private RoleResponse roleResponse(){
            return new RoleResponse();
        }
        private void addRole(){
            roles.add(new Role(1L));
            roles.add(new Role(2L));
            roleResponses.add(new RoleResponse());
            roleResponses.add(new RoleResponse());
        }
        private void setRole(){
            roleAddRequestAdd().setId(id);
            roleAdd.setId(id);
        }
    private final RoleAddRequest roleAddRequestAdd(){
             return new RoleAddRequest();
    }
}
