package com.kodilla.individualproject;

import java.util.Scanner;

public class CircleAndCrossGameApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GameBoard gameBoard = new GameBoard(); //
        GameRules gameLogic = new GameRules(gameBoard.getBoard()); //
        char currentPlayer = 'X'; //

        System.out.println("Witaj w grze Kółko i Krzyżyk!");

        while (true) {
            gameBoard.displayBoard();
            System.out.println("Gracz " + currentPlayer + ", podaj wiersz (0-2):");
            int row = scanner.nextInt();
            System.out.println("Gracz " + currentPlayer + ", podaj kolumnę (0-2):");
            int col = scanner.nextInt();

            if (gameBoard.makeMove(row, col, currentPlayer)) {
                if (gameLogic.checkWinner(currentPlayer)) {
                    gameBoard.displayBoard();
                    System.out.println("Gracz " + currentPlayer + " wygrywa! Gratulacje!");
                    break;
                } else if (gameLogic.isDraw()) {
                    gameBoard.displayBoard();
                    System.out.println("Remis! Plansza jest pełna.");
                    break;
                }
                // Zmiana gracza
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Spróbuj ponownie.");
            }
        }

        System.out.println("Dziękujemy za grę!");
        scanner.close();
    }
}
