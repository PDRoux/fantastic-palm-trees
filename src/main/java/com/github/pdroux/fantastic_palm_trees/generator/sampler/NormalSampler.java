package com.github.pdroux.fantastic_palm_trees.generator.sampler;

import java.util.Random;

public class NormalSampler implements DistributionSampler {
    private final double mean;
    private final double stddev;
    private final Random random = new Random();

    public NormalSampler(double mean, double stddev) {
        this.mean = mean;
        this.stddev = stddev;
    }

    @Override
    public double sample() {
        return mean + stddev * random.nextGaussian();
    }
}
