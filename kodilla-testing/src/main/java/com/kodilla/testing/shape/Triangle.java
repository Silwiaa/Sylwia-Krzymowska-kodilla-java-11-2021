package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private String name = "Triangle";
    private double a;
    private double h;

    public Triangle(double a, double h) {
        this.a = a;
        this.h = h;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return 0.5 * a * h;
    }
}
