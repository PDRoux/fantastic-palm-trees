package com.github.pdroux.fantastic_palm_trees.service;

import com.github.pdroux.fantastic_palm_trees.dao.DataDao;
import com.github.pdroux.fantastic_palm_trees.model.DataEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataEntryService {
    private final DataDao dataDao;

    @Autowired
    public DataEntryService(@Qualifier("fakeDao") DataDao dataDao) {
        this.dataDao = dataDao;
    }

    public int addDataEntry(DataEntry data) {
        if(data == null) {
            return -1;
        }

        return dataDao.addDataEntry(data);
    }

    public List<DataEntry> selectAllData() {
        return dataDao.selectAllData();
    }
}
