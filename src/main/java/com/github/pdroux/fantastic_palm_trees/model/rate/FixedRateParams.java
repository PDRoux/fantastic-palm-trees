package com.github.pdroux.fantastic_palm_trees.model.rate;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Duration;
import java.util.Date;

public class FixedRateParams extends RateParams {
    private final Duration duration;
    private final int rate;

    public FixedRateParams(
            @JsonProperty("start") Date start,
            @JsonProperty("end") Date end,
            @JsonProperty("period") PeriodType period,
            @JsonProperty("rate") int rate
    ) {
        super(start, end);
        this.duration = period.getDuration();
        this.rate = rate;
    }

    public Duration getDuration() {
        return duration;
    }

    public int getRate() {
        return rate;
    }

    public RateType getType() {
        return RateType.FIXED;
    }
}
