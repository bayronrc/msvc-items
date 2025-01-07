package com.bayron.springcloud.msvc.items.services;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import com.bayron.springcloud.msvc.items.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bayron.springcloud.msvc.items.clients.ProductFeignClient;
import com.bayron.springcloud.msvc.items.models.Item;

@Service
public class ItemServiceFeign implements ItemService {

    @Autowired
    private ProductFeignClient client;

    @Override
    public List<Item> findAll() {
        return client.findAll()
                .stream()
                .map(product -> new Item(product, new Random().nextInt(10) + 1))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Item> findById(Long id) {
        Product product = client.datails(id);

        if (product == null) {
            return Optional.empty();
        }

        return Optional.of(new Item(client.datails(id), new Random().nextInt(10) + 1));
    }
}
