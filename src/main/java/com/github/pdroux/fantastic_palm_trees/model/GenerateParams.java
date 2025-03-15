package com.github.pdroux.fantastic_palm_trees.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pdroux.fantastic_palm_trees.model.distribution.DistributionParams;
import com.github.pdroux.fantastic_palm_trees.model.rate.RateParams;

public record GenerateParams(
        String name,
        DistributionParams distribution,
        RateParams rate
) {
    public GenerateParams(
            @JsonProperty(value = "name", required = true) String name,
            @JsonProperty(value = "distribution", required = true) DistributionParams distribution,
            @JsonProperty(value = "rate", required = true) RateParams rate
    ) {
        this.name = name;
        this.distribution = distribution;
        this.rate = rate;
    }
}
