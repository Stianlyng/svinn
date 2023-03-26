package ntnu.idatt2105.stianlyng.svinn.controllers;

import lombok.RequiredArgsConstructor;
import ntnu.idatt2105.stianlyng.svinn.auth.AuthenticationRequest;
import ntnu.idatt2105.stianlyng.svinn.auth.AuthenticationResponse;
import ntnu.idatt2105.stianlyng.svinn.auth.RegisterRequest;
import ntnu.idatt2105.stianlyng.svinn.config.LogoutService;
import ntnu.idatt2105.stianlyng.svinn.services.AuthenticationService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;
  private final LogoutService logoutService;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request));
  }
  
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }
  
  //todo; some error here:
  //error: Cross-Origin Request Blocked: The Same Origin Policy disallows reading the remote resource at http://localhost:8080/api/v1/auth/logout. (Reason: CORS header ‘Access-Control-Allow-Origin’ missing). Status code: 200.Logout failed: Network Error
  @DeleteMapping("/logout")
  public ResponseEntity<String> logout(
      HttpServletRequest request,
      HttpServletResponse response,
      Authentication authentication
  ) {
    logoutService.logout(request, response, authentication);
    return ResponseEntity.ok("Logout successful");
  }
  
  
  @GetMapping("/user")
  public ResponseEntity<String> getUserName(Authentication authentication) {
    return ResponseEntity.ok(authentication.getName());
  }
   
  
}
