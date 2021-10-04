package com.example.birthdayreminder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class birthdayCalendarTest {
    birthdayCalendar cl;
    @BeforeEach
    void setUp() {
        cl = new birthdayCalendar(new File("src/main/resources/calendar.txt"));

    }
    @Test
    void checkToday() throws FileNotFoundException {
        assertEquals(cl.checkToday(), "Маша");

    }

    @Test
    void writing() throws FileNotFoundException {
        cl= Mockito.mock(birthdayCalendar.class);

        when(cl.writing("Петя 14-10-1993")).thenReturn(true);
        assertTrue(cl.writing("Петя 14-10-1993"));
    }

    @Test
    void getAll() {
        assertTrue(cl.getAll());
    }
}