package com.github.pdroux.fantastic_palm_trees.dao;

import com.github.pdroux.fantastic_palm_trees.model.DataEntry;

import java.util.List;
import java.util.UUID;

public interface DataDao {
    int insertDataEntry(UUID id, DataEntry data);

    default int addDataEntry(DataEntry data) {
        UUID id = UUID.randomUUID();

        return insertDataEntry(id, data);
    }

    List<DataEntry> selectAllData();
}
