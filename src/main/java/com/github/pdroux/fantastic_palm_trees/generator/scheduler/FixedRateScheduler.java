package com.github.pdroux.fantastic_palm_trees.generator.scheduler;

import java.time.Duration;
import java.util.Date;

public class FixedRateScheduler implements RateScheduler {
    private final int rate;
    private final Duration cadence;
    private final Date current;
    private final Date end;

    public FixedRateScheduler(Date start, Date end, Duration cadence, int rate) {
        this.rate = rate;
        this.cadence = cadence;
        this.current = new Date(start.getTime());
        this.end = end;
    }

    public Date nextEventTime() {
        long nextTime = current.getTime() + cadence.toMillis() / rate;
        current.setTime(nextTime);
        if (current.after(end)) {
            return null;
        }

        return new Date(nextTime);
    }
}
