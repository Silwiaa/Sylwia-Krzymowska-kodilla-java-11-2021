package com.kodilla.stream.beautifier;

import com.kodilla.stream.lambda.MathExpression;

public class PoemBeautifier {
    public void beautify(String myText, PoemDecorator poemDecorator) {
        String beautifiedText = poemDecorator.decorate(myText);
        System.out.println(beautifiedText);
    }
}