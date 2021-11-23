package com.kodilla.testing.shape;

import java.util.*;

public class ShapeCollector {
    private List<Shape> figureList = new ArrayList<>();

    public boolean addFigure(Shape shape) {
        figureList.add(shape);
        return true;
    }

    public boolean removeFigure(Shape shape) {
        if (figureList.contains(shape)) {
            figureList.remove(shape);
            return true;
        } else {
            return false;
        }
    }

    public Shape getFigure(int n) {
        return figureList.get(n);
    }

    public List showFigures() {
        return figureList;
    }
}



