package com.github.pdroux.fantastic_palm_trees.dao;

import com.github.pdroux.fantastic_palm_trees.model.DataSet;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("fakeDao")
public class FakeData implements DataDao {
    private static Set<DataSet> FakeDB = new HashSet<>();

    public static Set<DataSet> getFakeDB() {
        return FakeDB;
    }

    public int insertDataSet(DataSet data) {
        if (FakeDB.contains(data)) {
            return -1;
        }
        FakeDB.add(data);

        return 0;
    }

    public Set<DataSet> selectAllData() {
        return getFakeDB();
    }
}
