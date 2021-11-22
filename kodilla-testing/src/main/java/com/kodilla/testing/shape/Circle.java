package com.kodilla.testing.shape;

public class Circle implements Shape {
    private String name = "Circle";
    private double pi = 3.14;
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return pi * (r * r);
    }
}
