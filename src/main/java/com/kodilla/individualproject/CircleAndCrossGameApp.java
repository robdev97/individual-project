package com.kodilla.individualproject;

import java.util.Random;
import java.util.Scanner;

public class CircleAndCrossGameApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the game of tic-tac-toe!");
        System.out.println("Select a game mode:");
        System.out.println("1 - Player vs Player");
        System.out.println("2 - Player vs Computer");
        int mode = scanner.nextInt();

        if (mode != 1 && mode != 2) {
            System.out.println("Incorrect choice. The program will terminate the operation..");
            return;
        }

        System.out.print("Choose the size of the board (min 3): ");
        int size = scanner.nextInt();

        System.out.print("Choose the number of symbols needed to win (min 3): ");
        int winCondition = scanner.nextInt();

        if (winCondition > size) {
            System.out.println("The number of symbols to win cannot be larger than the size of the board!");
            return;
        }

        GameBoard gameBoard = new GameBoard(size);
        GameRules gameLogic = new GameRules(gameBoard.getBoard());
        ComputerIsPlayer computerPlayer = (mode == 2) ? new ComputerIsPlayer('O', random) : null;

        char currentPlayer = (Math.random() < 0.5) ? 'X' : 'O';

        while (true) {
            gameBoard.displayBoard();

            if (mode == 1 || currentPlayer == 'X') {

                System.out.println("Player " + currentPlayer + ", specify the row number (0-" + (size - 1) + "):");
                int row = scanner.nextInt();
                System.out.println("Player " + currentPlayer + ", specify the column number(0-" + (size - 1) + "):");
                int col = scanner.nextInt();

                if (!gameBoard.makeMove(row, col, currentPlayer)) {
                    System.out.println("Try again.");
                    continue;
                }
            } else {

                computerPlayer.computerMove(gameBoard);
            }

            if (gameLogic.checkWinner(currentPlayer)) {
                gameBoard.displayBoard();
                System.out.println((mode == 2 && currentPlayer == 'O' ? "Computer" : "Player "
                        + currentPlayer) + " Win! Congratulations!");
                break;
            } else if (gameLogic.isDraw()) {
                gameBoard.displayBoard();
                System.out.println("Draw! The board is full.");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        System.out.println("Do you want to play again? (Yes/No)");
        String answer = scanner.next();
        if (answer.equalsIgnoreCase("Yes")) {
            main(null);
        } else {
            System.out.println("Thanks for playing!");
            scanner.close();
        }
    }
}