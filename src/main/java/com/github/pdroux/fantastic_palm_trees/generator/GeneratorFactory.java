package com.github.pdroux.fantastic_palm_trees.generator;

import com.github.pdroux.fantastic_palm_trees.generator.populator.CategoryPopulator;
import com.github.pdroux.fantastic_palm_trees.generator.populator.ListPopulator;
import com.github.pdroux.fantastic_palm_trees.generator.sampler.DistributionSampler;
import com.github.pdroux.fantastic_palm_trees.generator.sampler.SamplerFactory;
import com.github.pdroux.fantastic_palm_trees.generator.scheduler.RateScheduler;
import com.github.pdroux.fantastic_palm_trees.generator.scheduler.SchedulerFactory;
import com.github.pdroux.fantastic_palm_trees.model.GenerateParams;

import java.util.List;

public class GeneratorFactory {
    public static SetGenerator createGenerator(GenerateParams params) {
        DistributionSampler sampler = SamplerFactory.createSampler(params.distribution());
        RateScheduler scheduler = SchedulerFactory.createScheduler(params.rate());
        CategoryPopulator populator = new ListPopulator(List.of("unused"));

        return new DistributionGenerator(
                params.name(),
                sampler,
                scheduler,
                populator
        );
    }
}
