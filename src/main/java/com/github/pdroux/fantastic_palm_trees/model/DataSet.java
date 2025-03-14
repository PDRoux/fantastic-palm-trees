package com.github.pdroux.fantastic_palm_trees.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public record DataSet(String name, List<DataEntry> data) {
    public DataSet(
            @JsonProperty String name,
            @JsonProperty List<DataEntry> data
    ) {
        this.name = name;
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataSet otherSet = (DataSet) o;
        return Objects.equals(name, otherSet.name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
