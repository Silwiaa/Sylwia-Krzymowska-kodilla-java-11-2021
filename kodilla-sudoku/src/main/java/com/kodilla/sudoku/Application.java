package com.kodilla.sudoku;

public class Application {
    public static void main(String[] args) {
        boolean gameFinished = false;

        while (!gameFinished) {
            Game game = new Game();
            gameFinished = game.resolve();
        }
    }
}
