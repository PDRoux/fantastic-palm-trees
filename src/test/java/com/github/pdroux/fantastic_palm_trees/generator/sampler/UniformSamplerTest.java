package com.github.pdroux.fantastic_palm_trees.generator.sampler;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UniformSamplerTest {
    @RepeatedTest(10)
    void createValue_ReturnsWithinRange() {
        double lower = 5.0f;
        double upper = 10.0f;
        UniformSampler generator = new UniformSampler(lower, upper);

        double value = generator.sample();
        assertTrue(value >= lower && value < upper);
    }
}
