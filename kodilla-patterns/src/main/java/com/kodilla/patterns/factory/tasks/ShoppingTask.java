package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task{
    private String taskName;
    private String whatToBuy;
    private double quantity;
    private boolean isTaskExecuted;

    ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public void executeTask() {
        System.out.println(taskName + " " + quantity + " kg of " +  whatToBuy);
        isTaskExecuted = true;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        if (isTaskExecuted) {
            return true;
        } else {
            return false;
        }
    }
}
