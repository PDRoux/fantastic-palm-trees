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

    @Test
    void repeatedTest() {
        int repeats = 50;
        int rate = 5;
        Date start = new Date();
        long interval = Duration.ofHours(1).toMillis() / rate;
        Date endTime = new Date(start.getTime() + repeats * interval);

        FixedRateScheduler scheduler = new FixedRateScheduler(start, endTime, Duration.ofHours(1), rate);

        for (int i = 1; i <= repeats; i++) {
            long actualTime = scheduler.nextEventTime().getTime();
            assertEquals(start.getTime() + i * interval, actualTime);
        }

        assertNull(scheduler.nextEventTime());
    }
}
