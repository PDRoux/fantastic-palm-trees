package com.github.pdroux.fantastic_palm_trees.generator.sampler;

import java.util.Random;

public class UniformSampler implements DistributionSampler {
    private final float upper;
    private final float lower;
    private final Random random = new Random();

    public UniformSampler(float upper, float lower) {
        this.upper = upper;
        this.lower = lower;
    }

    public float createValue() {
        return random.nextFloat(lower, upper);
    }
}
