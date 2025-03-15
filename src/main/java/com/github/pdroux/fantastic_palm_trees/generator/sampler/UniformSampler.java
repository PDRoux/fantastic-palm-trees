package com.github.pdroux.fantastic_palm_trees.generator.sampler;

import java.util.Random;

public class UniformSampler implements DistributionSampler {
    private final double upper;
    private final double lower;
    private final Random random = new Random();

    public UniformSampler(double upper, double lower) {
        this.upper = upper;
        this.lower = lower;
    }

    public double sample() {
        return random.nextDouble(lower, upper);
    }
}
