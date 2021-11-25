package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String myString = "Hello Word";

        poemBeautifier.beautify(myString, (myText -> myText + "!"));
        poemBeautifier.beautify(myString, (myText -> myText.toUpperCase() + "!"));
        poemBeautifier.beautify(myString, (myText -> (myText + "! ").repeat(2)));
        poemBeautifier.beautify(myString, (myText -> myText.substring(0, 5) + "!"));

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}
