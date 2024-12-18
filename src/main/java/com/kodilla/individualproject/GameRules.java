package com.kodilla.individualproject;

public class GameRules {

    private final char[][] board;

    public GameRules(char[][] board) {
        this.board = board;
    }

    public boolean checkWinner(char playerSymbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == playerSymbol && board[i][1] == playerSymbol
                    && board[i][2] == playerSymbol) {
                return true;
            }

            if (board[0][i] == playerSymbol && board[1][i] == playerSymbol &&
                    board[2][i] == playerSymbol) {
                return true;
            }

            if (board[0][0] == playerSymbol && board[1][1] == playerSymbol &&
                    board[2][2] == playerSymbol) {
                return true;
            }

            if (board[0][2] == playerSymbol && board[1][1] == playerSymbol &&
                    board[2][0] == playerSymbol) {
                return true;
            }
        }
        return false;
    }

    public boolean isDraw() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') return false;
            }
        }
        return true;
    }
}
