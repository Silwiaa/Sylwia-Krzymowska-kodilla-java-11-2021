package com.kodilla.testing.collection;

import java.util.*;

public class OddNumbersExterminator {
    List<Integer> evenList = new ArrayList<>();
    List<Integer> oddList = new ArrayList<>();

    public List<Integer> exterminate(List<Integer> numbers) {
        for (int number : numbers) {
                if (number % 2 == 0) {
                    evenList.add(number);
                } else {
                    oddList.add(number);
                }
        }
        return evenList;
    }
}
