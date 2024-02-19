package com.example.logisticprogram.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class FileTest extends BaseEntityTest {
    private static final Long ID = 0L;
    private static final Long POINT_ID = 3L;
    private static final Long USER_ID = 1L;
    private static final Long APPLICATION_ID = 2L;
    private static final String NAME = "NAME";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(1);

    @BeforeAll
    void init() throws ClassNotFoundException {
        checkNumFields(8);
    }

    @Test
    void testNoArgsConstructor() {

        var result = getFile();

        assertThat(result.getId()).isEqualTo(ID);
        assertThat(result.getPoint().getId()).isEqualTo(POINT_ID);
        assertThat(result.getApplication().getId()).isEqualTo(APPLICATION_ID);
        assertThat(result.getUser().getId()).isEqualTo(USER_ID);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);


    }
    private File getFile(){
        return new File()
                .setId(ID)
                .setPoint(new Point().setId(POINT_ID))
                .setApplication(new Application().setId(APPLICATION_ID))
                .setUser(new User().setId(USER_ID))
                .setName(NAME)
                .setDescription(DESCRIPTION)
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }
}
