package com.kodilla.good.patterns.challenges;

public class OrderProcessor {
    private final InformationService informationService;
    private final OrderService orderService;
    private final OrderRepository orderRepository;


    public OrderProcessor(final InformationService informationService,
                          final OrderService orderService,
                          final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isRented = orderService.order(
                        orderRequest.getUser(),
                        orderRequest.getOrderDate(),
                        orderRequest.getProductSerialNo(),
                        orderRequest.getQuantity(),
                        orderRequest.getPrice());
        if (isRented) {
            informationService.inform(orderRequest.getUser());
            orderRepository.createOrder(
                    orderRequest.getUser(),
                    orderRequest.getOrderDate(),
                    orderRequest.getProductSerialNo(),
                    orderRequest.getQuantity(),
                    orderRequest.getPrice());
            System.out.println("Order processed successfully.");
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            System.out.println("Order process failed.");
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}
