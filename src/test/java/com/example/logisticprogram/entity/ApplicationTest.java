package com.example.logisticprogram.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends BaseEntityTest{
    private static final Long ID = 0L;
    private static final Long MANAGER_ID = 1L;
    private static final Long DRIVER_ID = 2L;
    private static final Long CLIENT_ID = 3L;
    private static final Long LIST_DOC_ID = 3L;
    private static final Long POINT_ID = 3L;
    private static final String NAME = "NAME";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(1);

    @BeforeAll
    void init () throws ClassNotFoundException {
        checkNumFields(10);
    }

    @Test
    void testNoArgsConstructor(){
        var result = getApplication();

        assertThat(result.getId()).isEqualTo(ID);
        assertThat(result.getManager().getId()).isEqualTo(MANAGER_ID);
        assertThat(result.getDriver().getId()).isEqualTo(DRIVER_ID);
        assertThat(result.getClient().getId()).isEqualTo(CLIENT_ID);
        assertThat(result.getListDocs().getId()).isEqualTo(LIST_DOC_ID);
        assertThat(result.getPoint().getId()).isEqualTo(POINT_ID);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);
    }

    private Application getApplication(){
        return new Application()
                .setId(ID)
                .setManager(new User().setId(MANAGER_ID))
                .setDriver(new Driver().setId(DRIVER_ID))
                .setClient(new User().setId(CLIENT_ID))
                .setListDocs(new ListDoc().setId(LIST_DOC_ID))
                .setPoint(new Point().setId(POINT_ID))
                .setName(NAME)
                .setDescription(DESCRIPTION)
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }
}
