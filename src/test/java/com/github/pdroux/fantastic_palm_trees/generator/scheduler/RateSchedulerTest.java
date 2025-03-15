package com.github.pdroux.fantastic_palm_trees.generator.scheduler;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RateSchedulerTest {
    @Test
    void testNextEventTime() {
        Date time = new Date();
        RateScheduler scheduler = new RateScheduler(5, Duration.ofSeconds(1), time);

        long expectedMillis = time.getTime() + 1000 / 5;
        Date expectedTime = new Date(expectedMillis);

        assertEquals(expectedTime, scheduler.nextEventTime());
    }
}
