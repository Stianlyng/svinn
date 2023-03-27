package ntnu.idatt2105.stianlyng.svinn.controllers;

import ntnu.idatt2105.stianlyng.svinn.DTO.ItemRequestDTO;
import ntnu.idatt2105.stianlyng.svinn.entities.Item;
import ntnu.idatt2105.stianlyng.svinn.services.BookmarkService;
import ntnu.idatt2105.stianlyng.svinn.services.ItemService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @MockBean
    private BookmarkService bookmarkService;


    @Test
    void testCreateItem() throws Exception {
        ItemRequestDTO itemRequest = new ItemRequestDTO();
        itemRequest.setBriefDescription("Sample Item");
        itemRequest.setFullDescription("This is a sample item for testing purposes.");
        itemRequest.setPrice(99.99);
        itemRequest.setCategoryId(1); // Use a valid category ID from your test data
        itemRequest.setLocationId(1); // Use a valid location ID from your test data
    
        Item newItem = new Item();
        newItem.setId(1);
        newItem.setBriefDescription(itemRequest.getBriefDescription());
        newItem.setFullDescription(itemRequest.getFullDescription());
        newItem.setPrice(itemRequest.getPrice());
    
        when(itemService.createItem(itemRequest)).thenReturn(newItem);
    
        ObjectMapper objectMapper = new ObjectMapper();
        String itemRequestJson = objectMapper.writeValueAsString(itemRequest);
    
        mockMvc.perform(post("/api/v1/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(itemRequestJson))
                .andExpect(status().isCreated());
    }


}