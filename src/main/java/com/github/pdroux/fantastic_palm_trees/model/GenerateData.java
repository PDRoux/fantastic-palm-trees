package com.github.pdroux.fantastic_palm_trees.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pdroux.fantastic_palm_trees.model.distribution.DistributionParams;
import com.github.pdroux.fantastic_palm_trees.model.rate.RateParams;

public record GenerateData(
        DistributionParams distribution,
        RateParams rate
) {
    public GenerateData(
            @JsonProperty(value = "distribution", required = true) DistributionParams distribution,
            @JsonProperty(value = "rate", required = true) RateParams rate
    ) {
        this.distribution = distribution;
        this.rate = rate;
    }
}
