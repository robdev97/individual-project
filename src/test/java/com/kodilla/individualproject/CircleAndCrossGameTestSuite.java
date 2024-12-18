package com.kodilla.individualproject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CircleAndCrossGameTestSuite {

    @Test
    void testOWinsInRowsO() {
        // Given
        char[][] board = {
                {'O', 'O', 'O'},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        GameRules gameLogic = new GameRules(board);

        // When
        boolean result = gameLogic.checkWinner('O');

        // Then
        assertTrue(result, "O powinno wygrać w pierwszym wierszu");
    }

    @Test
    void testOWinsInRowsX() {
        // Given
        char[][] board = {
                {'X', 'X', 'X'},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        GameRules gameLogic = new GameRules(board);

        // When
        boolean result = gameLogic.checkWinner('X');

        // Then
        assertTrue(result, "X powinno wygrać w pierwszym wierszu");
    }

    @Test
    void testOWinsInColumnsO() {
        // Given
        char[][] board = {
                {'O', ' ', ' '},
                {'O', ' ', ' '},
                {'O', ' ', ' '}
        };
        GameRules gameLogic = new GameRules(board);

        // When
        boolean result = gameLogic.checkWinner('O');

        // Then
        assertTrue(result, "O powinno wygrać w pierwszej kolumnie");
    }

    @Test
    void testOWinsInColumnsX() {
        // Given
        char[][] board = {
                {'X', ' ', ' '},
                {'X', ' ', ' '},
                {'X', ' ', ' '}
        };
        GameRules gameLogic = new GameRules(board);

        // When
        boolean result = gameLogic.checkWinner('X');

        // Then
        assertTrue(result, "X powinno wygrać w pierwszej kolumnie");
    }

    @Test
    void testOWinsOnDiagonalsO() {
        // Given
        char[][] board = {
                {'O', ' ', ' '},
                {' ', 'O', ' '},
                {' ', ' ', 'O'}
        };
        GameRules gameLogic = new GameRules(board);

        // When
        boolean result = gameLogic.checkWinner('O');

        // Then
        assertTrue(result, "O powinno wygrać po przekątnej");
    }

    @Test
    void testOWinsOnDiagonalsX() {
        // Given
        char[][] board = {
                {'X', ' ', ' '},
                {' ', 'X', ' '},
                {' ', ' ', 'X'}
        };
        GameRules gameLogic = new GameRules(board);

        // When
        boolean result = gameLogic.checkWinner('X');

        // Then
        assertTrue(result, "X powinno wygrać po przekątnej");
    }

    // Test na remis
    @Test
    void testDrawGame() {
        // Given
        char[][] board = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'O', 'X', 'O'}
        };
        GameRules gameLogic = new GameRules(board);

        // When
        boolean isDraw = gameLogic.isDraw();
        boolean oWins = gameLogic.checkWinner('O');
        boolean xWins = gameLogic.checkWinner('X');

        // Then
        assertTrue(isDraw, "Gra powinna zakończyć się remisem");
        assertFalse(oWins, "O nie powinno wygrać");
        assertFalse(xWins, "X nie powinno wygrać");
    }


    @Test
    void testInvalidMoveThrowsException() {
        // Given
        GameBoard gameBoard = new GameBoard();
        gameBoard.makeMove(0, 0, 'X'); // Poprawny ruch

        // When
        boolean result = gameBoard.makeMove(0, 0, 'O'); // Próba ruchu w zajęte pole

        // Then
        assertFalse(result, "Ruch w zajęte pole powinien zostać odrzucony");
    }
}

