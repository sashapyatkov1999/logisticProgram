package com.example.logisticprogram.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class TypeDocTest extends BaseEntityTest{
    private static final Long ID = 0L;
    private static final String NAME = "NAME";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(1);
    @BeforeAll
    void init() throws ClassNotFoundException {
        checkNumFields(5);
    }
    @Test
    void testConstructor() {
        assertThat(new TypeDoc(ID).getId()).isEqualTo(ID);
    }

    @Test
    void testNoArgsConstructor(){

        var result = getApplicationClient();

        assertThat(result.getId()).isEqualTo(ID);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);

    }

    private TypeDoc getApplicationClient() {
        return new TypeDoc()
                .setId(ID)
                .setName(NAME)
                .setDescription(DESCRIPTION)
                .setCreated(CREATED)
                .setModified(MODIFIED);


    }
}
