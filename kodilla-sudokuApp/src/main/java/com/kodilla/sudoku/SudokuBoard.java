package com.kodilla.sudoku;

import java.util.*;

public class SudokuBoard extends Prototype<SudokuBoard> {
    private List<SudokuRow> board = new ArrayList<>();

    public void createBoard() {
        for (int i = 0 ; i < 9 ; i++ ) {
            SudokuRow row = new SudokuRow();
            board.add(row);
        }
    }

    public List<SudokuRow> getBoard() {
        return board;
    }

    @Override
    public String toString() {
        String innerLine = "| . . . . . . .|. . . . . . . | . . . . . . .|";
        String groupLine = "+--------------+--------------+--------------+";
        String printedBoard = "";
        for (int i = 0 ; i < 9 ; i++) {
            if (i % 3 == 0) {
                printedBoard += groupLine + "\n" + board.get(i).toString() + "|\n";
            } else {
                printedBoard += innerLine + "\n" + board.get(i).toString() + "|\n";
            }
        }
        return printedBoard + groupLine + "\n";
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard clonedBoard = super.clone();
        clonedBoard.board = new ArrayList<>();
        for (SudokuRow row : board) {
            SudokuRow clonedRow = new SudokuRow();
            for (SudokuElement element : row.getElements()) {
                clonedRow.getElements().add(element);
            }
            clonedBoard.getBoard().add(clonedRow);
        }
        return clonedBoard;
    }
}
