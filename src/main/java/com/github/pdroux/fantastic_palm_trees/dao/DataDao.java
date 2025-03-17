package com.github.pdroux.fantastic_palm_trees.dao;

import com.github.pdroux.fantastic_palm_trees.model.DataSet;

import java.util.Collection;

public interface DataDao {
    int insertDataSet(DataSet data);

    default int addDataSet(DataSet data) {
        return insertDataSet(data);
    }

    Collection<DataSet> selectAllData();

    DataSet getDataSet(String name);
}
