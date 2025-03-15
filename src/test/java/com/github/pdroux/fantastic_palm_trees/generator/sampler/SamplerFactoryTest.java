package com.github.pdroux.fantastic_palm_trees.generator.sampler;

import com.github.pdroux.fantastic_palm_trees.model.distribution.DistributionParams;
import com.github.pdroux.fantastic_palm_trees.model.distribution.DistributionType;
import com.github.pdroux.fantastic_palm_trees.model.distribution.NormalParams;
import com.github.pdroux.fantastic_palm_trees.model.distribution.UniformParams;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SamplerFactoryTest {

    @Test
    public void testCreateNormalSampler() {
        NormalParams normalParams = new NormalParams(10.0, 2.0);
        DistributionSampler sampler = SamplerFactory.createSampler(normalParams);

        assertInstanceOf(NormalSampler.class, sampler);
    }

    @Test
    public void testCreateUniformSampler() {
        UniformParams uniformParams = new UniformParams(5.0, 15.0);
        DistributionSampler sampler = SamplerFactory.createSampler(uniformParams);

        assertInstanceOf(UniformSampler.class, sampler);
    }

    @Test
    public void testUnsupportedDistributionType() {
        DistributionParams unsupportedParams = new DistributionParams() {
            @Override
            public DistributionType getType() {
                return null;
            }
        };

        assertThrows(NullPointerException.class, () -> SamplerFactory.createSampler(unsupportedParams));
    }
}
