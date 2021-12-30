package com.kodilla.good.patterns.food2Door;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        List<OrderRequest> orderedProducts = orderRequestRetriever.getOrderedProductList();

        OrderProcessor orderProcessor = new OrderProcessor(new MailService(), new ProductOrderService(), new ItemOrderRepository());
        orderProcessor.process(orderedProducts);
    }
}
