package com.github.pdroux.fantastic_palm_trees.generator.scheduler;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FixedRateSchedulerTest {
    @Test
    void testNextEventTime() {
        Date start = new Date();
        long milliInterval = 1000 / 5;
        Date firstTime = new Date(start.getTime() + milliInterval);
        Date endTime = new Date(start.getTime() + 2 * milliInterval);

        FixedRateScheduler scheduler = new FixedRateScheduler(start, endTime, Duration.ofSeconds(1), 5);

        assertEquals(firstTime, scheduler.nextEventTime());
        assertEquals(endTime, scheduler.nextEventTime());
        assertNull(scheduler.nextEventTime());
    }
}
