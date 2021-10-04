package com.example.birthdayreminder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class birthdayCalendarTest {
    birthdayCalendar cl;
    @BeforeEach
    void setUp() {
        cl = new birthdayCalendar(new File("src/main/resources/calendar.txt"));

    }
    @Test
    void checkToday() {
        assertEquals(cl.checkToday(), "Маша");

    }

    @Test
    void writing() {
        assertTrue(cl.writing("Петя 14-10-1993"));
    }

    @Test
    void getAll() {
        assertTrue(cl.getAll());
    }
}