package com.github.pdroux.fantastic_palm_trees;

import com.github.pdroux.fantastic_palm_trees.model.DataEntry;
import com.github.pdroux.fantastic_palm_trees.model.DataSet;

import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHelpers {
    public static final DataEntry testEntry = createEntry("TestCategory", 25.5f);
    public static final DataSet testSet = new DataSet("TestName", List.of(testEntry));
    public static final Set<DataSet> expectedDB = Set.of(testSet);

    public static DataEntry createEntry(String category, double value) {
        return new DataEntry(
                new Date(),
                category,
                value
        );
    }

    public static void assertDataEntry(
            Date expectedDate,
            String expectedCategory,
            double expectedValue,
            DataEntry actualEntry
    ) {
        assertEquals(expectedDate, actualEntry.time());
        assertEquals(expectedCategory, actualEntry.category());
        assertEquals(expectedValue, actualEntry.value(), 0.001f);
    }
}
