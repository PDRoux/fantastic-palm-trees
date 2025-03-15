package com.github.pdroux.fantastic_palm_trees;

import com.github.pdroux.fantastic_palm_trees.generator.DistributionGenerator;
import com.github.pdroux.fantastic_palm_trees.generator.GeneratorFactory;
import com.github.pdroux.fantastic_palm_trees.generator.SetGenerator;
import com.github.pdroux.fantastic_palm_trees.model.DataSet;
import com.github.pdroux.fantastic_palm_trees.model.GenerateParams;
import com.github.pdroux.fantastic_palm_trees.model.distribution.UniformParams;
import com.github.pdroux.fantastic_palm_trees.model.rate.FixedRateParams;
import com.github.pdroux.fantastic_palm_trees.model.rate.PeriodType;
import com.github.pdroux.fantastic_palm_trees.model.rate.RateParams;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class GeneratorFactoryTest {
    @Test
    public void testCreateGenerator() {
        Date start = new Date(10000);
        Date end = new Date(35000);
        RateParams rateParams = new FixedRateParams(
                start,
                end,
                PeriodType.SECOND,
                1
        );
        UniformParams uniformParams = new UniformParams(5.0, 15.0);
        GenerateParams params = new GenerateParams("Test", uniformParams, rateParams);

        SetGenerator generator = GeneratorFactory.createGenerator(params);

        assertInstanceOf(DistributionGenerator.class, generator);

        DataSet set = generator.createDataSet();

        assertEquals("Test", set.name());
        assertEquals(25, set.data().size());

        for (int i = 0; i < 24; i++) {
            long time = set.data().get(i).time().getTime();
            long nextTime = set.data().get(i + 1).time().getTime();

            assertEquals(1000, nextTime - time);
        }
    }
}
