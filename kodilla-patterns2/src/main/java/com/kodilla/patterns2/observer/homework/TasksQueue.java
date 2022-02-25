package com.kodilla.patterns2.observer.homework;

import java.util.*;

public class TasksQueue implements Observable {
    private final List<String> tasksQueue;
    private final List<Observer> observers;
    private final String student;

    public TasksQueue(final String student) {
        this.observers = new ArrayList<>();
        this.tasksQueue = new ArrayList<>();
        this.student = student;
    }

    public void addTask(String task) {
        tasksQueue.add(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public List<String> getTasks() {
        return tasksQueue;
    }

    public String getStudent() {
        return student;
    }
}
