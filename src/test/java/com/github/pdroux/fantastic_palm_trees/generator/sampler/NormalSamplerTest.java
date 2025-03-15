package com.github.pdroux.fantastic_palm_trees.generator.sampler;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NormalSamplerTest {
    @RepeatedTest(5)
    public void testSampleWithinExpectedRange() {
        double mean = 0.0;
        double stddev = 1.0;
        NormalSampler sampler = new NormalSampler(mean, stddev);

        // Generating a large number of samples to test statistical properties
        int sampleCount = 1000;
        double sum = 0;

        for (int i = 0; i < sampleCount; i++) {
            double sample = sampler.sample();
            sum += sample;
        }

        // Check if the mean is approximately correct
        double calculatedMean = sum / sampleCount;
        assertEquals(mean, calculatedMean, 0.1, "Generated samples have an incorrect mean.");
    }
}
