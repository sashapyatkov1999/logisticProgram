package com.example.logisticprogram.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RoleTest extends BaseEntityTest {

    private static final Long ID = 0L;
    private static final String NAME = "NAME";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(1);

    @BeforeAll
    void init () throws ClassNotFoundException {
        checkNumFields(5);
    }

    @Test
    void testConstructor() {
        assertThat(new Role(ID).getId()).isEqualTo(ID);
    }
    @Test
    void testNoArgsConstructor(){

        var result = getRole();

        assertEquals(ID, result.getId());
        assertEquals(NAME, result.getName());
        assertEquals(DESCRIPTION, result.getDescription());
        assertEquals(CREATED, result.getCreated());
        assertEquals(MODIFIED, result.getModified());

    }



    private Role getRole() {
    return new Role()
            .setId(ID)
            .setName(NAME)
            .setDescription(DESCRIPTION)
            .setCreated(CREATED)
            .setModified(MODIFIED);


    }

}
