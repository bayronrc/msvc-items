package com.bayron.springcloud.msvc.items.clients;

import com.bayron.springcloud.msvc.items.models.Product;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-products", url = "localhost:8000")
public interface ProductFeignClient {

    @GetMapping
    List<Product> findAll();

    @GetMapping("/{id}")
    Product findById(@PathVariable Long id);

}
