package com.bayron.springcloud.msvc.items.services;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bayron.springcloud.msvc.items.clients.ProductFeignClient;
import com.bayron.springcloud.msvc.items.models.Item;
import com.bayron.springcloud.msvc.items.models.Product;

@Service
public class ItemServiceFeign implements ItemService {

    @Autowired
    private ProductFeignClient client;

    @Override
    public List<Item> findAll() {
        return client.findAll()
                .stream()
                .map(p -> new Item(p, new Random().nextInt(10) + 1))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Item> findById(Long id) {
        return Optional.ofNullable(
                new Item(client.findById(id).orElse(null), new Random().nextInt(10) + 1));
    }

}
