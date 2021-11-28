package com.kodilla.newStream;

import com.kodilla.newStream.beautifier.PoemBeautifier;
import com.kodilla.newStream.book.Book;
import com.kodilla.newStream.book.BookDirectory;
import com.kodilla.newStream.forumuser.Forum;
import com.kodilla.newStream.forumuser.ForumUser;
import com.kodilla.newStream.iterate.NumbersGenerator;
import com.kodilla.newStream.lambda.ExecuteSaySomething;
import com.kodilla.newStream.lambda.Executor;
import com.kodilla.newStream.lambda.Procesor;
import com.kodilla.newStream.lambda.SaySomething;
import com.kodilla.newStream.lambda.ExpressionExecutor;
import com.kodilla.newStream.person.People;
import com.kodilla.newStream.reference.FunctionalCalculator;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {

        /* SaySomething class
        System.out.println("Welcome to module 7 - Stream");

        SaySomething saySomething = new SaySomething();
        saySomething.say();*/

        /* OOP way
        Procesor processor = new Procesor();
        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        processor.execute(executeSaySomething);*/

        /* Lambda expression
        Procesor processor = new Procesor();
        Executor codeToExecute = () -> System.out.println("This is an example text.");
        processor.execute(codeToExecute);*/

        /* Calculating expressions with lambdas and method reference
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);*/

        /*  Text beautifier exc 7.1
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String myText = "Hello Word";

        poemBeautifier.beautify(myText, (text -> text.toUpperCase()));
        poemBeautifier.beautify(myText, (text -> text + "!"));
        poemBeautifier.beautify(myText, (text -> text.substring(0, 5) + "!"));*/

        /* Final
        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);*/

        /* People class
        People.getList().stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(System.out::println);*/

        /*BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theResultStringOfBooks);*/
        //Zadanie 7.3: funkcyjny spacer po liście użytkowników forum

        Forum forum = new Forum();
        Map<Integer, ForumUser> theResultForumUserList = forum.getForumUserList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> forumUser.getDateOfBirth().getYear() <= LocalDate.now().getYear() - 20)
                .filter(forumUser -> forumUser.getPublicatedPstsNo() >= 1)
                .collect(Collectors.toMap(ForumUser::getIdentifier, forumUser -> forumUser));

        System.out.println("# elements: " + theResultForumUserList.size());

        theResultForumUserList.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}
