package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class probablyIWillThrowException {
    @Test
    void checkIfwillThrowException() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When & Then
        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.00, 3.00)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.00, 2.00))
        );
    }
}
