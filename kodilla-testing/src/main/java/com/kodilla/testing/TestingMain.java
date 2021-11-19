package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

import java.awt.*;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("Joe");
        String result = simpleUser.getUsername();

        if (result.equals("Joe")) {
            System.out.println("test ok");
        } else {
            System.out.println("Error!");
        }

        //Calculator unit test
        Calculator calculator = new Calculator();
        int addResult = calculator.add(2, 5);
        int substractResult = calculator.substract(5, 2);

        if (addResult == 7) {
            System.out.println("add() method test ok");
        } else {
            System.out.println("add() method - error");
        }

        if (substractResult == 3) {
            System.out.println("substract() method test ok");
        } else {
            System.out.println("add() method - error");
        }
    }
}
