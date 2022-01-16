package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuGame {
    private SudokuBoard sudokuBoard = new SudokuBoard();
    private TextScanner textScanner = new TextScanner();
    private int rowNo;
    private int columnNo;
    private int value;
    private SudokuElement element;
    private SudokuRow row;
    private String userChoice;
    private boolean isGameFinished = false;

    public SudokuGame(){
        startTheGame();
    }

    private void startTheGame() {
        printWelcomeInfo();
        sudokuBoard.createBoard();
        System.out.println(sudokuBoard);
        printGameInstruction();
    }

    private void printWelcomeInfo() {
        String gameTitle = "\nWelcome to SUDOKU game! \n";
        System.out.println(gameTitle);
    }

    private void printGameInstruction() {
        String gameInstruction = "" +
                "Enter three integer values to start the game. Example: \'123\' means: \n " +
                "row-> 1 \n " +
                "column-> 2 \n " +
                "value-> 3 \n" +
                "You can choose the value only from: 1, 2, 3, 4, 5, 6, 7, 8, 9. \n" +
                "Remember! You can not use the same value twice in the same: row, " +
                "column or group (groups are situated between corners marked with \'+\' sign";
        System.out.println(gameInstruction);
        System.out.println();
        System.out.println("Enter your values:");
    }

    public boolean resolveSudoku() {
        scanUserChoice(1);
        System.out.println(sudokuBoard);
        printNextStepInstruction();
        scanUserChoice(2);

        if (isGameFinished) {
            return true;

        } else {
            System.out.println(sudokuBoard);
            printNextStepInstruction();
            return false;
        }
    }

    private void scanUserChoice(int checkNumber) {
        if (checkNumber == 1) {
            userChoice = textScanner.scanUserChoice();

        } else {
            userChoice = textScanner.scanNextStepUserValue();
        }

        if (userChoice.equals("SUDOKU")) {
            solveSudoku();

        } else {
            fillBoard();
        }
    }

    public void solveSudoku() {
        System.out.println("Solving sudoku");
        isGameFinished = true;
    }

    private void fillBoard() {
        interpretUserChoice();

        while(!checkIfIsFreeField()) {
            System.out.println("Column nr: " + columnNo + ", row: " + rowNo + " is filled. Pick up another field:");
            userChoice = textScanner.scanNextStepUserValue();
            checkIfIsFreeField();
        }
        checkIfIsValidMove();
        element.setValue(value);
        row.getTakenValues().add(value);
    }

    private void interpretUserChoice() {
        rowNo = Integer.parseInt(userChoice.substring(0, 1));
        columnNo = Integer.parseInt(userChoice.substring(1, 2));
        value = Integer.parseInt(userChoice.substring(2, 3));
        element = sudokuBoard.getBoard().get(rowNo -1).getElements().get(columnNo -1);
        row = sudokuBoard.getBoard().get(rowNo -1);
    }

    private boolean checkIfIsFreeField() {
        interpretUserChoice();

        if (element.getValue() == -1) {
            return true;

        } else {
            return false;
        }
    }

    private void checkIfIsValidMove() {

        //check if the value has been taken in current row
        while (row.getTakenValues().contains(value)) {
            checkNextMoveAfterNegativeValidation();
        }

        List<Integer> possibleValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        possibleValues.removeAll(row.getTakenValues());
        List<Integer> takenValues = new ArrayList<>();

        //check if the value has been taken in current column
        for (int i = 0 ; i < 9 ; i++) {
            takenValues.add(sudokuBoard.getBoard().get(i).getElements().get(columnNo-1).getValue());
        }

        possibleValues.removeAll(takenValues);

        while (!possibleValues.contains(value)) {
            checkNextMoveAfterNegativeValidation();
        }

        while (!checkValueInGroup()) {
            checkNextMoveAfterNegativeValidation();
        }
    }

    public void checkNextMoveAfterNegativeValidation() {
        String wrongValueMessage = "The same value can't be placed twice in the same row, column or group!";
        System.out.println(wrongValueMessage);
        userChoice = textScanner.scanNextStepUserValue();
        interpretUserChoice();
    }

    public boolean checkValueInGroup() {
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

    private void printNextStepInstruction() {
        String nextStepInstruction = "Enter new values to continue or enter SUDOKU to solve the game:";
        System.out.println(nextStepInstruction);
    }
}
