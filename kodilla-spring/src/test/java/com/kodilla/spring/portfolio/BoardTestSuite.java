package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTestSuite {
    @Test
    void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        board.getToDoList().getTasks().add("To do task1");
        board.getInProgressList().getTasks().add("In progress task1");
        board.getDoneList().getTasks().add("Done task1");
        String toDoFirstTask = board.getToDoList().getTasks().get(0);
        String inProgressFirstTask = board.getInProgressList().getTasks().get(0);
        String doneFirstTask = board.getDoneList().getTasks().get(0);

        //Then
        assertEquals(toDoFirstTask, "To do task1");
        assertEquals(inProgressFirstTask, "In progress task1");
        assertEquals(doneFirstTask, "Done task1");
    }
}
