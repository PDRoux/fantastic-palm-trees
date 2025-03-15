package com.github.pdroux.fantastic_palm_trees.generator;

import com.github.pdroux.fantastic_palm_trees.generator.scheduler.RateScheduler;
import com.github.pdroux.fantastic_palm_trees.model.DataSet;

import java.util.Date;

public interface SetGenerator {
    public DataSet createDataSet(String name, Date end, RateScheduler scheduler);
}
