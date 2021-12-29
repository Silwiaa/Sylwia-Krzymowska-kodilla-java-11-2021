package com.kodilla.good.patterns.challenges;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        MovieStore store = new MovieStore();
        Map<String, List<String>> movies = store.getMovies();

        String movieTitles = movies.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toSet()).stream()
                .collect(Collectors.joining("!"));

        System.out.println(movieTitles);
    }
}


