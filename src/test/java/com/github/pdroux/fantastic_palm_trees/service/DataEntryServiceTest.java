package com.github.pdroux.fantastic_palm_trees.service;

import com.github.pdroux.fantastic_palm_trees.dao.DataDao;
import com.github.pdroux.fantastic_palm_trees.model.DataSet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static com.github.pdroux.fantastic_palm_trees.TestHelpers.expectedDB;
import static com.github.pdroux.fantastic_palm_trees.TestHelpers.testSet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DataEntryServiceTest {
    @Mock
    private DataDao mockDataDao;  // Mock the dependency

    @InjectMocks
    private DataSetService dataSetService;  // Injects the mock

    @Test
    void addDataEntry_ShouldDelegateToDataDao() {
        when(mockDataDao.addDataSet(testSet)).thenReturn(1);

        int result = dataSetService.addDataSet(testSet);

        assertEquals(1, result);
        verify(mockDataDao, times(1)).addDataSet(testSet);
    }

    @Test
    void selectAllData_ShouldDelegateToDataDao() {
        when(mockDataDao.selectAllData()).thenReturn(expectedDB);

        Set<DataSet> actual = dataSetService.selectAllData();

        assertEquals(expectedDB, actual);
    }

    @Test
    void addDataEntry_ShouldHandleInvalidInput() {
        int result = dataSetService.addDataSet(null);

        assertEquals(-1, result);
        verify(mockDataDao, never()).addDataSet(any());
    }
}
