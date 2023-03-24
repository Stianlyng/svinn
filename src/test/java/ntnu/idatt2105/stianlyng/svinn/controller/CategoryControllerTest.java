package ntnu.idatt2105.stianlyng.svinn.controller;


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;

import ntnu.idatt2105.stianlyng.svinn.controllers.CategoryController;
import ntnu.idatt2105.stianlyng.svinn.entities.Category;
import ntnu.idatt2105.stianlyng.svinn.services.CategoryService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class CategoryControllerTest {

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnAllCategories() throws Exception {
        Category category1 = Category.builder().id(1).name("Books").description("A collection of books").build();
        Category category2 = Category.builder().id(2).name("Music").description("A collection of music").build();
        when(categoryService.getAllCategories()).thenReturn(Arrays.asList(category1, category2));

        mockMvc.perform(get("/api/v1/categories"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].id", is(1)))
            .andExpect(jsonPath("$[0].name", is("Books")))
            .andExpect(jsonPath("$[0].description", is("A collection of books")))
            .andExpect(jsonPath("$[1].id", is(2)))
            .andExpect(jsonPath("$[1].name", is("Music")))
            .andExpect(jsonPath("$[1].description", is("A collection of music")));
    }

    @Test
    public void shouldCreateCategory() throws Exception {
        Category category = Category.builder().name("Books").description("A collection of books").build();
        when(categoryService.createCategory(ArgumentMatchers.any(Category.class))).thenReturn(category);

        mockMvc.perform(post("/api/v1/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(category)))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.name", is("Books")))
            .andExpect(jsonPath("$.description", is("A collection of books")));
    }


   
}