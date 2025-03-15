package com.github.pdroux.fantastic_palm_trees.generator.scheduler;

import com.github.pdroux.fantastic_palm_trees.model.rate.FixedRateParams;
import com.github.pdroux.fantastic_palm_trees.model.rate.RateParams;

public class SchedulerFactory {
    public static RateScheduler createScheduler(RateParams params) {
        return switch (params.getType()) {
            case FIXED -> createRateScheduler((FixedRateParams) params);
        };
    }

    private static RateScheduler createRateScheduler(FixedRateParams params) {
        return new FixedRateScheduler(
                params.getStart(),
                params.getEnd(),
                params.getDuration(),
                params.getRate()
        );
    }
}
