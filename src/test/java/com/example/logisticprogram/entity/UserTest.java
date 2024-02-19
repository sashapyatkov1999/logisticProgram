package com.example.logisticprogram.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest extends BaseEntityTest {
    private static final Long ID = 0L;
    private static final String LOGIN = "LOGIN";
    private static final String PASSWORD = "PASSWORD";
    private static final Long USER_STATUS_ID = 2L;
    private static final String NAME = "NAME";
    private static final String SURNAME = "SURNAME";
    private static final String PHONE_NUMBER = "PHONE_NUMBER";
    private static final String E_MAIL = "E_MAIL";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(1);

    @BeforeAll
    void init () throws ClassNotFoundException {
        checkNumFields(10);
    }

    @Test
    void testNoArgsConstructor() {
        var result = getUser();

        assertThat(result.getId()).isEqualTo(ID);
        assertThat(result.getLogin()).isEqualTo(LOGIN);
        assertThat(result.getPassword()).isEqualTo(PASSWORD);
        assertThat(result.getStatus().getId()).isEqualTo(USER_STATUS_ID);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getSurname()).isEqualTo(SURNAME);
        assertThat(result.getEmail()).isEqualTo(E_MAIL);
        assertThat(result.getPhoneNumber()).isEqualTo(PHONE_NUMBER);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);

    }

    private User getUser(){
        return new User()
                .setId(ID)
                .setLogin(LOGIN)
                .setPassword(PASSWORD)
                .setStatus(new UserStatus().setId(USER_STATUS_ID))
                .setName(NAME)
                .setSurname(SURNAME)
                .setEmail(E_MAIL)
                .setPhoneNumber(PHONE_NUMBER)
                .setCreated(CREATED)
                .setModified(MODIFIED);

    }
}
