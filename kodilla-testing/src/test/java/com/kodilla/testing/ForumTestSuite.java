package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import org.junit.jupiter.api.*;


@DisplayName("Forum Test Suite")
class ForumTestSuite {
    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suit: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite end");
    }

    @DisplayName(
            "When created SimpleUser with real user name and surname, " +
            "then getRealName should return correct name and surname"
    )

    @Test
    void testCaseRealName() {
        //Given
        SimpleUser simpleUser = new SimpleUser("Joe", "Joseph Doe");

        //When
        String result = simpleUser.getRealName();
        System.out.println("Testing " + result);

        //Then
        Assertions.assertEquals("Joseph Doe", result);
    }

    @DisplayName(
            "When created SimpleUser with name, " +
            "then getUsername should return correct name"
    )

    @Test
    void testCaseUsername() {
        //Given
        SimpleUser simpleUser = new SimpleUser("Joe", "Joseph Doe");
        String expectedResult = "Joe";

        //When
        String result = simpleUser.getUsername();
        System.out.println("Testing " + result);

        //Then
        Assertions.assertEquals(expectedResult, result);
    }
}
