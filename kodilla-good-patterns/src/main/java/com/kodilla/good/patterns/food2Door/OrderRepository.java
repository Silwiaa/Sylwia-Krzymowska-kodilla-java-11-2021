package com.kodilla.good.patterns.food2Door;

import java.util.List;

public interface OrderRepository {
    boolean createOrder(List<OrderRequest> orderedList);
}
