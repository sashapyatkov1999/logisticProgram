package com.example.logisticprogram.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest extends BaseEntityTest {
    private static final Long ID = 0L;
    private static final String FIELD = "FIELD";
    private static final Long ORDINAL = 2L;
    private static final Long APPLICATION_ID = 3L;
    private static final Boolean STATUS_OF_ORDINAL_WITH_GEO = true;
    private static final String NAME = "NAME";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(1);
    private static final LocalDateTime TIME_START = LocalDateTime.now();
    private static final LocalDateTime TIME_END = LocalDateTime.now();

    @BeforeAll
    void init () throws ClassNotFoundException {
        checkNumFields(11);
    }

    @Test
    void testNoArgsConstructor() {
        var result = getPoint();

        assertThat(result.getId()).isEqualTo(ID);
        assertThat(result.getField()).isEqualTo(FIELD);
        assertThat(result.getOrdinal()).isEqualTo(ORDINAL);
        assertThat(result.getApplication().getId()).isEqualTo(APPLICATION_ID);
        assertThat(result.getStatusOfOrdinalWithGeo()).isEqualTo(STATUS_OF_ORDINAL_WITH_GEO);
        assertThat(result.getName()).isEqualTo(NAME);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(result.getCreated()).isEqualTo(CREATED);
        assertThat(result.getModified()).isEqualTo(MODIFIED);
        assertThat(result.getTimeStart()).isEqualTo(TIME_START);
        assertThat(result.getTimeEnd()).isEqualTo(TIME_END);
    }

    private Point getPoint(){
        return new Point()
                .setId(ID)
                .setField(FIELD)
                .setOrdinal(ORDINAL)
                .setApplication(new Application(APPLICATION_ID))
                .setStatusOfOrdinalWithGeo(STATUS_OF_ORDINAL_WITH_GEO)
                .setName(NAME)
                .setDescription(DESCRIPTION)
                .setCreated(CREATED)
                .setModified(MODIFIED)
                .setTimeStart(TIME_START)
                .setTimeEnd(TIME_END);
    }
    }
