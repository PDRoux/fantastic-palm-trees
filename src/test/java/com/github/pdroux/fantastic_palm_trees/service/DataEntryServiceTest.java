package com.github.pdroux.fantastic_palm_trees.service;

import com.github.pdroux.fantastic_palm_trees.dao.DataDao;
import com.github.pdroux.fantastic_palm_trees.dao.InvalidDataSet;
import com.github.pdroux.fantastic_palm_trees.model.DataSet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;

import static com.github.pdroux.fantastic_palm_trees.TestHelpers.expectedDB;
import static com.github.pdroux.fantastic_palm_trees.TestHelpers.testSet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DataEntryServiceTest {
    @Mock
    private DataDao mockDataDao;  // Mock the dependency

    @InjectMocks
    private DataSetService dataSetService;  // Injects the mock

    @Test
    void addDataEntry_ShouldDelegateToDataDao() {
        dataSetService.addDataSet(testSet);

        verify(mockDataDao, times(1)).insertDataSet(testSet);
    }

    @Test
    void addDataEntry_ShouldDelegateThrow() {
        doThrow(new InvalidDataSet("Bad Request"))
                .when(mockDataDao).insertDataSet(testSet);

        assertThrows(InvalidDataSet.class, () -> dataSetService.addDataSet(testSet));

        verify(mockDataDao, times(1)).insertDataSet(testSet);
    }

    @Test
    void selectAllData_ShouldDelegateToDataDao() {
        when(mockDataDao.selectAllData()).thenReturn(expectedDB);

        Collection<DataSet> actual = dataSetService.selectAllData();

        assertEquals(expectedDB, actual);
    }

    @Test
    void addDataEntry_ShouldHandleInvalidInput() {
        assertThrows(InvalidDataSet.class, () -> dataSetService.addDataSet(null));
        verify(mockDataDao, never()).insertDataSet(any());
    }
}
