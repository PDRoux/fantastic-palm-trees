package com.github.pdroux.fantastic_palm_trees.generator;

import com.github.pdroux.fantastic_palm_trees.generator.populator.CategoryPopulator;
import com.github.pdroux.fantastic_palm_trees.generator.sampler.DistributionSampler;
import com.github.pdroux.fantastic_palm_trees.generator.scheduler.IntervalScheduler;
import com.github.pdroux.fantastic_palm_trees.model.DataEntry;
import com.github.pdroux.fantastic_palm_trees.model.DataSet;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class DistributionGenerator implements SetGenerator {
    private final DistributionSampler sampler;
    private final CategoryPopulator populator;

    public DistributionGenerator(DistributionSampler sampler, CategoryPopulator populator) {
        this.sampler = sampler;
        this.populator = populator;
    }

    public DataSet createDataSet(String name, Date end, IntervalScheduler scheduler) {
        List<DataEntry> entries = generateEntries(end, scheduler);
        return new DataSet(name, entries);
    }

    private List<DataEntry> generateEntries(Date end, IntervalScheduler scheduler) {
        return Stream.generate(scheduler::nextEventTime)
                .takeWhile(current -> isValidEvent(current, end))
                .map(this::createEntry)
                .toList();
    }

    private boolean isValidEvent(Date current, Date end) {
        return current != null && current.before(end);
    }

    private DataEntry createEntry(Date time) {
        return new DataEntry(
                time,
                populator.getCategory(),
                sampler.createValue());
    }
}
