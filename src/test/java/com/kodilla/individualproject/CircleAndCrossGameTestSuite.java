package com.kodilla.individualproject;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CircleAndCrossGameTestSuite {

    private GameBoard gameBoard;
    private GameRules gameRules;
    private Random mockRandom;
    private ComputerIsPlayer computerPlayer;

    @Test
    void testOWinsInRow() {
        //Given
        char[][] board = {
                {'O', 'O', 'O'},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        //When
        GameRules gameRules = new GameRules(board, 3);

        //Then
        assertTrue(gameRules.checkWinner('O'));
    }

    @Test
    void testOWinsInColumn() {
        //Given
        char[][] board = {
                {'O', ' ', ' '},
                {'O', ' ', ' '},
                {'O', ' ', ' '}
        };

        //When
        GameRules gameRules = new GameRules(board, 3);

        //Then
        assertTrue(gameRules.checkWinner('O'));
    }

    @Test
    void testOWinsInDiagonal() {

        //Given
        char[][] board = {
                {'O', ' ', ' '},
                {' ', 'O', ' '},
                {' ', ' ', 'O'}
        };

        //When
        GameRules gameRules = new GameRules(board, 3);

        //Then
        assertTrue(gameRules.checkWinner('O'));
    }

    @Test
    void testXWinsInRow() {
        //Given
        char[][] board = {
                {'X', 'X', 'X'},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        //When
        GameRules gameRules = new GameRules(board, 3);

        //then
        assertTrue(gameRules.checkWinner('X'));
    }

    @Test
    void testXWinsInColumn() {

        //Given
        char[][] board = {
                {'X', ' ', ' '},
                {'X', ' ', ' '},
                {'X', ' ', ' '}
        };

        //When
        GameRules gameRules = new GameRules(board, 3);

        //Then
        assertTrue(gameRules.checkWinner('X'));
    }

    @Test
    void testXWinsInDiagonal() {
        //Given
        char[][] board = {
                {'X', ' ', ' '},
                {' ', 'X', ' '},
                {' ', ' ', 'X'}
        };

        //When
        GameRules gameRules = new GameRules(board, 3);

        //Then
        assertTrue(gameRules.checkWinner('X'));
    }

    @Test
    void testGameIsDraw() {
        //Given
        char[][] board = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'O', 'X', 'O'}
        };

        //When
        GameRules gameRules = new GameRules(board, 3);

        //Then
        assertTrue(gameRules.isDraw());
        assertFalse(gameRules.checkWinner('X'));
        assertFalse(gameRules.checkWinner('O'));
    }

    @Test
    void testInvalidMoveReturnsFalse() {
        // Given
        GameBoard gameBoard = new GameBoard(3);

        // When & Then
        assertFalse(gameBoard.makeMove(3, 3, 'X'), "Ruch poza granicami planszy powinien być odrzucony");
        assertFalse(gameBoard.makeMove(-1, 0, 'X'), "Ruch z ujemnymi współrzędnymi powinien być odrzucony");
    }

    @Test
    void testMoveOnOccupiedFieldReturnsFalse() {
        // Given
        GameBoard gameBoard = new GameBoard(3);
        gameBoard.makeMove(0, 0, 'X');

        // When & Then
        assertFalse(gameBoard.makeMove(0, 0, 'O'), "Ruch na zajęte pole powinien być odrzucony");
    }

    @Test
    void testComputerMakesValidMove() {
        // Given
        GameBoard gameBoard = new GameBoard(3);

        // Mockowanie generatora losowego
        Random mockRandom = Mockito.mock(Random.class);
        Mockito.when(mockRandom.nextInt(3)).thenReturn(1, 1); // Komputer zawsze wybierze (1, 1)

        ComputerIsPlayer computerPlayer = new ComputerIsPlayer('O', mockRandom);

        // When
        computerPlayer.makeMove(gameBoard);

        // Then
        char[][] board = gameBoard.getBoard();
        assertTrue(board[1][1] == 'O', "Komputer powinien umieścić swój symbol 'O' na polu (1, 1)");
    }

    @Test
    void testComputerAvoidsOccupiedCells() {
        // Given
        GameBoard gameBoard = new GameBoard(3);
        gameBoard.makeMove(1, 1, 'X'); // Zajmujemy pole (1, 1)

        // Mockowanie generatora losowego
        Random mockRandom = Mockito.mock(Random.class);
        Mockito.when(mockRandom.nextInt(3)).thenReturn(1, 1, 0, 0); // Komputer spróbuje (1, 1), potem wybierze (0, 0)

        ComputerIsPlayer computerPlayer = new ComputerIsPlayer('O', mockRandom);

        // When
        computerPlayer.makeMove(gameBoard);

        // Then
        char[][] board = gameBoard.getBoard();
        assertTrue(board[0][0] == 'O', "Komputer powinien umieścić swój symbol 'O' na pierwszym wolnym polu (0, 0)");
        assertFalse(board[1][1] == 'O', "Komputer nie powinien nadpisać symbolu 'X' na polu (1, 1)");
    }
}