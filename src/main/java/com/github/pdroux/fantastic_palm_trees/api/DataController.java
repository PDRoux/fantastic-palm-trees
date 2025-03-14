package com.github.pdroux.fantastic_palm_trees.api;

import com.github.pdroux.fantastic_palm_trees.model.DataEntry;
import com.github.pdroux.fantastic_palm_trees.service.DataEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("v1/data")
@RestController
public class DataController {
    private final DataEntryService dataService;

    @Autowired
    public DataController(DataEntryService dataService) {
        this.dataService = dataService;
    }

    @PostMapping
    public void addDataEntry(@RequestBody DataEntry data) {
        dataService.addDataEntry(data);
    }

    @GetMapping
    public List<DataEntry> selectAllData() {
        return dataService.selectAllData();
    }
}
