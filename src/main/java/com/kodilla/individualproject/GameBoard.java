package com.kodilla.individualproject;

public class GameBoard {

    private final char[][] board;

    public GameBoard(int size) {

        if (size < 3) {
            throw new IllegalArgumentException("The minimum board size is 3x3.");
        }
        this.board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = ' ';
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }


    public void displayBoard() {
        int size = board.length;
        System.out.println("_".repeat(4 * size + 1));
        for (int i = 0; i < size; i++) {
            System.out.print("|");
            for (int j = 0; j < size; j++) {
                System.out.print(" " + board[i][j] + " |");
            }
            System.out.println("\n" + "_".repeat(4 * size + 1));
        }
    }

    public boolean makeMove(int row, int col, char symbol) {

        int size = board.length;

        if (row < 0 || row >= size || col < 0 || col >= size) {
            System.out.println("Incorrect coordinates. Enter a value from 0 to 2.");
            return false;
        }
        if (board[row][col] != ' ') {
            System.out.println("This field is already occupied. Select another field.");
            return false;
        }
        board[row][col] = symbol;
        return true;

    }
}


