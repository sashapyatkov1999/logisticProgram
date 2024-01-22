package com.example.logisticprogram.service.domain;

import com.example.logisticprogram.dto.response.user.UserResponse;
import com.example.logisticprogram.entity.User;
import com.example.logisticprogram.mapper.user.UserMapper;
import com.example.logisticprogram.mapper.user.UserResponseMapper;
import com.example.logisticprogram.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserDomainServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserResponseMapper userResponseMapper;
    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserDomainService service;


    private final Long ID = 0L;


    @Test
    void getUserTest() {

        when(userResponseMapper.from((User) any())).thenReturn(getUserResponse());
        when(userRepository.getReferenceById(anyLong())).thenReturn(getUser());

        var result = service.getUser(ID);

        assertNotNull(result);

        verify(userRepository).getReferenceById(anyLong());
        verify(userResponseMapper).from((User) any());
        verifyNoMoreInteractions(userRepository, userResponseMapper);
        verifyNoInteractions(userMapper);
    }

    @Test
    void getAllUsersTest() {
    }

    @Test
    void deleteUserTest() {
    }

    @Test
    void addUserTest() {
    }


    private UserResponse getUserResponse(){
        return  new UserResponse()
                .setId(ID);
    }

    private User getUser(){
        return new User(ID);
    }

}
