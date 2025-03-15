package com.github.pdroux.fantastic_palm_trees.model.distribution;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NormalParams extends DistributionParams {
    private final double mean;
    private final double stdDev;

    public NormalParams(
            @JsonProperty("mean") double mean,
            @JsonProperty("stdDev") double stdDev
    ) {
        this.mean = mean;
        this.stdDev = stdDev;
    }

    public double getMean() {
        return mean;
    }

    public double getStdDev() {
        return stdDev;
    }

    public DistributionType getType() {
        return DistributionType.NORMAL;
    }
}
