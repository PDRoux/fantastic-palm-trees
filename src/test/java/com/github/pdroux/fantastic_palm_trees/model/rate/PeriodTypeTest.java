package com.github.pdroux.fantastic_palm_trees.model.rate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PeriodTypeTest {
    private final ObjectMapper mapper = new ObjectMapper();

    private static Stream<Arguments> testDurationProvider() {
        return Stream.of(
                Arguments.of(PeriodType.SECOND, Duration.ofSeconds(1)),
                Arguments.of(PeriodType.MINUTE, Duration.ofMinutes(1)),
                Arguments.of(PeriodType.HOUR, Duration.ofHours(1)),
                Arguments.of(PeriodType.DAY, Duration.ofDays(1))
        );
    }

    @ParameterizedTest
    @MethodSource("testDurationProvider")
    void values_HaveCorrectDurations(PeriodType type, Duration expectedDuration) {
        assertEquals(expectedDuration, type.getDuration());
    }

    @Test
    void deserialize_InvalidPeriod_ThrowsException() {
        String json = "\"week\"";
        assertThrows(InvalidFormatException.class, () -> {
            mapper.readValue(json, PeriodType.class);
        });
    }

    @Test
    void deserialize_Null_ThrowsException() {
        String json = "null";
        assertDoesNotThrow(() -> {
            PeriodType result = mapper.readValue(json, PeriodType.class);
            assertNull(result);
        });
    }
}
