package com.github.pdroux.fantastic_palm_trees.dao;

import com.github.pdroux.fantastic_palm_trees.model.DataEntry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakeData implements DataDao {
    private static List<DataEntry> FakeDB = new ArrayList<>();

    public int insertDataEntry(UUID id, DataEntry data) {
        FakeDB.add(new DataEntry(id, data));

        return 0;
    }

    public List<DataEntry> selectAllData() {
        return getFakeDB();
    }

    public static List<DataEntry> getFakeDB() {
        return FakeDB;
    }
}
