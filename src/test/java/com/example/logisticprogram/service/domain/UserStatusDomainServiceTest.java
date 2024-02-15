package com.example.logisticprogram.service.domain;

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

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserStatusDomainServiceTest {
    @Mock
    private UserStatusRepository userStatusRepository;
    @Mock
    private UserStatusResponseMapper userStatusResponseMapper;
    @Mock
    private UserStatusMapper userStatusMapper;
    @InjectMocks
    private UserStatusDomainService service;

    private final Long ID = 0L;


    @Test
    void getUserStatusTest() {

        when(userStatusResponseMapper.from((UserStatus) any())).thenReturn(getUserStatusResponse());
        when(userStatusRepository.getReferenceById(anyLong())).thenReturn(getUserStatus());

        var result = service.getUserStatus(ID);

        assertThat(result).isNotNull();

        verify(userStatusRepository).getReferenceById(anyLong());
        verify(userStatusResponseMapper).from((UserStatus) any());
        verifyNoMoreInteractions(userStatusRepository, userStatusResponseMapper);
        verifyNoInteractions(userStatusMapper);
    }

    @Test
    void getAllUserStatusTest() {

        when(userStatusRepository.findAll()).thenReturn(Collections.singletonList(getUserStatus()));
        when(userStatusResponseMapper.from(any(List.class))).thenReturn(Collections.singletonList(getUserStatusResponse()));

        List<UserStatusResponse> result = service.getAllUserStatuses();

        assertThat(result).hasSize(1);


        verify(userStatusRepository).findAll();
        verify(userStatusResponseMapper).from(any(List.class));

        verifyNoMoreInteractions(userStatusRepository, userStatusResponseMapper);
        verifyNoInteractions(userStatusMapper);
    }

    @Test
    void deleteUserStatus() {
        service.deleteUserStatus(ID);
        verify(userStatusRepository).deleteById(ID);

        verifyNoMoreInteractions(userStatusRepository, userStatusResponseMapper);
        verifyNoInteractions(userStatusMapper);
    }

    @Test
    void addUserStatus() {
        when(userStatusMapper.from(any(UserStatusAddRequest.class))).thenReturn(getUserStatus());
        when(userStatusRepository.save(any())).thenReturn(getUserStatus());

        Long id = service.addUserStatus(userStatusAddRequestAdd());

        assertThat(id).isEqualTo(ID);

        verify(userStatusMapper).from(any(UserStatusAddRequest.class));
        verify(userStatusRepository).save(any());
        verifyNoMoreInteractions(userStatusRepository, userStatusResponseMapper);

    }

    private UserStatusAddRequest userStatusAddRequestAdd() {
        return new UserStatusAddRequest();
    }

    private UserStatusResponse getUserStatusResponse() {
        return new UserStatusResponse().setId(ID);
    }

    private UserStatus getUserStatus() {
        return new UserStatus(ID);
    }
}
