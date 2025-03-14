package com.github.pdroux.fantastic_palm_trees.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pdroux.fantastic_palm_trees.service.DataSetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.github.pdroux.fantastic_palm_trees.TestHelpers.expectedDB;
import static com.github.pdroux.fantastic_palm_trees.TestHelpers.testSet;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DataController.class)
class DataControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DataSetService dataService;

    @Test
    void addDataEntry_ShouldCallServiceAndReturnCreated() throws Exception {
        mockMvc.perform(post("/v1/data")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testSet)))
                .andExpect(status().isOk());

        verify(dataService, times(1)).addDataSet(testSet);
    }

    @Test
    void selectAllData_ShouldReturnDataFromService() throws Exception {
        when(dataService.selectAllData()).thenReturn(expectedDB);

        // Act & Assert
        mockMvc.perform(get("/v1/data"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Test Sensor"))
                .andExpect(jsonPath("$[0].category").value("Humidity"))
                .andExpect(jsonPath("$[0].value").value(60.0));

        verify(dataService, times(1)).selectAllData();
    }
}
