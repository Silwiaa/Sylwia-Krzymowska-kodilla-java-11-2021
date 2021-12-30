package com.kodilla.good.patterns.food2Door;

import java.util.ArrayList;
import java.util.List;

public class OrderRequestRetriever {
    List<OrderRequest> orderedProductList = new ArrayList<>();

    public OrderRequestRetriever() {
        createOrderList();
    }

    public void createOrderList() {
        OrderRequest item1 = new OrderRequest("Extra Food Shop", 2, "milk");
        OrderRequest item2 = new OrderRequest("Extra Food Shop", 1, "butter");
        OrderRequest item3 = new OrderRequest("Gluten Free Shop", 1, "gluten free bread");
        OrderRequest item4 = new OrderRequest("Healthy Shop", 3, "coconut milk");
        orderedProductList.add(item1);
        orderedProductList.add(item2);
        orderedProductList.add(item3);
        orderedProductList.add(item4);
    }

    public List<OrderRequest> getOrderedProductList() {
        return orderedProductList;
    }
}
