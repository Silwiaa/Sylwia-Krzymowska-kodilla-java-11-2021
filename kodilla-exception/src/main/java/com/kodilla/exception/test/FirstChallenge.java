package com.kodilla.exception.test;

public class FirstChallenge {
    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();
        double result = 0.0;

        try {
            result = firstChallenge.divide(6, 0);
        } catch (ArithmeticException aExc) {
            System.out.println("Not valid divider value - can't divide by 0: " + aExc);
        } finally {
            System.out.println(result);
        }
    }
}
