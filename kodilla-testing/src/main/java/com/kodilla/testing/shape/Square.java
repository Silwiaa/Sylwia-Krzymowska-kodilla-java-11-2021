package com.kodilla.testing.shape;

public class Square implements Shape {
    private String name = "Square";
    private double a;

    public Square(double a) {
        this.a = a;
    }

    @Override
    public String getShapeName() {
        return "String";
    }

    @Override
    public double getField() {
        return a * a;
    }
}
