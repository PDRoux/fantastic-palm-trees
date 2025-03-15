package com.github.pdroux.fantastic_palm_trees.generator;

import com.github.pdroux.fantastic_palm_trees.generator.populator.CategoryPopulator;
import com.github.pdroux.fantastic_palm_trees.generator.sampler.DistributionSampler;
import com.github.pdroux.fantastic_palm_trees.generator.scheduler.RateScheduler;
import com.github.pdroux.fantastic_palm_trees.model.DataEntry;
import com.github.pdroux.fantastic_palm_trees.model.DataSet;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class DistributionGenerator implements SetGenerator {
    private static final int MAX_ENTRIES = 10000;

    private final String name;
    private final DistributionSampler sampler;
    private final RateScheduler scheduler;
    private final CategoryPopulator populator;

    private int entryCount = 0;

    public DistributionGenerator(
            String name,
            DistributionSampler sampler,
            RateScheduler scheduler,
            CategoryPopulator populator
    ) {
        this.name = name;
        this.sampler = sampler;
        this.scheduler = scheduler;
        this.populator = populator;
    }

    public DataSet createDataSet() {
        List<DataEntry> entries = generateEntries();
        return new DataSet(name, entries);
    }

    private List<DataEntry> generateEntries() {
        return Stream.generate(scheduler::nextEventTime)
                .takeWhile(this::isValidEvent)
                .map(this::createEntry)
                .toList();
    }

    private boolean isValidEvent(Date current) {
        entryCount += 1;

        return current != null && entryCount < MAX_ENTRIES;
    }

    private DataEntry createEntry(Date time) {
        return new DataEntry(
                time,
                populator.getCategory(),
                sampler.sample());
    }
}
