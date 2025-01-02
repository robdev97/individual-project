package com.kodilla.individualproject;

public class GameRules {

    private final char[][] board;
    private final int winCondition;

    public GameRules(char[][] board, int winCondition) {
        this.board = board;
        this.winCondition = winCondition;
    }

    // Sprawdzanie warunków zwycięstwa
    public boolean checkWinner(char playerSymbol) {
        int size = board.length;

        // Sprawdzenie wierszy i kolumn
        for (int i = 0; i < size; i++) {
            if (checkLine(playerSymbol, i, 0, 0, 1) || checkLine(playerSymbol, 0, i, 1, 0)) {
                return true;
            }
        }

        // Sprawdzenie przekątnych
        return checkLine(playerSymbol, 0, 0, 1, 1) || checkLine(playerSymbol, 0, size - 1, 1, -1);
    }

    private boolean checkLine(char playerSymbol, int startRow, int startCol, int rowStep, int colStep) {
        int count = 0;
        int size = board.length;

        for (int i = 0; i < size; i++) {
            int row = startRow + i * rowStep;
            int col = startCol + i * colStep;

            if (row >= 0 && row < size && col >= 0 && col < size && board[row][col] == playerSymbol) {
                count++;
                if (count == winCondition) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
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
