package com.bayron.springcloud.msvc.items.models;

import lombok.Data;

@Data
public class Item {

    private Product product;
    private int quantity;

    public double getTotal() {
        return product.getPrice() * quantity;
    }

}
