package com.kodilla.sudoku;

import java.util.*;

public class SudokuRow {
    private List<SudokuElement> elements;
    private List<Integer> takenValues;
    private int rowNo;

    public SudokuRow() {
        this.elements = new ArrayList<>();
        this.takenValues = new ArrayList<>();
        createEmptyRow();
    }

    private void createEmptyRow() {
        for (int i = 1 ; i < 10 ; i++ ) {
            SudokuElement element = new SudokuElement(SudokuElement.EMPTY);
            elements.add(element);
        }
    }

    public List<SudokuElement> getElements() {
        return elements;
    }

    public List<Integer> getTakenValues() {
        return takenValues;
    }

    @Override
    public String toString() {
        String s = "";
        for (SudokuElement element : elements) {
            s += "|" + element.toString();
        }
        return s;
    }
}
