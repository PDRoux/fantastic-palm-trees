package com.github.pdroux.fantastic_palm_trees.generator.scheduler;

import java.time.Duration;
import java.util.Date;

public class RateScheduler implements IntervalScheduler {
    private final int rate;
    private final Duration cadence;
    private final Date current;

    public RateScheduler(int rate, Duration cadence, Date start) {
        this.rate = rate;
        this.cadence = cadence;
        this.current = start;
    }

    public Date nextEventTime() {
        current.setTime(current.getTime() + cadence.toMillis() / rate);
        return current;
    }
}
