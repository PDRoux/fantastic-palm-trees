package com.github.pdroux.fantastic_palm_trees.generator.sampler;

import java.util.Random;

public class UniformSampler implements DistributionSampler {
    private final double lower;
    private final double upper;
    private final Random random = new Random();

    public UniformSampler(double lower, double upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public double sample() {
        return random.nextDouble(lower, upper);
    }
}
