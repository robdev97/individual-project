package com.kodilla.individualproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class ComputerIsPlayerTest {

    private GameBoard gameBoard;
    private Random mockRandom;
    private ComputerIsPlayer computerPlayer;

    @BeforeEach
    void beforeTest() {
        gameBoard = new GameBoard(3);
        mockRandom = Mockito.mock(Random.class);
        computerPlayer = new ComputerIsPlayer('O', mockRandom);
    }

    @Test
    void testComputerMakesValidMove() {
        // Given
        Mockito.when(mockRandom.nextInt(3)).thenReturn(1, 1);

        // When
        computerPlayer.computerMove(gameBoard);

        // Then
        char[][] board = gameBoard.getBoard();
        assertEquals('O', board[1][1], "The computer should place its 'O' symbol on the field (1, 1)");
    }

    @Test
    void testComputerAvoidsOccupiedCells() {
        // Given
        gameBoard.makeMove(1, 1, 'X');
        Mockito.when(mockRandom.nextInt(3)).thenReturn(1, 1, 0, 0);

        // When
        computerPlayer.computerMove(gameBoard);

        // Then
        char[][] board = gameBoard.getBoard();
        assertEquals('O', board[0][0], "The computer should place its 'O' symbol on the first free field (0, 0)");
        assertNotEquals('O', board[1][1], "The computer should not overwrite the 'X' symbol on the (1, 1) field");
    }
}
