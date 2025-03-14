package com.github.pdroux.fantastic_palm_trees.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class DataEntry {
   private final UUID id;
   private final Date time;
   private final String name;
   private final String category;
   private final float value;

    public DataEntry(UUID id, DataEntry data) {
        this.id = id;
        this.time = data.getTime();
        this.name = data.getName();
        this.category = data.getCategory();
        this.value = data.getValue();
    }

    public DataEntry(@JsonProperty("id") UUID id,
                     @JsonProperty("time")Date time,
                     @JsonProperty("name") String name,
                     @JsonProperty("category") String category,
                     @JsonProperty("value") float value
    ) {
        this.time = time;
        this.id = id;
        this.name = name;
        this.category = category;
        this.value = value;
    }

    public UUID getId() {
        return id;
    }

    public Date getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public float getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataEntry dataEntry = (DataEntry) o;
        return Float.compare(dataEntry.value, value) == 0 &&
                Objects.equals(id, dataEntry.id) &&
                Objects.equals(time, dataEntry.time) &&
                Objects.equals(name, dataEntry.name) &&
                Objects.equals(category, dataEntry.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, name, category, value);
    }
}
