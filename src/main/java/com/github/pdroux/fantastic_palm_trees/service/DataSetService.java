package com.github.pdroux.fantastic_palm_trees.service;

import com.github.pdroux.fantastic_palm_trees.dao.DataDao;
import com.github.pdroux.fantastic_palm_trees.generator.GeneratorFactory;
import com.github.pdroux.fantastic_palm_trees.model.DataSet;
import com.github.pdroux.fantastic_palm_trees.model.GenerateDataResponse;
import com.github.pdroux.fantastic_palm_trees.model.GenerateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

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

    public Collection<DataSet> selectAllData() {
        return dataDao.selectAllData();
    }

    public DataSet getDataSet(String name) {
        return dataDao.getDataSet(name);
    }

    public GenerateDataResponse generateData(GenerateParams params) {
        DataSet set = GeneratorFactory.createGenerator(params).createDataSet();

        int response = dataDao.addDataSet(set);

        if (response != 0) {
            return new GenerateDataResponse("Duplicate DataSet", 0);
        }

        String message = String.format("Successfully added %s dataset", set.name());

        return new GenerateDataResponse(
                message,
                set.data().size()
        );
    }
}
