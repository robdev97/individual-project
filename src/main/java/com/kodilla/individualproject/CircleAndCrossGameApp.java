package com.kodilla.individualproject;

import java.util.Random;
import java.util.Scanner;

public class CircleAndCrossGameApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Witaj w grze Kółko i Krzyżyk!");
        System.out.println("Wybierz tryb gry:");
        System.out.println("1 - Gracz kontra Gracz");
        System.out.println("2 - Gracz kontra Komputer");
        int mode = scanner.nextInt();

        if (mode != 1 && mode != 2) {
            System.out.println("Nieprawidłowy wybór. Program zakończy działanie.");
            return;
        }

        System.out.print("Podaj rozmiar planszy (min 3): ");
        int size = scanner.nextInt();

        System.out.print("Podaj liczbę symboli potrzebnych do zwycięstwa (min 3): ");
        int winCondition = scanner.nextInt();

        if (winCondition > size) {
            System.out.println("Liczba symboli do zwycięstwa nie może być większa niż rozmiar planszy!");
            return;
        }

        GameBoard gameBoard = new GameBoard(size);
        GameRules gameLogic = new GameRules(gameBoard.getBoard(), winCondition);
        ComputerIsPlayer computerPlayer = (mode == 2) ? new ComputerIsPlayer('O', random) : null;

        char currentPlayer = (Math.random() < 0.5) ? 'X' : 'O';

        while (true) {
            gameBoard.displayBoard();

            if (mode == 1 || (mode == 2 && currentPlayer == 'X')) {
                // Ruch gracza
                System.out.println("Gracz " + currentPlayer + ", podaj wiersz (0-" + (size - 1) + "):");
                int row = scanner.nextInt();
                System.out.println("Gracz " + currentPlayer + ", podaj kolumnę (0-" + (size - 1) + "):");
                int col = scanner.nextInt();

                if (!gameBoard.makeMove(row, col, currentPlayer)) {
                    System.out.println("Spróbuj ponownie.");
                    continue;
                }
            } else {
                // Ruch komputera
                computerPlayer.makeMove(gameBoard);
            }

            // Sprawdzanie warunków zakończenia gry
            if (gameLogic.checkWinner(currentPlayer)) {
                gameBoard.displayBoard();
                System.out.println((mode == 2 && currentPlayer == 'O' ? "Komputer" : "Gracz " + currentPlayer) + " wygrywa! Gratulacje!");
                break;
            } else if (gameLogic.isDraw()) {
                gameBoard.displayBoard();
                System.out.println("Remis! Plansza jest pełna.");
                break;
            }

            // Zmiana gracza
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        System.out.println("Czy chcesz zagrać ponownie? (tak/nie)");
        String answer = scanner.next();
        if (answer.equalsIgnoreCase("tak")) {
            main(null); // Restart gry
        } else {
            System.out.println("Dziękujemy za grę!");
            scanner.close();
        }
    }
}