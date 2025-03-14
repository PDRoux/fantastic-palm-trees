package com.github.pdroux.fantastic_palm_trees.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pdroux.fantastic_palm_trees.model.DataEntry;
import com.github.pdroux.fantastic_palm_trees.service.DataEntryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DataController.class)
class DataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DataEntryService dataService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void addDataEntry_ShouldCallServiceAndReturnCreated() throws Exception {
        DataEntry entry = new DataEntry(
                UUID.randomUUID(),
                new Date(),
                "Test Sensor",
                "Temperature",
                25.5f
        );

        mockMvc.perform(post("/v1/data")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(entry)))
                .andExpect(status().isOk());

        verify(dataService, times(1)).addDataEntry(entry);
    }

    @Test
    void selectAllData_ShouldReturnDataFromService() throws Exception {
        // Arrange
        DataEntry entry = new DataEntry(
                UUID.randomUUID(),
                new Date(),
                "Test Sensor",
                "Humidity",
                60.0f
        );
        List<DataEntry> entries = Collections.singletonList(entry);
        when(dataService.selectAllData()).thenReturn(entries);

        // Act & Assert
        mockMvc.perform(get("/v1/data"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Test Sensor"))
                .andExpect(jsonPath("$[0].category").value("Humidity"))
                .andExpect(jsonPath("$[0].value").value(60.0));

        verify(dataService, times(1)).selectAllData();
    }
}
