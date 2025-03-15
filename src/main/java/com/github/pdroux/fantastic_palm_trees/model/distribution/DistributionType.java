package com.github.pdroux.fantastic_palm_trees.model.distribution;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
public enum DistributionType {
    UNIFORM,
    NORMAL
}
