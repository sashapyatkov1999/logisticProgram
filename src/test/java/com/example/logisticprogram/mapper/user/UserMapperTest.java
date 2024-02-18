package com.example.logisticprogram.mapper.user;

import com.example.logisticprogram.dto.request.user.UserAddRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserMapperTest {
    @InjectMocks
    private UserMapper mapper;

    private static final Long USER_STATUS_ID = 1L;
    private static final String NAME = "NAME";
    private static final String SURNAME = "SURNAME";
    private static final String PHONE_NUMBER = "8919883832";

    @Test
    void from(){
        var source = spy(source());
        var result = mapper.from(source);

        assertThat(result.getId()).isNull();
        assertThat(result.getStatus().getId()).isEqualTo(USER_STATUS_ID);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getSurname()).isEqualTo(SURNAME);
        assertThat(result.getPhoneNumber()).isEqualTo(PHONE_NUMBER);

        verify(source).getUserStatusId();
        verify(source).getName();
        verify(source).getSurname();
        verify(source).getPhoneNumber();
        verifyNoMoreInteractions(source);
    }

    @Test
    void fromList(){
        var source = spy(source());
        var resultList = mapper.from(List.of(source, source, source));

        assertThat(resultList).isNotEmpty();

        var result = resultList.get(0);

        assertThat(result.getId()).isNull();
        assertThat(result.getStatus().getId()).isEqualTo(USER_STATUS_ID);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getSurname()).isEqualTo(SURNAME);
        assertThat(result.getPhoneNumber()).isEqualTo(PHONE_NUMBER);

        verify(source,times(3)).getUserStatusId();
        verify(source,times(3)).getName();
        verify(source,times(3)).getSurname();
        verify(source,times(3)).getPhoneNumber();
        verifyNoMoreInteractions(source);
    }

    private UserAddRequest source(){
        return new UserAddRequest()
                .setUserStatusId(USER_STATUS_ID)
                .setName(NAME)
                .setSurname(SURNAME)
                .setPhoneNumber(PHONE_NUMBER);
    }

}
