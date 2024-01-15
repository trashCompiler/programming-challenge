package de.bcxp.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit 5 test case.
 */
class AppTest {

    private String successLabel = "not successful";
    String filePath = "src\\main\\resources\\de\\bcxp\\challenge\\";

    @BeforeEach
    void setUp() {
        successLabel = "successful";
    }

    @Test
    void aPointlessTest() {
        assertEquals("successful", successLabel, "My expectations were not met");
    }

    // *Erinnerung für unser Gespräch* 
    // Hier unit test
    @Test
    void testCalcDiff() {
        
    }

    // *Erinnerung für unser Gespräch* 
    // Hier unit test
    @Test
    void testCalcPopDensity() {
        
    }

    // *Erinnerung für unser Gespräch* 
    // Hier unit test
    @Test
    void testGetEntities() {
        
    }
}