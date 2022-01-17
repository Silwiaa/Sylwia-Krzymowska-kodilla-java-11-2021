package com.kodilla.sudoku;

import java.util.Scanner;

public class TextScanner {
    private Scanner scanner = new Scanner(System.in);
    private MoveValidator moveValidator = new MoveValidator();
    private String userChoice;
    private String nextStepUserValue;

    public String scanUserChoice() {
        userChoice = scanner.nextLine();

        while (!moveValidator.checkIfIsNumericValue(userChoice)) {
            updateUserValue(1, "Use only integers");
            moveValidator.checkIfIsNumericValue(userChoice);
        }

         while (!moveValidator.checkIfIsValidNumber(userChoice)) {
             updateUserValue(1, "Input 3 numbers from 1 to 9!");
             moveValidator.checkIfIsValidNumber(userChoice);
         }

        return userChoice;
    }

    public String scanNextStepUserValue() {
        nextStepUserValue = scanner.nextLine();

        while (!moveValidator.checkIfIsNumericValue(nextStepUserValue)) {

            if (isSolveRequest(nextStepUserValue)) {
                return "SUDOKU";

            } else {
                updateUserValue(2, "Invalid value. Enter new integers values to continue or enter SUDOKU to solve the game:");
                moveValidator.checkIfIsNumericValue(nextStepUserValue);
            }
        }

        while (!moveValidator.checkIfIsValidNumber(nextStepUserValue)) {
            updateUserValue(2, "Wrong value! Enter three integers values:");

            if (isSolveRequest(nextStepUserValue)) {
                updateUserValue(2, "Solve the game is impossible at this step. Enter three integer values first:");

            } else {
                moveValidator.checkIfIsValidNumber(nextStepUserValue);
            }
        }

        return nextStepUserValue;
    }

    private void updateUserValue (int valueToUpdate, String message) {
        System.out.println(message);

        if (valueToUpdate == 1) {
            userChoice = scanner.nextLine();
        } else {
            nextStepUserValue = scanner.nextLine();
        }
    }

    private boolean isSolveRequest(String userValue) {
        if (userValue.equals("Sudoku") ||
                userValue.equals("SUDOKU") ||
                userValue.equals("sudoku")) {
            return true;
        } else {
            return false;
        }
    }
}
