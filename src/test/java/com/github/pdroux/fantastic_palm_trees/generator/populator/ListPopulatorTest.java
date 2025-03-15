package com.github.pdroux.fantastic_palm_trees.generator.populator;

import org.junit.jupiter.api.RepeatedTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ListPopulatorTest {
    private final ListPopulator single = new ListPopulator(List.of("cat1"));
    private final List<String> multiList = List.of("cat1", "cat2");
    private final ListPopulator multi = new ListPopulator(multiList);

    @RepeatedTest(5)
    void getCategory_singleItem() {
        assertEquals("cat1", single.getCategory());
    }

    @RepeatedTest(5)
    void getCategory_multipleItems() {
        Set<String> categorySet = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            categorySet.add(multi.getCategory());
            if (categorySet.size() == multiList.size())
                break;
        }

        assertTrue(multiList.containsAll(categorySet));
        assertTrue(categorySet.containsAll(multiList));
    }
}
