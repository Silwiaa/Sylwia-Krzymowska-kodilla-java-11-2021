package com.kodilla.sudoku.board;

import com.kodilla.sudoku.Prototype;

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
        String boardToPrint = "";

        for (int i = 0 ; i < 9 ; i++) {
            String rowToPrint = "\n" + board.get(i).toString() + "|\n";

            if (i % 3 == 0) {
                boardToPrint += groupLine + rowToPrint;

            } else {
                boardToPrint += innerLine + rowToPrint;
            }
        }
        return boardToPrint + groupLine + "\n";
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

    public void updateElementsInGroup(SudokuBoard sudokuBoard, SudokuRow row, int columnNo, int rowNo, int value) {
        int startRow = (rowNo - 1) - (rowNo -1) % 3;
        int startColumn = (columnNo -1) - (columnNo -1) % 3;
        List<Integer> takenValuesInGroup = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int currentValue = sudokuBoard.getBoard().get(startRow + i).getElements().get(startColumn + j).getValue();
                if (currentValue != SudokuElement.EMPTY) {
                    takenValuesInGroup.add(currentValue);
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                List<Integer> possibleValues = sudokuBoard.getBoard().get(startRow + i).getElements().get(startColumn + j).getPossibleValues();
                for (int takenValue : takenValuesInGroup) {
                    if (possibleValues.contains(takenValue))
                        possibleValues.removeAll(takenValuesInGroup);
                }
            }
        }
    }

    public void updateElementsInRow(SudokuRow row, int value) {
        row.getTakenValues().add(value);

        for (SudokuElement element : row.getElements()) {

            List<Integer> possibleValues = element.getPossibleValues();

            if (possibleValues.contains(value)) {
                possibleValues.remove(possibleValues.indexOf(value));

            }
        }
    }

    public void updateElementsInColumn(SudokuBoard sudokuBoard, int columnNo, int value) {

        for (SudokuRow row : sudokuBoard.getBoard()) {
            List<Integer> possibleValues = row.getElements().get(columnNo - 1).getPossibleValues();

            if (possibleValues.contains(value))
                possibleValues.remove(possibleValues.indexOf(value));

        }

    }
}
