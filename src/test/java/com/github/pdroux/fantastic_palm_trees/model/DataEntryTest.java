package com.github.pdroux.fantastic_palm_trees.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataEntryTest {
    @Test
    public void testConstructorWithDataEntry() {
        Date date = new Date();
        DataEntry actual = new DataEntry(date, "Cape Town", 25.5f);

        assertEquals(date, actual.time());
        assertEquals("Cape Town", actual.category());
        assertEquals(25.5f, actual.value());
    }
}
