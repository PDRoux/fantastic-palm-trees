package com.github.pdroux.fantastic_palm_trees.generator.scheduler;

import java.time.Duration;
import java.util.Date;

public class FixedRateScheduler implements RateScheduler {
    private final long interval;
    private final long endTime;

    private long currentTime;

    public FixedRateScheduler(Date start, Date end, Duration cadence, int rate) {
        this.interval = cadence.toMillis() / rate;
        this.endTime = end.getTime();
        this.currentTime = start.getTime();
    }

    public Date nextEventTime() {
        currentTime += interval;
        if (currentTime > endTime) {
            return null;
        }

        return new Date(currentTime);
    }
}
