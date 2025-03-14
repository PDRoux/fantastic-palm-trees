package com.github.pdroux.fantastic_palm_trees.api;

import com.github.pdroux.fantastic_palm_trees.model.DataSet;
import com.github.pdroux.fantastic_palm_trees.service.DataSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping("v1/data")
@RestController
public class DataController {
    private final DataSetService dataService;

    @Autowired
    public DataController(DataSetService dataService) {
        this.dataService = dataService;
    }

    @PostMapping
    public void addDataSet(@RequestBody DataSet data) {
        dataService.addDataSet(data);
    }

    @GetMapping
    public Set<DataSet> selectAllData() {
        return dataService.selectAllData();
    }
}
