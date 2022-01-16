package com.kodilla.sudoku;

import java.util.Scanner;

public class TextScanner {
    private Scanner scanner = new Scanner(System.in);

    public String scanUserChoice() {
        String userValue = scanner.nextLine();

        while (!checkIfIsNumericValue(userValue)) {
            System.out.println("Use only integers");
            userValue = scanner.nextLine();
            checkIfIsNumericValue(userValue);
        }

         while (!checkIfIsValidNumber(userValue)) {
             System.out.println("Input 3 numbers from 1 to 9!");
             userValue = scanner.nextLine();
             checkIfIsValidNumber(userValue);
         }

        return userValue;
    }

    String scanNextStepUserValue() {
        String nextStepUserValue = scanner.nextLine();

        while (!checkIfIsNumericValue(nextStepUserValue)) {

            if (isSolveRequest(nextStepUserValue)) {
                return "SUDOKU";

            } else {
                System.out.println("Invalid value. Enter new integers values to continue or enter SUDOKU to solve the game:");
                nextStepUserValue = scanner.nextLine();
                checkIfIsNumericValue(nextStepUserValue);
            }
        }

        while (!checkIfIsValidNumber(nextStepUserValue)) {
            System.out.println("Wrong value! Enter three integers values:");
            nextStepUserValue = scanner.nextLine();

            if (isSolveRequest(nextStepUserValue)) {
                System.out.println("Solve the game is impossible at this step. Enter three integer values first:");
                nextStepUserValue = scanner.nextLine();

            } else {
                checkIfIsValidNumber(nextStepUserValue);
            }
        }

        return nextStepUserValue;
    }

    private boolean checkIfIsNumericValue(String userValue) {
        Scanner scan = new Scanner(userValue);
        return scan.hasNextInt();
    }

    private boolean checkIfIsValidNumber(String userValue) {
        boolean result = false;

        if (userValue.length() == 3)
            result = true;
        
        return result;
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
