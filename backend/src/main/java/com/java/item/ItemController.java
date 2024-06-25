package com.java.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List; // Import List interface

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAll();
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        // Set ID to null to ensure auto-incrementation in the backend
        item.setId(null);
        return itemService.create(item);
    }

    @DeleteMapping("/{id}")
    public void softDeleteItem(@PathVariable Long id) {
        itemService.softDelete(id);
    }
}
