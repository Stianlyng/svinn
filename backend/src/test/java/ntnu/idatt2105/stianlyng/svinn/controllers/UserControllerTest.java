package ntnu.idatt2105.stianlyng.svinn.controllers;

import ntnu.idatt2105.stianlyng.svinn.entities.Role;
import ntnu.idatt2105.stianlyng.svinn.entities.User;
import ntnu.idatt2105.stianlyng.svinn.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void testGetAllUsers() throws Exception {
        User user1 = new User(null, "Stian", "Lyng", "a@a.a", "aaaa", Role.USER, null);
        User user2 = new User(null, "Lian","Flyng", "asd@asd.no", "aaaa", Role.USER, null);

        List<User> userList = Arrays.asList(user1, user2);

        when(userService.getAllUsers()).thenReturn(userList);

        mockMvc.perform(get("/api/user")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    @WithMockUser(username = "Lian", roles = "USER")
    void testGetAuthenticatedUser() throws Exception {
        User mockUser = new User(null, "Lian","Flyng", "asd@asd.no", "aaaa", Role.USER, null);

        when(userService.getAuthenticatedUser()).thenReturn(mockUser);

        mockMvc.perform(get("/api/user/me")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAuthenticatedUserWithoutAuthentication() throws Exception {
        mockMvc.perform(get("/api/user/me")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }
}