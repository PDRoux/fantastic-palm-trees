package com.github.pdroux.fantastic_palm_trees.dao;

import com.github.pdroux.fantastic_palm_trees.model.DataSet;

import java.util.Set;

public interface DataDao {
    int insertDataSet(DataSet data);

    default int addDataSet(DataSet data) {
        return insertDataSet(data);
    }

    Set<DataSet> selectAllData();
}
