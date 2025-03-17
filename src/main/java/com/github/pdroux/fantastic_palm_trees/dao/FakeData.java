package com.github.pdroux.fantastic_palm_trees.dao;

import com.github.pdroux.fantastic_palm_trees.model.DataSet;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository("fakeDao")
public class FakeData implements DataDao {
    private static final Map<String, DataSet> fakeDB = new HashMap<>();

    public static Map<String, DataSet> getFakeDB() {
        return fakeDB;
    }

    public int insertDataSet(DataSet data) {
        if (fakeDB.containsKey(data.name())) {
            return -1;
        }
        fakeDB.put(data.name(), data);

        return 0;
    }

    public Collection<DataSet> selectAllData() {
        return getFakeDB().values();
    }

    public DataSet getDataSet(String name) {
        return fakeDB.get(name);
    }
}
