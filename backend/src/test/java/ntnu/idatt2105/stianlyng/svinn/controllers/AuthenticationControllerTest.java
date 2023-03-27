package ntnu.idatt2105.stianlyng.svinn.controllers;

import ntnu.idatt2105.stianlyng.svinn.DTO.RegisterRequest;
import ntnu.idatt2105.stianlyng.svinn.config.LogoutService;
import ntnu.idatt2105.stianlyng.svinn.services.AuthenticationService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AuthenticationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AuthenticationService authService;

    private String email = "stian@kul.no";
    private String password = "pw123";
    
    
    @Test
    void testRegisterEndpoint() throws Exception {
        RegisterRequest registerRequest = new RegisterRequest("stian","lyng",email,password); 

        ObjectMapper objectMapper = new ObjectMapper();
        String registerRequestJson = objectMapper.writeValueAsString(registerRequest);
        
        mockMvc.perform(post("/api/v1/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(registerRequestJson))
                .andExpect(status().isOk());
    }

    //@Test
    //void testRegisterAndAuthenticate() throws Exception {
    //    RegisterRequest registerRequest = new RegisterRequest("stian", "lyng", "mail2@asd.no", password);
    //
    //    ObjectMapper objectMapper = new ObjectMapper();
    //    String registerRequestJson = objectMapper.writeValueAsString(registerRequest);
    //
    //    mockMvc.perform(post("/api/v1/auth/register")
    //            .contentType(MediaType.APPLICATION_JSON)
    //            .content(registerRequestJson))
    //            .andExpect(status().isOk());
    //
    //    AuthenticationRequest authRequest = new AuthenticationRequest("mail2@asd.no", password);
    //    String authRequestJson = objectMapper.writeValueAsString(authRequest);
    //
    //    mockMvc.perform(post("/api/v1/auth/authenticate")
    //            .contentType(MediaType.APPLICATION_JSON)
    //            .content(authRequestJson))
    //            .andExpect(status().isOk());
    //}
}