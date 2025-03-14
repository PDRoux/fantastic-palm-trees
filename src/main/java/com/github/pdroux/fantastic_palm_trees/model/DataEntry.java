package com.github.pdroux.fantastic_palm_trees.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;


public record DataEntry(Date time, String category, float value) {
    public DataEntry(@JsonProperty("time") Date time,
                     @JsonProperty("category") String category,
                     @JsonProperty("value") float value
    ) {
        this.time = time;
        this.category = category;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataEntry dataEntry = (DataEntry) o;
        return Float.compare(dataEntry.value, value) == 0 &&
                Objects.equals(time, dataEntry.time) &&
                Objects.equals(category, dataEntry.category);
    }
}
