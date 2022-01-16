package com.kodilla.sudoku;

import java.util.*;

public class SudokuElement {
    private int value;
    public static int EMPTY = -1;

    public SudokuElement(int value) {
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
            if (value < 10) {
                return "  " + value + " ";
            } else {
                return value + " ";
            }
        } else {
            return "    ";
        }
    }
}
