package ntnu.idatt2105.stianlyng.svinn.controllers;

import lombok.RequiredArgsConstructor;
import ntnu.idatt2105.stianlyng.svinn.DTO.AuthenticationRequest;
import ntnu.idatt2105.stianlyng.svinn.DTO.AuthenticationResponse;
import ntnu.idatt2105.stianlyng.svinn.DTO.RegisterRequest;
import ntnu.idatt2105.stianlyng.svinn.config.LogoutService;
import ntnu.idatt2105.stianlyng.svinn.services.AuthenticationService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Controller class for handling authentication requests such as registration, authentication and logout.
 * Handles requests to the /api/v1/auth path.
 * 
 * @author Stian Lyng
 */
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  /**
   * Instance of AuthenticationService used for handling registration and authentication requests.
   */
  private final AuthenticationService service;
  
  /**
   * Instance of LogoutService used for handling logout requests.
   */
  private final LogoutService logoutService;

 /**
   * This method is used for registering a new user.
   * Calls register() method of AuthenticationService instance to register a new user.
   * 
   * @param request a RegisterRequest object representing the user's registration information
   * @return a Response containing HTTP status code.   
   */
  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request));
  }
  
 /**
   * This method is used for authenticating a user.
   * Calls authenticate() method of AuthenticationService instance to authenticate a user.
   * 
   * @param request an AuthenticationRequest object representing the user's authentication information
   * @return a Response containing HTTP status code.   
   */
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }
  
  /**
   * This method logs out the authenticated user.
   * 
   * todo; some CORS error here in this method.
   * 
   * @param request the HttpServletRequest object
   * @param response the HttpServletResponse object
   * @param authentication the Authentication object
   * @return a Response containing HTTP status code.   
   */
  @DeleteMapping("/logout")
  public ResponseEntity<String> logout(
      HttpServletRequest request,
      HttpServletResponse response,
      Authentication authentication
  ) {
    logoutService.logout(request, response, authentication);
    return ResponseEntity.ok("Logout successful");
  }
  
  
  
}
