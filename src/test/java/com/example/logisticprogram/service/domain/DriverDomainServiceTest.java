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
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class DriverDomainServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserResponseMapper userResponseMapper;
    @Mock
    private UserMapper userMapper;
    @InjectMocks
    private UserDomainService service;

    private final UserAddRequest userAddRequestAdd = new UserAddRequest();
    private final List<User> users = new ArrayList<>();
    private final User userAdd = new User(1L);
    private final List<UserResponse> userResponses = new ArrayList<>();
    private final Long ID = 0L;
    private final Long id = 1L;



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
        users.add(new User(1L));
        users.add(new User(2L));
        userResponses.add(new UserResponse());
        userResponses.add(new UserResponse());

        when(userRepository.findAll()).thenReturn(users);
        when(userResponseMapper.from(users)).thenReturn(userResponses);

        List<UserResponse> result = service.getAllUsers();

        assertEquals(userResponses, result);
        assertNotNull(result);
        verify(userRepository).findAll();
        verify(userResponseMapper).from(users);

        verifyNoMoreInteractions(userRepository, userResponseMapper);
        verifyNoInteractions(userMapper);
    }

    @Test
    void deleteUserTest() {
        service.deleteUser(id);
        verify(userRepository).deleteById(id);

        verifyNoMoreInteractions(userRepository, userResponseMapper);
        verifyNoInteractions(userMapper);
    }

    @Test
    void addUserTest() {
        when(userMapper.from(userAddRequestAdd)).thenReturn(userAdd);
        when(userRepository.save(userAdd)).thenReturn(userAdd);
        Long id = service.addUser(userAddRequestAdd);
        assertEquals(userAdd.getId(),id.longValue());
        verify(userMapper).from(userAddRequestAdd);
        verify(userRepository).save(userAdd);
        verifyNoMoreInteractions(userRepository, userResponseMapper);
    }

    private UserResponse getUserResponse(){
        return  new UserResponse()
                .setId(ID);
    }

    private User getUser(){
        return new User(ID);
    }

}

