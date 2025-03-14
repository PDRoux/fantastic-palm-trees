package com.github.pdroux.fantastic_palm_trees.service;

import com.github.pdroux.fantastic_palm_trees.dao.DataDao;
import com.github.pdroux.fantastic_palm_trees.model.DataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DataSetService {
    private final DataDao dataDao;

    @Autowired
    public DataSetService(@Qualifier("fakeDao") DataDao dataDao) {
        this.dataDao = dataDao;
    }

    public int addDataSet(DataSet data) {
        if (data == null) {
            return -1;
        }

        return dataDao.addDataSet(data);
    }

    public Set<DataSet> selectAllData() {
        return dataDao.selectAllData();
    }
}
