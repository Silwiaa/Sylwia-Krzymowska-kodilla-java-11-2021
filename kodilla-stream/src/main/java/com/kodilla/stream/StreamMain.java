package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String myString = "Hello Word";

        poemBeautifier.beautify(myString, (myText -> myText + "!"));
        poemBeautifier.beautify(myString, (myText -> myText.toUpperCase() + "!"));
        poemBeautifier.beautify(myString, (myText -> (myText + "! ").repeat(2)));
        poemBeautifier.beautify(myString, (myText -> myText.substring(0, 5) + "!"));
    }
}
