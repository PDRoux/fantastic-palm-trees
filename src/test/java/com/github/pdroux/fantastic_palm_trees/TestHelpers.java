package com.github.pdroux.fantastic_palm_trees;

import com.github.pdroux.fantastic_palm_trees.model.DataEntry;
import com.github.pdroux.fantastic_palm_trees.model.DataSet;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class TestHelpers {
    public static final DataEntry testEntry = createEntry("TestCategory", 25.5f);
    public static final DataSet testSet = new DataSet("TestName", List.of(testEntry));
    public static final Set<DataSet> expectedDB = Set.of(testSet);

    // Test DataEntry factory method for readability
    public static DataEntry createEntry(String category, float value) {
        return new DataEntry(
                new Date(),
                category,
                value
        );
    }
}
