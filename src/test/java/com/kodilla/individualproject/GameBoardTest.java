package com.kodilla.individualproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {

    private GameBoard gameBoard;

    @BeforeEach
    void beforeTest() {
        gameBoard = new GameBoard(3);
    }

    @Test
    void shouldMakeMoveCorrectly() {
        // When
        boolean result = gameBoard.makeMove(1, 1, 'X');

        // Then
        assertTrue(result);
        assertEquals('X', gameBoard.getBoard()[1][1]);
    }

    @Test
    void shouldNotAllowMoveOutsideBoard() {
        // When
        boolean result = gameBoard.makeMove(3, 3, 'X');

        // Then
        assertFalse(result);
    }

    @Test
    void shouldNotAllowMoveOnOccupiedField() {
        // Given
        gameBoard.makeMove(0, 0, 'X');

        // When
        boolean result = gameBoard.makeMove(0, 0, 'O');

        // Then
        assertFalse(result);
        assertEquals('X', gameBoard.getBoard()[0][0]);
    }

    @Test
    void shouldThrowExceptionForSizeLessThanThree() {
        // Given
        int size = 2;

        //When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new GameBoard(size));

        //Then
        assertEquals("The minimum board size is 3x3.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 8, 10})
    void shouldCreateBoardWithDifferentValidSizes(int size) {
        // When
        GameBoard gameBoard = new GameBoard(size);

        // Then
        char[][] board = gameBoard.getBoard();
        assertEquals(size, board.length);
        assertEquals(size, board[0].length);
    }
}
