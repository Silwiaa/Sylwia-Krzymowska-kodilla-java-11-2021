package com.kodilla.good.patterns.challenges;

public class Application {
    public static void main(String[] args) {
        //Exc 13.1
        /*
        MovieStore store = new MovieStore();

        Map<String, List<String>> movies = store.getMovies();

        String movieTitles = movies.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toSet()).stream()
                .collect(Collectors.joining("!"));

        System.out.println(movieTitles);
        */

        //Exc 13.2
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(
                new MailService(),
                new ProductOrderService(),
                new ItemOrderRepository());
        orderProcessor.process(orderRequest);
    }
}


