package com.example.logisticprogram.service.domain;

import com.example.logisticprogram.dto.request.user.UserAddRequest;
import com.example.logisticprogram.dto.request.userstatus.UserStatusAddRequest;
import com.example.logisticprogram.dto.response.userstatus.UserStatusResponse;
import com.example.logisticprogram.entity.UserStatus;
import com.example.logisticprogram.mapper.userstatus.UserStatusMapper;
import com.example.logisticprogram.mapper.userstatus.UserStatusResponseMapper;
import com.example.logisticprogram.repository.UserStatusRepository;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserStatusDomainServiceTest {
    @Mock
    private UserStatusRepository userStatusRepository;
    @Mock
    private UserStatusResponseMapper userStatusResponseMapper;
    @Mock
    private UserStatusMapper userStatusMapper;
    @InjectMocks
    private UserStatusDomainService service;

    private final List<UserStatus> usersStatus = new ArrayList<>();
    private final UserStatus userStatusAdd = new UserStatus(1L);
    private final List<UserStatusResponse> userResponses = new ArrayList<>();
    private final Long ID = 0L;
    private final Long id = 1L;

    @Test
    void getUserStatusTest(){

        when(userStatusResponseMapper.from((UserStatus) any())).thenReturn(getUserStatusResponse());
        when(userStatusRepository.getReferenceById(anyLong())).thenReturn(getUserStatus());

        var result = service.getUserStatus(ID);

        assertNotNull(result);

        verify(userStatusRepository).getReferenceById(anyLong());
        verify(userStatusResponseMapper).from((UserStatus) any());
        verifyNoMoreInteractions(userStatusRepository, userStatusResponseMapper);
        verifyNoInteractions(userStatusMapper);
    }

    @Test
    void getAllUserStatusTest(){
        addUserStatusAndUserResponses();

        when(userStatusRepository.findAll()).thenReturn(usersStatus);
        when(userStatusResponseMapper.from(usersStatus)).thenReturn(userResponses);

        List<UserStatusResponse> result = service.getAllUserStatuses();

        assertEquals(userResponses, result);
        assertNotNull(result);
        verify(userStatusRepository).findAll();
        verify(userStatusResponseMapper).from(usersStatus);

        verifyNoMoreInteractions(userStatusRepository, userStatusResponseMapper);
        verifyNoInteractions(userStatusMapper);
    }

    @Test
    void  deleteUserStatus(){
        service.deleteUserStatus(id);
        verify(userStatusRepository).deleteById(id);

        verifyNoMoreInteractions(userStatusRepository, userStatusResponseMapper);
        verifyNoInteractions(userStatusMapper);
    }

    @Test
    void addUserStatus(){
        when(userStatusMapper.from(userStatusAddRequestAdd())).thenReturn(userStatusAdd);
        when(userStatusRepository.save(userStatusAdd)).thenReturn(userStatusAdd);
        Long id = service.addUserStatus(userStatusAddRequestAdd());
        assertEquals(userStatusAdd.getId(),id.longValue());
        verify(userStatusMapper).from(userStatusAddRequestAdd());
        verify(userStatusRepository).save(userStatusAdd);
        verifyNoMoreInteractions(userStatusRepository, userStatusResponseMapper);

    }
    private void addUserStatusAndUserResponses(){
        usersStatus.add(new UserStatus(id));
        usersStatus.add(new UserStatus(ID));
        userResponses.add(new UserStatusResponse());
        userResponses.add(new UserStatusResponse());
    }
    private UserStatusAddRequest userStatusAddRequestAdd(){
        UserStatusAddRequest userStatusAddRequestAdd = new UserStatusAddRequest();
        return  userStatusAddRequestAdd;
    }
    private UserStatusResponse getUserStatusResponse(){
        return new UserStatusResponse().setId(ID);
    }

    private UserStatus getUserStatus(){return new UserStatus(ID);}
}
