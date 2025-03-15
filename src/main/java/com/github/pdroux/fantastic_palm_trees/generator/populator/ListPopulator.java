package com.github.pdroux.fantastic_palm_trees.generator.populator;

import java.util.List;
import java.util.Random;

public class ListPopulator implements CategoryPopulator {
    private final List<String> categories;
    private final Random random = new Random();

    public ListPopulator(List<String> categories) {
        this.categories = categories;
    }

    public String getCategory() {
        return categories.get(random.nextInt(0, categories.size()));
    }
}
