package com.github.pdroux.fantastic_palm_trees.generator.scheduler;

import java.util.Date;

public interface RateScheduler {
    Date nextEventTime();
}
