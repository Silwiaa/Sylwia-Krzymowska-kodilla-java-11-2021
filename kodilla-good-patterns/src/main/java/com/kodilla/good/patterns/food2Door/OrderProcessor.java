package com.kodilla.good.patterns.food2Door;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderProcessor {
    private final InformationService informationService;
    private final OrderService orderService;
    private final OrderRepository orderRepository;


    public OrderProcessor(
            final InformationService informationService,
            final OrderService orderService,
            final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public void process(final List<OrderRequest> orderedList) {
        boolean isOrdered = orderService.order(orderedList);
        List<String> providers = createProvidersList(orderedList);
        if (isOrdered) {
            for (int i = 0 ; i < providers.size() ; i++) {
                informationService.inform(providers.get(i));
            }
            orderRepository.createOrder(orderedList);
            System.out.println("Order processed successfully.");
        } else {
            System.out.println("Order process failed.");
        }
    }

    private List<String> createProvidersList(List<OrderRequest> orderedList) {
        List<String> providersTotalList = new ArrayList<>();
        for (OrderRequest order : orderedList) {
            providersTotalList.add(order.getProvider());
        }
        List<String> providersList = providersTotalList.stream()
                .distinct()
                .collect(Collectors.toList());
        return providersList;
    }
}
