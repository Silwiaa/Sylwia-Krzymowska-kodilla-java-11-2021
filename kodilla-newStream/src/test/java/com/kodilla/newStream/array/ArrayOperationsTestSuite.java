package com.kodilla.newStream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {
    @Test
    void testgetAverage() {
        //Given
        int numbers[] = {2, 15, 8, 10, 33, 12};
        double expectedAvg = 13.33;

        //When
        double resultAvg = ArrayOperations.getAverage(numbers);

        //Then
        assertEquals(expectedAvg, resultAvg, 0.004);
    }
}

