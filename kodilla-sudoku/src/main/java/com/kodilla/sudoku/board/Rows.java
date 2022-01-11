package com.kodilla.sudoku.board;

import java.util.*;

public class Rows {
    private final List<SudokuElements> sudokuRows = new ArrayList<>();

    public Rows() {
    }

    public List<SudokuElements> getEmptyRow() {
        for (int i =0; i<9; i++){
            sudokuRows.add(new SudokuElements(SudokuElements.EMPTY));
        }
        return new ArrayList<>(sudokuRows);
    }

    public List<SudokuElements> getRows() {
        return sudokuRows;
    }
}
