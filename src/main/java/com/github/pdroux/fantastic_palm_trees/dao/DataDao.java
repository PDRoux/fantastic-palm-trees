package com.github.pdroux.fantastic_palm_trees.dao;

import com.github.pdroux.fantastic_palm_trees.model.DataSet;

import java.util.Collection;

public interface DataDao {
    void insertDataSet(DataSet data);

    Collection<DataSet> selectAllData();

    DataSet getDataSet(String name);

    Collection<String> getNames();
}
