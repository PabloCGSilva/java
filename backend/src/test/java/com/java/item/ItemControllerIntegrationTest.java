package com.java.item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@Rollback(true) // Rollback transaction after each test
public class ItemControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testGetItems() throws Exception {
        Item item = new Item();
        item.setName("Test Item");
        item.setDescription("Test Description");
        item.setPrice(10.0);
        itemRepository.save(item);

        mockMvc.perform(get("/items"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", is("Test Item")))
                .andExpect(jsonPath("$[0].description", is("Test Description")))
                .andExpect(jsonPath("$[0].price", is(10.0)));
    }

    @Test
    public void testCreateItem() throws Exception {
        mockMvc.perform(post("/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"New Item\",\"description\":\"New Description\",\"price\":20.0}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("New Item")))
                .andExpect(jsonPath("$.description", is("New Description")))
                .andExpect(jsonPath("$.price", is(20.0)));
    }
}
