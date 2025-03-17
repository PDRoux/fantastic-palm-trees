package com.github.pdroux.fantastic_palm_trees.service;

import com.github.pdroux.fantastic_palm_trees.dao.DataDao;
import com.github.pdroux.fantastic_palm_trees.dao.InvalidDataSet;
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

    public void addDataSet(DataSet data) {
        if (data == null) {
            throw new InvalidDataSet(
                    "DataSet cannot be null"
            );
        }

        dataDao.insertDataSet(data);
    }

    public Collection<DataSet> selectAllData() {
        return dataDao.selectAllData();
    }

    public DataSet getDataSet(String name) {
        DataSet set = dataDao.getDataSet(name);

        if (set == null) {
            throw new DataSetNotFoundException(
                    "data set not found: %s".formatted(name)
            );
        }

        return set;
    }

    public GenerateDataResponse generateData(GenerateParams params) {
        DataSet set = GeneratorFactory.createGenerator(params).createDataSet();

        dataDao.insertDataSet(set);

        String message = String.format("Successfully added %s dataset", set.name());

        return new GenerateDataResponse(
                message,
                set.data().size()
        );
    }
}
