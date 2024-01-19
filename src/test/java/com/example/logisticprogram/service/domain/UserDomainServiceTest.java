package com.example.logisticprogram.service.domain;

import com.example.logisticprogram.dto.request.user.UserAddRequest;
import com.example.logisticprogram.dto.response.user.UserResponse;
import com.example.logisticprogram.entity.User;
import com.example.logisticprogram.mapper.user.UserMapper;
import com.example.logisticprogram.mapper.user.UserResponseMapper;
import com.example.logisticprogram.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

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
        List<User> users = new ArrayList<>();
        users.add(new User(1L));
        users.add(new User(2L));

        List<UserResponse> userResponses = new ArrayList<>();
        userResponses.add(new UserResponse());
        userResponses.add(new UserResponse());

        when(userRepository.findAll()).thenReturn(users);
        when(userResponseMapper.from(users)).thenReturn(userResponses);

        List<UserResponse> result = service.getAllUsers();

        assertEquals(userResponses, result);
        assertNotNull(result);
        verify(userRepository).findAll();
        verify(userResponseMapper).from(users);
    }

    @Test
    void deleteUserTest() {

        Long id = 1L;

        service.deleteUser(id);
        verify(userRepository).deleteById(id);
    }

    @Test
    void addUserTest() {
        UserAddRequest userAddRequest = new UserAddRequest();
        User user = new User(1L);
        when(userMapper.from(userAddRequest)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);
        Long id = service.addUser(userAddRequest);
        assertEquals(1L,id);
        verify(userMapper).from(userAddRequest);
        verify(userRepository).save(user);


    }


    private UserResponse getUserResponse(){
        return  new UserResponse()
                .setId(ID);
    }

    private User getUser(){
        return new User(ID);
    }

}
