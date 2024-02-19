package com.example.logisticprogram.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest extends BaseEntityTest{
    private static final Long ID = 0L;
    private static final String TRAILER_NUMBER = "ABC123";
    private static final String CAR_NUMBER = "ABC123";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(1);

    @BeforeAll
    void init () throws ClassNotFoundException {
        checkNumFields(5);
    }

    @Test
    void testNoArgsConstructor(){

        var result = getCar();

        assertEquals(ID, result.getId());
        assertEquals(CAR_NUMBER, result.getCarNumber());
        assertEquals(TRAILER_NUMBER, result.getTrailerNumber());
        assertEquals(CREATED, result.getCreated());
        assertEquals(MODIFIED, result.getModified());

    }


    private Car getCar() {
        return new Car()
                .setId(ID)
                .setCarNumber(CAR_NUMBER)
                .setTrailerNumber(TRAILER_NUMBER)
                .setCreated(CREATED)
                .setModified(MODIFIED);


    }
}
