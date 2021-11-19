package com.kodilla.testing.forum.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.jupiter.api.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @DisplayName(
            "When created OddNumbersExterminator with empty givenList, " +
                    "then exterminate should return an empty List"
    )
    @Test
    void testOddNumbersExterminatorEmptyList() {
        System.out.println("testOddNumbersExterminatorEmptyList() started");

        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> givenList = new ArrayList<>();
        List<Integer> expectedResult = new ArrayList<>();

        //When
        List<Integer> result = exterminator.exterminate(givenList);

        //Then
        assertEquals(result, expectedResult);
    }

    @DisplayName(
            "When created OddNumbersExterminator with not empty givenList, " +
                    "then exterminate should return a List of even integers"
    )

    @Test
    void testOddNumbersExterminatorNormalList() {
        System.out.println("testOddNumbersExterminatorNormalList() started");

        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> givenList = new ArrayList<>(Arrays.asList(3, 13, 16, 18, 23, 26, 34));
        List<Integer> expectedResult = new ArrayList<>(Arrays.asList(16, 18, 26, 34));

        //When
        List<Integer> result = exterminator.exterminate(givenList);

        //Then
        assertEquals(result, expectedResult);
    }
}
