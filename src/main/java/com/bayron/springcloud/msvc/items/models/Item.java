package com.bayron.springcloud.msvc.items.models;

import lombok.Data;

@Data
public class Item {

    private Product product;
    private int quantity;

    public Item(Product product, int i) {
    }

    public double getTotal() {
        return product.getPrice() * quantity;
    }

}
