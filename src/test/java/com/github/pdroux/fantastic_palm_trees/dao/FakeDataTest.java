package com.github.pdroux.fantastic_palm_trees.dao;

import com.github.pdroux.fantastic_palm_trees.model.DataEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class FakeDataTest {
    private FakeData fakeData;
    private final UUID testId = UUID.randomUUID();
    private final DataEntry testEntry = new DataEntry(
            UUID.randomUUID(),
            new Date(),
            "Test Sensor",
            "Temperature",
            25.5f
    );

    @BeforeEach
    void setUp() {
        // Reset the static DB before each test
        FakeData.getFakeDB().clear();
        fakeData = new FakeData();
    }

    @Test
    void shouldInsertNewEntry() {
        // When
        int result = fakeData.insertDataEntry(testId, testEntry);

        // Then
        assertEquals(0, result, "Should return success code 0");

        List<DataEntry> db = fakeData.selectAllData();
        assertEquals(1, db.size(), "DB should contain 1 entry");

        DataEntry storedEntry = db.get(0);
        assertSameEntryContents(testId, testEntry, storedEntry);
    }

    @Test
    void shouldRetrieveEmptyListForEmptyDB() {
        List<DataEntry> result = fakeData.selectAllData();
        assertTrue(result.isEmpty(), "Should return empty list");
    }

    @Test
    void shouldMaintainInsertionOrder() {
        // Given
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        // When
        fakeData.insertDataEntry(id1, testEntry);
        fakeData.insertDataEntry(id2, testEntry);

        // Then
        List<DataEntry> db = fakeData.selectAllData();
        assertEquals(2, db.size(), "Should have 2 entries");
        assertEquals(id1, db.get(0).getId(), "First entry should have first ID");
        assertEquals(id2, db.get(1).getId(), "Second entry should have second ID");
    }

    private void assertSameEntryContents(UUID expectedId, DataEntry expected, DataEntry actual) {
        assertAll("Entry contents",
                () -> assertEquals(expectedId, actual.getId()),
                () -> assertEquals(expected.getName(), actual.getName()),
                () -> assertEquals(expected.getCategory(), actual.getCategory()),
                () -> assertEquals(expected.getValue(), actual.getValue(), 0.001f),
                () -> assertEquals(expected.getTime(), actual.getTime())
        );
    }
}
