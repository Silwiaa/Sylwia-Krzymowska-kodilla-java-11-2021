package com.kodilla.sudoku;

public class SudokuGame {
    private SudokuBoard sudokuBoard = new SudokuBoard();
    private TextScanner textScanner = new TextScanner();
    private MoveValidator moveValidator = new MoveValidator();
    private String userChoice;
    private int rowNo;
    private int columnNo;
    private int value;
    private SudokuRow row;
    private SudokuElement element;
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
            interpretUserChoice();
            fillBoard();
        }
    }

    public void solveSudoku() {
        System.out.println("Solving sudoku");
        isGameFinished = true;
    }

    private void fillBoard() {
        String wrongValueMessage;

        while(element.getValue() != SudokuElement.EMPTY) {
            wrongValueMessage = "Column nr: " + columnNo + ", row: " + rowNo + " is filled. Pick up another field:";
            updateMoveAfterNegativeValidation(wrongValueMessage);
        }

        while(!moveValidator.checkIfIsValidMove(sudokuBoard, row, columnNo, rowNo, value)) {
            wrongValueMessage = "The same value can't be placed twice in the same row, column or group!";
            updateMoveAfterNegativeValidation(wrongValueMessage);

        }

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

    public void updateMoveAfterNegativeValidation(String wrongValueMessage) {
        System.out.println(wrongValueMessage);
        userChoice = textScanner.scanNextStepUserValue();
        interpretUserChoice();
    }

    private void printNextStepInstruction() {
        String nextStepInstruction = "Enter new values to continue or enter SUDOKU to solve the game:";
        System.out.println(nextStepInstruction);
    }
}
