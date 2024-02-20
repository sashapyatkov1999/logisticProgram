package com.example.logisticprogram.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class UserRoleTest extends BaseEntityTest {
    private static final Long ID = 0L;
    private static final Long USER_ID = 1L;
    private static final Long ROLE_ID= 2L;
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(1);
    @BeforeAll
    void init() throws ClassNotFoundException {
        checkNumFields(5);
    }

    @Test
    void testNoArgsConstructor() {

        var result = getUserRole();

        assertThat(result.getRole().getId()).isEqualTo(ROLE_ID);
        assertThat(result.getUser().getId()).isEqualTo(USER_ID);
        assertThat(result.created).isEqualTo(CREATED);
        assertThat(result.modified).isEqualTo(MODIFIED);

    }
    private UserRole getUserRole(){
        return new UserRole()
                .setRole(new Role().setId(ROLE_ID))
                .setUser(new User().setId(USER_ID))
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }

}
