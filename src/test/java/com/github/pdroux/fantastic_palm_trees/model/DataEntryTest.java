package com.github.pdroux.fantastic_palm_trees.model;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataEntryTest {
    @Test
    public void testConstructorWithDataEntry() {
        DataEntry original = new DataEntry(UUID.randomUUID(), new Date(), "Sensor1", "Temperature", 25.5f);
        UUID newId = UUID.randomUUID();
        DataEntry copy = new DataEntry(newId, original);

        assertEquals(newId, copy.getId());
        assertEquals(original.getTime(), copy.getTime());
        assertEquals(original.getName(), copy.getName());
        assertEquals(original.getCategory(), copy.getCategory());
        assertEquals(original.getValue(), copy.getValue(), 0.001f);
    }

}
