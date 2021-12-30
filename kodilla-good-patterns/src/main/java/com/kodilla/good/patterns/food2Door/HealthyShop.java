package com.kodilla.good.patterns.food2Door;

import java.util.ArrayList;
import java.util.List;

public class HealthyShop implements Provider {
    private String providerName;
    private List<Product> warehouseProductList = new ArrayList<>();

    public HealthyShop() {
        this.providerName = "Healthy Shop";
        createWarehouseList();
    }

    @Override
    public String getProviderName() {
        return providerName;
    }

    private void createWarehouseList() {
        Product peanuts = new Product(34576, 30, "peanuts");
        Product coconutMilk = new Product(37654, 50, "coconut milk");
        Product driedApricots = new Product(34776, 100, "dried apricots");

        warehouseProductList.add(peanuts);
        warehouseProductList.add(coconutMilk);
        warehouseProductList.add(driedApricots);

    }
    @Override
    public void process(OrderRequest order) {
        if (checkStock(order) && checkAvailability(order)) {
            System.out.println("Healthy Shop order processed:");
            System.out.println("Product: " + order.getProductType() + ", quantity: " +  order.getQuantity());
            decreaseStock(order);
            System.out.println();
        } else {
            System.out.println("Product out of stock or not available at " + getProviderName());
        }
    }

    private boolean checkStock(OrderRequest order) {
        List<String> productList = new ArrayList<>();
        for (Product product : warehouseProductList) {
            productList.add(product.getProductType());
        }

        if (productList.contains(order.getProductType())) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkAvailability(OrderRequest order) {
        Boolean itemFound = false;
        for (Product product : warehouseProductList) {
            if (product.productType == order.getProductType())
                if (order.getQuantity() <= product.getQuantity())
                    itemFound = true;
        }
        if (itemFound) {
            return true;
        } else {
            return false;
        }
    }

    private void decreaseStock(OrderRequest order) {
        for (Product product : warehouseProductList) {
            if (product.getProductType() == order.getProductType()) {
                product = new Product(product.getProductSerialNo(), product.getQuantity()- order.getQuantity(), product.getProductType());
                System.out.println("Quantity of: " + product.getProductType() + " reduced to " + product.getQuantity());
            }
        }
    }
}
