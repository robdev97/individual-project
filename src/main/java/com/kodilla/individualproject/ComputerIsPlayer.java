package com.kodilla.individualproject;

import java.util.Random;

public class ComputerIsPlayer {

    private final char symbol;
    private final Random random;

    public ComputerIsPlayer(char symbol, Random random) {
        this.symbol = symbol;
        this.random = random;
    }

    public void makeMove(GameBoard gameBoard) {
        char[][] board = gameBoard.getBoard();
        int size = board.length;
        int row;
        int col;

        do {
            row = random.nextInt(size);
            col = random.nextInt(size);
        } while (board[row][col] != ' ');

        gameBoard.makeMove(row, col, symbol);
        System.out.println("Komputer (" + symbol + ") zagrał na pozycji: [" + row + ", " + col + "]");
    }
}

