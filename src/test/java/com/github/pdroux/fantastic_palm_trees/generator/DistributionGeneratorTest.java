package com.github.pdroux.fantastic_palm_trees.generator;

import com.github.pdroux.fantastic_palm_trees.generator.populator.CategoryPopulator;
import com.github.pdroux.fantastic_palm_trees.generator.sampler.DistributionSampler;
import com.github.pdroux.fantastic_palm_trees.generator.scheduler.RateScheduler;
import com.github.pdroux.fantastic_palm_trees.model.DataEntry;
import com.github.pdroux.fantastic_palm_trees.model.DataSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static com.github.pdroux.fantastic_palm_trees.TestHelpers.assertDataEntry;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DistributionGeneratorTest {

    private final Date startDate = new Date(1700000000000L);
    private final Date midDate = new Date(1700000005000L);
    private final Date endDate = new Date(1700000010000L);
    private final String setName = "TestData";
    @Mock
    private DistributionSampler mockSampler;
    @Mock
    private CategoryPopulator mockPopulator;
    @Mock
    private RateScheduler mockScheduler;

    private DistributionGenerator generator;

    @BeforeEach
    void setup() {
        generator = new DistributionGenerator(setName, mockSampler, mockScheduler, mockPopulator);
    }

    @Test
    void createDataSet_GeneratesMultipleEntries() {
        setupMultiTimeMocks();

        DataSet result = generator.createDataSet();

        assertEquals(setName, result.name());

        List<DataEntry> entries = result.data();
        assertEquals(3, entries.size());

        assertDataEntry(startDate, "cat1", 25.5, entries.get(0));
        assertDataEntry(midDate, "cat2", 60.0, entries.get(1));
        assertDataEntry(endDate, "cat2", 60.0, entries.get(2));

        verify(mockScheduler, times(4)).nextEventTime();
        verify(mockPopulator, times(3)).getCategory();
        verify(mockSampler, times(3)).sample();
    }

    private void setupMultiTimeMocks() {
        when(mockScheduler.nextEventTime())
                .thenReturn(startDate)
                .thenReturn(midDate)
                .thenReturn(endDate)
                .thenReturn(null);
        when(mockPopulator.getCategory())
                .thenReturn("cat1")
                .thenReturn("cat2");
        when(mockSampler.sample())
                .thenReturn(25.5)
                .thenReturn(60.0);
    }

    @Test
    void createDataSet_HandlesNoTime() {
        when(mockScheduler.nextEventTime())
                .thenReturn(null);

        DataSet result = generator.createDataSet();

        assertEquals("TestData", result.name());
        assertTrue(result.data().isEmpty());
        verify(mockScheduler).nextEventTime();
        verifyNoInteractions(mockPopulator, mockSampler);
    }
}
