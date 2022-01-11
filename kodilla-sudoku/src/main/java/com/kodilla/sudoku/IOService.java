package com.kodilla.sudoku;

import java.util.*;
import java.util.Scanner;

public class IOService {
    private final static Scanner scanner = new Scanner(System.in);

    public IOService() {

    }
    public static List<String> getInput() {
        List<String> inputList = new ArrayList<>();
        System.out.println("Please insert Your input in 'xyz' format, example: 123" + "\nInfo: " +
                "\n1 - Row, 2 - Column, 3 - Value");
        System.out.println();
        inputList.add(checkNumber(scanner.nextLine()));
        return inputNext(inputList);
    }
    public static List<String> inputNext(List<String> inputList) {
        System.out.println("Please insert Your next input in format 'xyz' example 123. " +
                "If not press 'n' to go to the next step");
        String input = scanner.nextLine();
        while (!input.equals("n")) {
            inputList.add(checkNumber(input));
            System.out.println("Please insert Your next input in format 'xyz' example 123." +
                    "If not press 'n' to go to the next step");
            input = scanner.nextLine();
        }
        return inputList;
    }
    public static String checkNumber(String text) {
        while (!text.matches("-?[1-9]{3}")) {
            System.out.println("Wrong input - only numbers from 1 to 9");
            text = scanner.nextLine();
        }
        return text;
    }
}
