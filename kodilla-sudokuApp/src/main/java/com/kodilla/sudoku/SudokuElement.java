package com.kodilla.sudoku;

import java.util.*;

public class SudokuElement {
    private int value;
    public static int EMPTY = -1;
    private List<Integer> possibleValues;

    public SudokuElement(int value) {
        this.possibleValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int newValue) {
        this.value = newValue;
    }

    @Override
    public String toString() {
        if (value != EMPTY) {
            return "  " + value + " ";
        } else {
            return "    ";
        }
    }
}
