package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {
        public static final String DRIVINGTASK = "DRIVINGTASK";
    public static final String PAINTINGTASK = "PAINTINGTASK";
    public static final String SHOPPINGTASK = "SHOPPINGTASK";

    public final Task makeShape(final String shapeClass) {
        switch (shapeClass) {
            case DRIVINGTASK:
                return new DrivingTask("Driving", "home", "car");
            case PAINTINGTASK:
                return new PaintingTask("Painting", "blue", "wall");
            case SHOPPINGTASK:
                return new ShoppingTask("Buying", "sugar", 2.5);
            default:
                return null;
        }
    }
}
