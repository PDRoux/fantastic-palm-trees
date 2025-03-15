package com.github.pdroux.fantastic_palm_trees.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GenerateDataResponse(String message, int records) {
    public GenerateDataResponse(
            @JsonProperty String message,
            @JsonProperty int records
    ) {
        this.message = message;
        this.records = records;
    }
}
