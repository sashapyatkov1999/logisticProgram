package com.example.logisticprogram.entity;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseEntityTest {

    @BeforeAll
    protected void initTests() throws ClassNotFoundException, NoSuchMethodException {
        checkLongConstructor();
    }


    protected void checkLongConstructor() throws ClassNotFoundException, NoSuchMethodException {

        Class<?> clazz = Class.forName(this.getClass().getName().replace("Test", ""));

        var longConstructor = clazz.getDeclaredConstructor(Long.class);
        assertNotNull(longConstructor);

    }


    protected void checkNumFields(int numFields) throws ClassNotFoundException {

        Class<?> clazz = Class.forName(this.getClass().getName().replace("Test", ""));
        assertEquals(numFields, getAllClassField(clazz).size());
    }

    private List<Field> getAllClassField(Class<?> clazz) {

        var fields = new ArrayList<Field>();

        AtomicBoolean isSuperClass = new AtomicBoolean(false);


        while (clazz.getSuperclass() != null) {

            fields.addAll(
                    Arrays.stream(clazz.getDeclaredFields())
                            .filter(field -> !isSuperClass.get() || Modifier.isPublic(field.getModifiers()) || Modifier.isProtected(field.getModifiers()))
                            .filter(field -> !Modifier.isStatic(field.getModifiers()))
                            .toList());

            clazz = clazz.getSuperclass();
            isSuperClass.set(true);

        }

        return fields;
    }


}
