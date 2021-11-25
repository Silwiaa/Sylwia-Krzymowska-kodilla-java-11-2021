package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.Map;

public class StreamMain {
    public static void main(String[] args) {

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

        //Zadanie 7.2: niemutowalny użytkownik forum

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String myString = "Hello Word";

        poemBeautifier.beautify(myString, (myText -> myText + "!"));
        poemBeautifier.beautify(myString, (myText -> myText.toUpperCase() + "!"));
        poemBeautifier.beautify(myString, (myText -> (myText + "! ").repeat(2)));
        poemBeautifier.beautify(myString, (myText -> myText.substring(0, 5) + "!"));
    }
}