package com.kodilla.sudoku;

import com.kodilla.sudoku.board.*;
import java.util.*;
import java.util.stream.Collectors;

public class MoveValidator {

    public boolean checkIfIsNumericValue(String userChoice) {
        Scanner scan = new Scanner(userChoice);
        return scan.hasNextInt();
    }

    public boolean checkIfIsValidNumber(String userChoice) {
        boolean result = false;

        if (userChoice.length() == 3)
            result = true;

        return result;
    }

    public boolean checkIfIsValidMove(SudokuBoard sudokuBoard, SudokuRow row, int columnNo, int rowNo, int value) {

        //check if the value has been taken in current row
        while (row.getTakenValues().contains(value)) {
            return false;
        }

        //check if the value has been taken in current column
        List<Integer> possibleValues = getPossibleValues(sudokuBoard, row, columnNo);
        while (!possibleValues.contains(value)) {
            return false;
        }

        //check if the value has been taken in current group
        while (!checkPossibleValuesInGroup(sudokuBoard, rowNo, columnNo, value)) {
            return false;
        }
        return true;
    }

    public List<Integer> getPossibleValues(SudokuBoard sudokuBoard, SudokuRow row, int columnNo) {
        List<Integer> possibleValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        possibleValues.removeAll(row.getTakenValues());
        List<Integer> takenValues = new ArrayList<>();

        for (int i = 0 ; i < 9 ; i++) {
            takenValues.add(sudokuBoard.getBoard().get(i).getElements().get(columnNo-1).getValue());
        }

        possibleValues.removeAll(takenValues);
        return possibleValues;
    }

    public boolean checkPossibleValuesInGroup(SudokuBoard sudokuBoard, int rowNo, int columnNo, int value) {
        int startRow = (rowNo - 1) - (rowNo -1) % 3;
        int startColumn = (columnNo -1) - (columnNo -1) % 3;
        List<Integer> takenValuesInGroup = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int currentValue = sudokuBoard.getBoard().get(startRow + i).getElements().get(startColumn + j).getValue();
                if (currentValue != SudokuElement.EMPTY)
                    takenValuesInGroup.add(currentValue);
            }
        }

        if (takenValuesInGroup.contains(value))
            return false;

        return true;
    }

}
