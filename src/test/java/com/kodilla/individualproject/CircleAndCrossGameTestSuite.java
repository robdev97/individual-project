package com.kodilla.individualproject;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircleAndCrossGameTestSuite {

    private CircleAndCrossGameApp app;

    @BeforeEach
    void beforeEach() {
        app = new CircleAndCrossGameApp();
    }

    @Test
    void testGameStartsCorrectly() {
        assertNotNull(app, "The application should be properly initialized");
    }
}