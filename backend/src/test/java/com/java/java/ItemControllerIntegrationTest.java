package com.java.java;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetAllItems() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/api/items",
                String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        // Add more assertions as needed
    }

    @Test
    public void testCreateItem() {
        // Prepare request body
        Item newItem = new Item("Test Item");

        // Send POST request
        ResponseEntity<Item> response = restTemplate.postForEntity("http://localhost:" + port + "/api/items", newItem,
                Item.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        // Add more assertions as needed
    }

    // Add more test methods for other endpoints

}
