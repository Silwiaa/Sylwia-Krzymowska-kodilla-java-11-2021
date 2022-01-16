package com.kodilla.sudoku;

public class Application {
    public static void main(String[] args) {
        boolean gameFinished = false;
        SudokuGame theGame = new SudokuGame();
        while (!gameFinished) {
            gameFinished = theGame.resolveSudoku();
        }
    }
}
