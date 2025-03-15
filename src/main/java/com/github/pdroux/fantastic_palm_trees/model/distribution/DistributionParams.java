package com.github.pdroux.fantastic_palm_trees.model.distribution;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = UniformParams.class, name = "UNIFORM"),
        @JsonSubTypes.Type(value = NormalParams.class, name = "NORMAL"),
})
public abstract class DistributionParams {
    public abstract DistributionType getType();
}
