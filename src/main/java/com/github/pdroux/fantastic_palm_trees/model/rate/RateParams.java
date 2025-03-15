package com.github.pdroux.fantastic_palm_trees.model.rate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Date;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = FixedRateParams.class, name = "FIXED"),
})
public abstract class RateParams {
    private final Date start;
    private final Date end;

    protected RateParams(
            @JsonProperty("start") Date start,
            @JsonProperty("end") Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public abstract RateType getType();
}
