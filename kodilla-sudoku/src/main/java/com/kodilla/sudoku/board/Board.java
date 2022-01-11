package com.kodilla.sudoku.board;

import java.util.*;

public class Board extends Prototype {
    public final static int MIN_INDEX = 0;
    public final static int MAX_INDEX = 8;
    private List<Rows> sudokuBoard = new ArrayList<>();

    public Board() {
    }

    public void createBoard() {
        for (int i = 0; i < 9; i++) {
            sudokuBoard.add(new Rows());
        }
        for (Rows row: sudokuBoard) {
            row.getEmptyRow();
        }
    }

    public void addInputToSudoku(int x, int y, int value) {
        sudokuBoard.get(x-1).getRows().set(y-1, new SudokuElements(value));
    }

    public List<Rows> getBoard() {
        return sudokuBoard;
    }

    public Board deepCopy() throws CloneNotSupportedException {
        Board backtrackBoard = (Board)super.clone();
        backtrackBoard.sudokuBoard = new ArrayList<>();
        for (Rows row: sudokuBoard){
            Rows backtrackRow = new Rows();
            for (SudokuElements element : row.getRows()) {
                backtrackRow.getRows().add(element);
            }
            backtrackBoard.getBoard().add(backtrackRow);
        }
        return backtrackBoard;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("---------------------------------------");
        result.append("\n");
        for (int i = MIN_INDEX; i <= MAX_INDEX; i++) {
            result.append(" | ");
            for (int j = MIN_INDEX; j <= MAX_INDEX; j++) {
                if (sudokuBoard.get(i).getRows().get(j).getValue() == -1) {
                    result.append(" ");
                } else {
                    result.append((sudokuBoard.get(i).getRows().get(j).getValue()));
                }
                result.append(" | ");
            }
            result.append("\n");
            result.append("---------------------------------------");
            result.append("\n");
        }
        return result.toString();
    }
}