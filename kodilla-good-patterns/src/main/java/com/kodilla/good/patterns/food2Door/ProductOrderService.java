package com.kodilla.good.patterns.food2Door;

import java.util.List;

public class ProductOrderService implements OrderService {
    @Override
    public boolean order(List<OrderRequest> orderedList) {
        System.out.println("New order send to providers.");
        System.out.println("Ordered products: " + "\n" + showOrderList(orderedList));

        ExtraFoodShop extraFoodShop = new ExtraFoodShop();
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop();
        HealthyShop healthyShop = new HealthyShop();

        for (OrderRequest order: orderedList) {
            String provider = order.getProvider();
            if (provider == "Extra Food Shop") {
                extraFoodShop.process(order);
            } else if (provider == "Gluten Free Shop") {
                glutenFreeShop.process(order);
            } else {
                healthyShop.process(order);
            }
        }
        return true;
    }

    private String showOrderList(List<OrderRequest> orderListToShow) {
        String orderList = "";
        for (int i = 0 ; i < orderListToShow.size() ; i++) {
            OrderRequest orderRequest =  orderListToShow.get(i);
            String provider = orderRequest.getProvider();
            String productType = orderRequest.getProductType();
            int quantity = orderRequest.getQuantity();
            orderList += productType + ": " + quantity + ", from: " + provider + "\n";
        }
        return orderList;
    }
}
