package com.kodilla.individualproject;

public class GameRules {

    private final char[][] board;


    public GameRules(char[][] board) {
        this.board = board;

    }

    public boolean checkWinner(char playerSymbol) {
        int size = board.length;

        for (int i = 0; i < size; i++) {
            if (checkLine(playerSymbol, i, 0, 0, 1, size) || checkLine(playerSymbol, 0, i, 1, 0, size)) {
                return true;
            }
        }

        return checkLine(playerSymbol, 0, 0, 1, 1, size) || checkLine(playerSymbol, 0, size - 1, 1, -1, size);
    }

    private boolean checkLine(char playerSymbol, int startRow, int startCol, int rowStep, int colStep, int size) {
        for (int i = 0; i < size; i++) {
            int row = startRow + i * rowStep;
            int col = startCol + i * colStep;

            if (row >= size || col >= size || board[row][col] != playerSymbol) {
                return false;
            }
        }
        return true;
    }

    public boolean isDraw() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
