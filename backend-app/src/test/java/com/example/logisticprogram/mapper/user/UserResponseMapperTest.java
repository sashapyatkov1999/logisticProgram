package com.example.logisticprogram.mapper.user;

import com.example.logisticprogram.entity.User;
import com.example.logisticprogram.entity.UserStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserResponseMapperTest {
    @InjectMocks
    private UserResponseMapper mapper;

    private final Long ID = 0L;
    private static final String STATUS = "STATUS";
    private static final String LOGIN = "LOGIN";
    private static final String PASSWORD = "PASSWORD";
    private static final String E_MAIL = "E-MAIL";
    private static final String NAME = "NAME";
    private static final String SURNAME = "SURNAME";
    private static final String PHONE_NUMBER = "8919883832";
    private final LocalDateTime CREATED = LocalDateTime.now();
    private final LocalDateTime MODIFIED = LocalDateTime.now();

    @Test
    void from(){
        var source = spy(source());
        var result = mapper.from(source);

        assertThat(result.getId()).isEqualTo(ID);
        assertThat(result.getUserStatus()).isEqualTo(STATUS);
        assertThat(result.getLogin()).isEqualTo(LOGIN);
        assertThat(result.getPassword()).isEqualTo(PASSWORD);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getSurname()).isEqualTo(SURNAME);
        assertThat(result.getEMail()).isEqualTo(E_MAIL);
        assertThat(result.getPhoneNumber()).isEqualTo(PHONE_NUMBER);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);

        verify(source).getId();
        verify(source).getStatus();
        verify(source).getLogin();
        verify(source).getPassword();
        verify(source).getName();
        verify(source).getSurname();
        verify(source).getEmail();
        verify(source).getPhoneNumber();
        verify(source).getCreated();
        verify(source).getModified();
        verifyNoMoreInteractions(source);
    }

    @Test
    void fromList(){
        var source = spy(source());
        var resultList = mapper.from(List.of(source, source, source));

        assertThat(resultList).isNotEmpty();

        var result = resultList.get(0);

        assertThat(result.getId()).isEqualTo(ID);
        assertThat(result.getUserStatus()).isEqualTo(STATUS);
        assertThat(result.getLogin()).isEqualTo(LOGIN);
        assertThat(result.getPassword()).isEqualTo(PASSWORD);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getSurname()).isEqualTo(SURNAME);
        assertThat(result.getEMail()).isEqualTo(E_MAIL);
        assertThat(result.getPhoneNumber()).isEqualTo(PHONE_NUMBER);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);

        verify(source,times(3)).getId();
        verify(source,times(3)).getStatus();
        verify(source,times(3)).getLogin();
        verify(source,times(3)).getPassword();
        verify(source,times(3)).getName();
        verify(source,times(3)).getSurname();
        verify(source,times(3)).getEmail();
        verify(source,times(3)).getPhoneNumber();
        verify(source,times(3)).getCreated();
        verify(source,times(3)).getModified();
        verifyNoMoreInteractions(source);
    }
    private User source(){
        return new User()
                .setId(ID)
                .setStatus(new UserStatus().setName(STATUS))
                .setLogin(LOGIN)
                .setPassword(PASSWORD)
                .setName(NAME)
                .setSurname(SURNAME)
                .setEmail(E_MAIL)
                .setPhoneNumber(PHONE_NUMBER)
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }
}
