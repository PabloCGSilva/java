package com.java.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date; // Import Date class
import java.util.List; // Import List interface

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item create(Item item) {
        // Implementation for creating an item
        return itemRepository.save(item);
    }

    public Item getById(Long id) {
        // Implementation for retrieving an item by ID
        return itemRepository.findById(id).orElse(null);
    }

    public List<Item> getAll() {
        // Implementation for getting all items
        return itemRepository.findAll();
    }

    public void softDelete(Long id) {
        // Implementation for soft deleting an item
        Item item = itemRepository.findById(id).orElse(null);
        if (item != null) {
            item.setDeletedAt(new Date());
            itemRepository.save(item);
        } else {
            throw new IllegalArgumentException("Item with id " + id + " not found");
        }
    }

    // Define other CRUD methods here
}
