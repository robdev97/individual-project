package com.kodilla.individualproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameRulesTest {

    private GameRules gameRules;

    @BeforeEach
    void beforeTest() {
        char[][] board = new char[3][3];
        gameRules = new GameRules(board);
    }

    @Test
    void testOWinsInRow() {
        // Given
        char[][] board = {
                {'O', 'O', 'O'},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        gameRules = new GameRules(board);

        // Then
        assertTrue(gameRules.checkWinner('O'));
    }

    @Test
    void testOWinsInColumn() {
        // Given
        char[][] board = {
                {'O', ' ', ' '},
                {'O', ' ', ' '},
                {'O', ' ', ' '}
        };
        gameRules = new GameRules(board);

        // Then
        assertTrue(gameRules.checkWinner('O'));
    }

    @Test
    void testGameIsDraw() {
        // Given
        char[][] board = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'O', 'X', 'O'}
        };
        gameRules = new GameRules(board);

        // Then
        assertTrue(gameRules.isDraw());
        assertFalse(gameRules.checkWinner('X'));
        assertFalse(gameRules.checkWinner('O'));
    }
}