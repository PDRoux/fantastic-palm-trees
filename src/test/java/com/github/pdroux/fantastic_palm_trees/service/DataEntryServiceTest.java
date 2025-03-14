package com.github.pdroux.fantastic_palm_trees.service;

import com.github.pdroux.fantastic_palm_trees.dao.DataDao;
import com.github.pdroux.fantastic_palm_trees.model.DataEntry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DataEntryServiceTest {
    private final DataEntry testEntry = new DataEntry(
            UUID.randomUUID(),
            new Date(),
            "Test Sensor",
            "Temperature",
            25.5f
    );

    @Mock
    private DataDao mockDataDao;  // Mock the dependency

    @InjectMocks
    private DataEntryService dataEntryService;  // Injects the mock

    @Test
    void addDataEntry_ShouldDelegateToDataDao() {
        when(mockDataDao.addDataEntry(testEntry)).thenReturn(1);

        int result = dataEntryService.addDataEntry(testEntry);

        assertEquals(1, result);
        verify(mockDataDao, times(1)).addDataEntry(testEntry);
    }

    @Test
    void selectAllData_ShouldDelegateToDataDao() {
        List<DataEntry> list = new ArrayList<>(List.of(testEntry));
        when(mockDataDao.selectAllData()).thenReturn(list);

        List<DataEntry> actual = dataEntryService.selectAllData();

        assertEquals(list, actual);
    }

    @Test
    void addDataEntry_ShouldHandleInvalidInput() {
        int result = dataEntryService.addDataEntry(null);

        assertEquals(-1, result);
        verify(mockDataDao, never()).addDataEntry(any());
    }
}
