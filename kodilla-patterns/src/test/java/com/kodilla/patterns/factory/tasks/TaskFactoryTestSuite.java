package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskFactoryTestSuite {
    @Test
    void testFactoryDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task drivingTask = factory.makeShape(TaskFactory.DRIVINGTASK);
        drivingTask.executeTask();
        //Then
        assertEquals(true, drivingTask.isTaskExecuted());
        assertEquals("Driving", drivingTask.getTaskName());
    }

    @Test
    void testFactoryPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task paintingTask = factory.makeShape(TaskFactory.PAINTINGTASK);
        paintingTask.executeTask();
        //Then
        assertEquals(true, paintingTask.isTaskExecuted());
        assertEquals("Painting", paintingTask.getTaskName());
    }

    @Test
    void testFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shoppingTask = factory.makeShape(TaskFactory.SHOPPINGTASK);
        shoppingTask.executeTask();
        //Then
        assertEquals(true, shoppingTask.isTaskExecuted());
        assertEquals("Buying", shoppingTask.getTaskName());
    }
}
