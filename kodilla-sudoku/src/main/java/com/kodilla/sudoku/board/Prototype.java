package com.kodilla.sudoku.board;

public class Prototype implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Object) super.clone();
    }
}