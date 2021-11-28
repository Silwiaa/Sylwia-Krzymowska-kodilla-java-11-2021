package com.kodilla.newStream.beautifier;

public class PoemBeautifier {
    public void beautify(String myText, PoemDecorator poemDecorator) {
        String beautifiedText = poemDecorator.decorate(myText);
        System.out.println(beautifiedText);
    }
}
