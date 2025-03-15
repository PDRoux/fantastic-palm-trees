package com.github.pdroux.fantastic_palm_trees.model.rate;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Duration;

@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
public enum PeriodType {
    SECOND(Duration.ofSeconds(1)),
    MINUTE(Duration.ofMinutes(1)),
    HOUR(Duration.ofHours(1)),
    DAY(Duration.ofDays(1));

    private final Duration duration;

    PeriodType(Duration duration) {
        this.duration = duration;
    }

    public Duration getDuration() {
        return duration;
    }
}
