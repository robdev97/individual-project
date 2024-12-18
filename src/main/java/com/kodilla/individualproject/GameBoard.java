package com.kodilla.individualproject;

public class GameBoard {

    private final char[][] board;

    public GameBoard() {
        this.board = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
    }

    public void displayBoard() {
        System.out.println("_____________");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + board[i][j] + " |");
            }
            System.out.println("\n_____________");
        }
    }

    public boolean makeMove(int row, int col, char symbol) {

        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Nieprawidłowe współrzędne. Wprowadź wartości od 0 do 2.");
            return false;
        }
        if (board[row][col] != ' ') {
            System.out.println("To pole jest już zajęte. Wybierz inne pole.");
            return false;
        }
        board[row][col] = symbol;
        return true;

    }

    public char[][] getBoard() {
        return board;
    }
}


