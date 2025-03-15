package com.github.pdroux.fantastic_palm_trees.generator.sampler;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UniformSamplerTest {
    @RepeatedTest(10)
    void createValue_ReturnsWithinRange() {
        float lower = 5.0f;
        float upper = 10.0f;
        UniformSampler generator = new UniformSampler(upper, lower);

        float value = generator.createValue();
        assertTrue(value >= lower && value < upper);
    }
}
