package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {
    private static Logger logger;

    @BeforeAll
    public static void openSettingsFile() {
        logger = Logger.INSTANCE;
        logger.log("log info");
    }

    @Test
    void getLastLog() {
        //Given
        //When
        String lastLog = logger.getLastLog();
        System.out.println("Last log is: " + lastLog);
        //Then
        assertEquals("log info", lastLog);
    }
}
