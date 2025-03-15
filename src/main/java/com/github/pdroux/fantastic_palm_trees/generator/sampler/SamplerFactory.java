package com.github.pdroux.fantastic_palm_trees.generator.sampler;

import com.github.pdroux.fantastic_palm_trees.model.distribution.DistributionParams;
import com.github.pdroux.fantastic_palm_trees.model.distribution.NormalParams;
import com.github.pdroux.fantastic_palm_trees.model.distribution.UniformParams;

public class SamplerFactory {
    public static DistributionSampler createSampler(DistributionParams params) {
        return switch (params.getType()) {
            case UNIFORM -> createUniformSampler((UniformParams) params);
            case NORMAL -> createNormalSampler((NormalParams) params);
        };
    }

    private static DistributionSampler createUniformSampler(UniformParams params) {
        return new UniformSampler(params.getLower(), params.getUpper());
    }

    private static DistributionSampler createNormalSampler(NormalParams params) {
        return new NormalSampler(params.getMean(), params.getStdDev());
    }
}
