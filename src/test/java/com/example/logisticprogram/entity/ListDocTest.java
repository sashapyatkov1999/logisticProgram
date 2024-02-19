package com.example.logisticprogram.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class ListDocTest extends BaseEntityTest {
    private static final Long ID = 0L;
    private static final Long APPLICATION_ID = 1L;
    private static final Long TYPE_DOC_ID = 2L;
    private static final Long POINT_ID = 3L;
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(1);

    @BeforeAll
    void init () throws ClassNotFoundException {
        checkNumFields(6);
    }

    @Test
    void testNoArgsConstructor() {
        var result = getListDoc();

        assertThat(result.getId()).isEqualTo(ID);
        assertThat(result.getPoint().getId()).isEqualTo(POINT_ID);
        assertThat(result.getApplication().getId()).isEqualTo(APPLICATION_ID);
        assertThat(result.getTypeDoc().getId()).isEqualTo(TYPE_DOC_ID);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);
    }

    private ListDoc getListDoc(){
        return new ListDoc()
                .setId(ID)
                .setPoint(new Point().setId(POINT_ID))
                .setApplication(new Application().setId(APPLICATION_ID))
                .setTypeDoc(new TypeDoc().setId(TYPE_DOC_ID))
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }
    }
