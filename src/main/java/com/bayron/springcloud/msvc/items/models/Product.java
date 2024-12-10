package com.bayron.springcloud.msvc.items.models;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Product {

    private Long id;
    private String name;
    private Double price;
    private LocalDate createAt;

}
