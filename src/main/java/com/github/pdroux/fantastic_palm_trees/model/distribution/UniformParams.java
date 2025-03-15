package com.github.pdroux.fantastic_palm_trees.model.distribution;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UniformParams extends DistributionParams {
    private final double lower;
    private final double upper;

    public UniformParams(
            @JsonProperty("lower") double lower,
            @JsonProperty("upper") double upper
    ) {
        this.lower = lower;
        this.upper = upper;
    }

    public double getLower() {
        return lower;
    }

    public double getUpper() {
        return upper;
    }

    public DistributionType getType() {
        return DistributionType.UNIFORM;
    }
}

