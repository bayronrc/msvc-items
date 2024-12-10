package com.bayron.springcloud.msvc.items.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bayron.springcloud.msvc.items.models.Item;

@Service
public interface ItemService {
    
    List<Item> findAll();

    Optional<Item> findById(Long id);

}
