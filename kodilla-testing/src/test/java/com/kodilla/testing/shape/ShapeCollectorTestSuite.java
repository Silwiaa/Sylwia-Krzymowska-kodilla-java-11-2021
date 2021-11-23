package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Shape Collector Test Suite")
public class ShapeCollectorTestSuite {

    @Nested
    @DisplayName("Tests for addFigure")

    class addFigure {
        ShapeCollector shapeCollector = new ShapeCollector();

        @Test
        void addCircle() {
            //Given
            Shape shape = new Circle(4.0);
            //When
            boolean check = shapeCollector.addFigure(shape);
            //Then
            assertEquals(true, check);
        }

        @Test
        void addSquare() {
            //Given
            Shape shape = new Square(4.0);
            //When
            boolean check = shapeCollector.addFigure(shape);
            //Then
            assertEquals(true, check);
        }

        @Test
        void addTriangle() {
            //Given
            Shape shape = new Triangle(4.0, 8);
            //When
            boolean check = shapeCollector.addFigure(shape);
            //Then
            assertEquals(true, check);
        }
    }

    @Nested
    @DisplayName("Tests for removeFigure")

    class removeFigure {
        ShapeCollector shapeCollector = new ShapeCollector();

        @Test
        void removeFromEmptyList() {
            //Given
            Shape shape = new Circle(6.0);
            //When
            boolean check = shapeCollector.removeFigure(shape);
            //Then
            assertNotEquals(true, false);
        }

        @Test
        void removeCircle() {
            //Given
            Shape shape = new Circle(4.0);
            shapeCollector.addFigure(shape);
            //When
            boolean check = shapeCollector.removeFigure(shape);
            //Then
            assertEquals(true, check);
        }

        @Test
        void removeSquare() {
            //Given
            Shape shape = new Square(4.0);
            shapeCollector.addFigure(shape);
            //When
            boolean check = shapeCollector.removeFigure(shape);
            //Then
            assertEquals(true, check);
        }

        @Test
        void removeTriangle() {
            //Given
            Shape shape = new Triangle(4.0, 8);
            shapeCollector.addFigure(shape);
            //When
            boolean check = shapeCollector.removeFigure(shape);
            //Then
            assertEquals(true, check);
        }
    }

    @Nested
    @DisplayName("Tests for getFigure")

    class getFigure {
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape circle = new Circle(4.0);
        Shape square = new Square(4.0);
        Shape triangle = new Triangle(4.0, 8.0);

        @Test
        void getCircle() {
            //Given
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(triangle);
            //When
            Shape result = shapeCollector.getFigure(0);
            //Then
            assertEquals(circle, result);
        }

        @Test
        void getSquare() {
            //Given
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(triangle);
            //When
            Shape result = shapeCollector.getFigure(1);
            //Then
            assertEquals(square, result);
        }

        @Test
        void getTriangle() {
            //Given
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(triangle);
            //When
            Shape result = shapeCollector.getFigure(2);
            //Then
            assertEquals(triangle, result);
        }
    }
}


