package com.kodilla.good.patterns.food2Door;

public interface Provider {
    String getProviderName();
    void process(OrderRequest order);
}
