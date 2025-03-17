package com.github.pdroux.fantastic_palm_trees.api;

import com.github.pdroux.fantastic_palm_trees.model.DataSet;
import com.github.pdroux.fantastic_palm_trees.model.GenerateDataResponse;
import com.github.pdroux.fantastic_palm_trees.model.GenerateParams;
import com.github.pdroux.fantastic_palm_trees.service.DataSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("data")
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
    public Collection<DataSet> selectAllData() {
        return dataService.selectAllData();
    }

    @GetMapping(path = "/{name}")
    public DataSet getDataSetByName(@PathVariable("name") String name) {
        return dataService.getDataSet(name);
    }


    @PostMapping("/generate")
    public GenerateDataResponse generateDataSet(@RequestBody GenerateParams params) {
        return dataService.generateData(params);
    }
}
