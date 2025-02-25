package tn.fst;

import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private boolean gameEnded;
    private String gameState;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        gameEnded = false;
        gameState = "In progress";
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public boolean play(int x, int y) {
        if (x < 0 || x >= 3 || y < 0 || y >= 3) {
            throw new RuntimeException("Position out of bounds");
        }
        if (board[x][y] != '-') {
            throw new RuntimeException("Cell already occupied");
        }
        board[x][y] = currentPlayer;
        if (checkWin()) {
            gameState = "Player " + currentPlayer + " wins!";
            gameEnded = true;
            return true;
        }
        if (isBoardFull()) {
            gameState = "Draw!";
            gameEnded = true;
            return true;
        }
        switchPlayer();
        return false;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private boolean isBoardFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        boolean gameEnded = false;

        System.out.println("Tic-Tac-Toe Game");
        game.printBoard();

        while (!gameEnded) {
            System.out.println("Player " + game.currentPlayer + ", enter your move (row and column): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            try {
                gameEnded = game.play(x, y);
                game.printBoard();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(game.getGameState());
        scanner.close();
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public String getGameState() {
        return gameState;
    }
}