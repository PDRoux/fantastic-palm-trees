package com.github.pdroux.fantastic_palm_trees.generator.scheduler;

import com.github.pdroux.fantastic_palm_trees.model.rate.FixedRateParams;
import com.github.pdroux.fantastic_palm_trees.model.rate.PeriodType;
import com.github.pdroux.fantastic_palm_trees.model.rate.RateParams;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class SchedulerFactoryTest {
    @Test
    public void testCreateRateScheduler() {
        RateParams params = new FixedRateParams(
                new Date(),
                new Date(),
                PeriodType.SECOND,
                10
        );
        RateScheduler scheduler = SchedulerFactory.createScheduler(params);

        assertInstanceOf(FixedRateScheduler.class, scheduler);
    }
}
