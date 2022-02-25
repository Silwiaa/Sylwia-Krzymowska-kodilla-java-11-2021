package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskQueueTestSuite {

    @Test
    public void testUpdate() {

        // Given
        TasksQueue student1 = new Student("John Doe");
        TasksQueue student2 = new Student("Jenny Jane");

        Mentor gandalfTheWhite = new Mentor("Gandalf The White");
        Mentor elrondHalfElven= new Mentor("Elrond Half-elven");

        student1.registerObserver(gandalfTheWhite);
        student2.registerObserver(elrondHalfElven);

        // When
        student1.addTask("Task 1");
        student1.addTask("Task 2");

        student2.addTask("Task 1");
        student2.addTask("Task 2");
        student2.addTask("Task 2");

        // Then
        assertEquals(2, gandalfTheWhite.getUpdateCount());
        assertEquals(3, elrondHalfElven.getUpdateCount());
    }
}
