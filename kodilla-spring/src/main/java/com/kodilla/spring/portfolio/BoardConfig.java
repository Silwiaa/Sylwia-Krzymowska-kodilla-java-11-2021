package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Autowired
    @Qualifier("toDoList")
    public TaskList taskList1;

    @Autowired
    @Qualifier("inProgressList")
    public TaskList taskList2;

    @Autowired
    @Qualifier("doneList")
    public TaskList taskList3;

    @Bean(name = "toDoList")
    @Scope("prototype")
    public TaskList getToDoList() {
        return new TaskList();
    }

    @Bean(name = "inProgressList")
    @Scope("prototype")
    public TaskList getInProgressList() {
        return new TaskList();
    }

    @Bean(name = "doneList")
    @Scope("prototype")
    public TaskList getDoneTasks() {
        return new TaskList();
    }

    @Bean
    public Board getBoard() {
        return new Board(taskList1, taskList2, taskList3);
    }
}
