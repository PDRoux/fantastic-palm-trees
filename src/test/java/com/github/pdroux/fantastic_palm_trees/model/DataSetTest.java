package com.github.pdroux.fantastic_palm_trees.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.github.pdroux.fantastic_palm_trees.TestHelpers.createEntry;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DataSetTest {
    @Test
    void constructorAndGetters_ReturnCorrectValues() {
        String expectedName = "Temperature Data";
        List<DataEntry> expectedData = List.of(
                createEntry("Temp", 25.5f),
                createEntry("Temp", 26.0f)
        );
        DataSet dataSet = new DataSet(expectedName, expectedData);

        assertEquals(expectedName, dataSet.name());
        assertEquals(expectedData, dataSet.data());
    }

    @Test
    void equals_ReturnsTrue_WhenNamesMatch() {
        DataSet set1 = new DataSet("Dataset", List.of(createEntry("A", 1.0f)));
        DataSet set2 = new DataSet("Dataset", List.of(createEntry("B", 2.0f)));

        assertEquals(set1, set2);
        assertEquals(set2, set1);
    }

    @Test
    void equals_ReturnsFalse_WhenNamesDiffer() {
        DataSet set1 = new DataSet("A", List.of());
        DataSet set2 = new DataSet("B", List.of());

        assertNotEquals(set1, set2);
    }

    @Test
    void equals_ReturnsFalse_WhenComparingWithNull() {
        DataSet set = new DataSet("Dataset", List.of());

        assertNotEquals(null, set);
    }

    @Test
    void equals_ReturnsFalse_WhenComparingWithDifferentClass() {
        DataSet set = new DataSet("Dataset", List.of());
        String other = "Not a DataSet";

        assertNotEquals(set, other);
    }

    @Test
    void hashCode_ConsistentWithEquals() {
        DataSet set1 = new DataSet("Dataset", List.of(createEntry("A", 1.0f)));
        DataSet set2 = new DataSet("Dataset", List.of(createEntry("B", 2.0f)));
        DataSet set3 = new DataSet("Different", List.of());

        assertEquals(set1.hashCode(), set2.hashCode());
        assertNotEquals(set1.hashCode(), set3.hashCode());
    }

    @Test
    void equals_HandlesNullNames() {
        DataSet null1 = new DataSet(null, List.of());
        DataSet null2 = new DataSet(null, List.of());
        DataSet named = new DataSet("Dataset", List.of());

        assertEquals(null1, null2);
        assertNotEquals(null1, named);
    }

    @Test
    void equals_IgnoresDataContent() {
        List<DataEntry> data1 = List.of(createEntry("A", 1.0f));
        List<DataEntry> data2 = List.of(createEntry("B", 2.0f));
        DataSet set1 = new DataSet("Dataset", data1);
        DataSet set2 = new DataSet("Dataset", data2);

        assertEquals(set1, set2);
    }
}
