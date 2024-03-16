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
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
    void getUserTest(){

        when(userResponseMapper.from(any(User.class))).thenReturn(getUserResponse());
        when(userRepository.getReferenceById(anyLong())).thenReturn(getUser());

        var result = service.getUser(ID);

        assertNotNull(result);

        verify(userRepository).getReferenceById(anyLong());
        verify(userResponseMapper).from((any(User.class)));
        verifyNoMoreInteractions(userRepository, userResponseMapper);
        verifyNoInteractions(userMapper);
    }

    @Test
    void getAllUsersTest(){
        when(userRepository.findAll()).thenReturn(Collections.singletonList(getUser()));
        when(userResponseMapper.from(anyList())).thenReturn(Collections.singletonList(getUserResponse()));

        List<UserResponse> result = service.getAllUsers();

        assertThat(result).isNotNull();

        verify(userRepository).findAll();
        verify(userResponseMapper).from(anyList());


        verifyNoMoreInteractions(userRepository, userResponseMapper);
        verifyNoInteractions(userMapper);
    }

    @Test
    void  deleteUserTest(){
        service.deleteUser(ID);

        verify(userRepository).deleteById(ID);
        verifyNoMoreInteractions(userRepository, userResponseMapper);
        verifyNoInteractions(userMapper);
    }

    @Test
    void addUserTest() {

        when(userMapper.from(any(UserAddRequest.class))).thenReturn(getUser());
        when(userRepository.save(any())).thenReturn(getUser());


        Long id = service.addUser(userAddRequestAdd());

        assertThat(id).isEqualTo(ID);

        verify(userMapper).from(any(UserAddRequest.class));
        verify(userRepository).save(any());
        verifyNoMoreInteractions(userRepository, userResponseMapper);
    }

    private UserResponse getUserResponse(){
        return new UserResponse().setId(ID);
    }


    private User getUser(){return new User(ID);}

    private UserAddRequest userAddRequestAdd(){
        return  new UserAddRequest().setUserId(ID);
    }
}
