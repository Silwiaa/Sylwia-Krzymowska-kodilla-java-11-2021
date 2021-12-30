package com.kodilla.good.patterns.food2Door;

import java.util.List;

public class ItemOrderRepository implements OrderRepository {
    @Override
    public boolean createOrder(List<OrderRequest> orderedList) {
        System.out.println("New order added to repository");
        System.out.println("Ordered list: " + showOrderList(orderedList));
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
