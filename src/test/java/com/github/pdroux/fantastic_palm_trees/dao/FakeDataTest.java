package com.github.pdroux.fantastic_palm_trees.dao;

import com.github.pdroux.fantastic_palm_trees.model.DataSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static com.github.pdroux.fantastic_palm_trees.TestHelpers.testSet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FakeDataTest {
    private FakeData fakeData;

    @BeforeEach
    void setUp() {
        // Reset the static DB before each test
        FakeData.getFakeDB().clear();
        fakeData = new FakeData();
    }

    @Test
    void shouldInsertNewEntry() {
        fakeData.insertDataSet(testSet);

        Collection<DataSet> db = fakeData.selectAllData();
        assertEquals(1, db.size(), "DB should contain 1 entry");

        DataSet actualSet = db.iterator().next();
        assertEquals(testSet, actualSet);
    }

    @Test
    void shouldRetrieveEmptyListForEmptyDB() {
        Collection<DataSet> result = fakeData.selectAllData();
        assertTrue(result.isEmpty(), "Should return empty list");
    }
}
