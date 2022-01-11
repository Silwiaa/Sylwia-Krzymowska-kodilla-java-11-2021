package com.kodilla.sudoku;

import com.kodilla.sudoku.board.Board;
import com.kodilla.sudoku.board.SudokuElements;

public class Solver {
    private final Board backtrackBoard;

    public Solver(Board board) throws CloneNotSupportedException {
        this.backtrackBoard = board.deepCopy();
    }
    public Board solve() throws CloneNotSupportedException {
        if (!solveBoard()) {
            throw new IllegalArgumentException("Sudoku is not possible to solve");
        }
        return backtrackBoard.deepCopy();
    }

    private boolean solveBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(emptyField(i, j)) {
                    return solveField(i, j);
                }
            }
        }
        return true;
    }

    private boolean emptyField(int x, int y) {
        return backtrackBoard.getBoard().get(x).getRows().get(y).getValue() == SudokuElements.EMPTY;
    }

    private boolean solveField(int x, int y) {
        for (int v = 1; v < 10; v++) {
            if(possibleFill(x, y, v)) {
                backtrackBoard.getBoard().get(x).getRows().get(y).setValue(v);
                if (solveBoard()){
                    return true;
                }
                backtrackBoard.getBoard().get(x).getRows().get(y).setValue(SudokuElements.EMPTY);
            }
        }
        return false;
    }

    private boolean possibleFill(int x, int y, int value) {
        return possibleInLine(x, y, value) && possibleInField(x, y, value);
    }

    private boolean possibleInField(int x, int y, int value) {
        int startX = x - x % 3;
        int startY = y - y % 3;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3;j++){
                if(backtrackBoard.getBoard().get(startX+i).getRows().get(startY+j).getValue()==value) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean possibleInLine(int x, int y, int value) {
        for (int i = 0; i < 9; i++){
            if (backtrackBoard.getBoard().get(i).getRows().get(y).getValue() == value ||
                    backtrackBoard.getBoard().get(x).getRows().get(i).getValue() == value) {
                return false;
            }
        }
        return true;
    }
}