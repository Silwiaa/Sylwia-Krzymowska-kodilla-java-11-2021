package com.kodilla.good.patterns.food2Door;

import java.util.ArrayList;
import java.util.List;

public class ExtraFoodShop implements Provider {
    private String providerName;
    private List<Product> warehouseProductList = new ArrayList<>();

    public ExtraFoodShop() {
        this.providerName = "Extra Food Shop";
        createWarehouseList();
    }

    @Override
    public String getProviderName() {
        return providerName;
    }

    private void createWarehouseList() {
        Product milk = new Product(12345, 100, "milk");
        Product cream = new Product(45678, 20, "cream");
        Product butter = new Product(45634, 50, "butter");

        warehouseProductList.add(milk);
        warehouseProductList.add(cream);
        warehouseProductList.add(butter);

    }
    @Override
    public void process(OrderRequest order) {
        if (checkStock(order) && checkAvailability(order)) {
            System.out.println("Extra Food Shop order processed:");
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
