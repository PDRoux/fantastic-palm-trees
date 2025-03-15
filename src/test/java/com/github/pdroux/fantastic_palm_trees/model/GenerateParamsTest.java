package com.github.pdroux.fantastic_palm_trees.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import com.github.pdroux.fantastic_palm_trees.model.distribution.DistributionType;
import com.github.pdroux.fantastic_palm_trees.model.rate.RateType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GenerateParamsTest {
    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void deserialize_UniformType() throws JsonProcessingException {
        String validJson = """
                {
                    "name": "test",
                    "distribution": {
                        "type": "UNIFORM",
                        "lower": 5,
                        "upper": 10
                    },
                    "rate": {
                        "type": "FIXED",
                        "start": "2025-03-15",
                        "end": "2025-03-16",
                        "period": "SECOND",
                        "rate": 10
                    }
                }
                """;
        GenerateParams actual = mapper.readerFor(GenerateParams.class).readValue(validJson);

        assertEquals("test", actual.name());
        assertEquals(RateType.FIXED, actual.rate().getType());
        assertEquals(DistributionType.UNIFORM, actual.distribution().getType());
    }

    @Test
    void deserialize_InvalidType_ThrowsException() {
        String invalidJson = """
                {
                    "name": "test",
                    "distribution": {
                        "type": "INVALID",
                        "lower": 5,
                        "upper": 10
                    },
                    "rate": {
                        "type": "FIXED",
                        "start": "2025-03-15",
                        "end": "2025-03-16",
                        "period": "SECOND",
                        "rate": 10
                    }
                }
                """;

        assertThrows(InvalidTypeIdException.class, () -> {
            mapper.readValue(invalidJson, GenerateParams.class);
        });
    }

    @Test
    void deserialize_MissingParams_ThrowsException() {
        String json = """
                {
                    "name": "test",
                    "distribution": {
                        "type": "UNIFORM",
                        "lower": 5,
                        "upper": 10
                    },
                }
                """;

        assertThrows(JsonProcessingException.class, () -> {
            mapper.readValue(json, GenerateParams.class);
        });
    }
}
