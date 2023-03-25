package ntnu.idatt2105.stianlyng.svinn.controllers;

import lombok.RequiredArgsConstructor;
import ntnu.idatt2105.stianlyng.svinn.auth.AuthenticationRequest;
import ntnu.idatt2105.stianlyng.svinn.auth.AuthenticationResponse;
import ntnu.idatt2105.stianlyng.svinn.auth.RegisterRequest;
import ntnu.idatt2105.stianlyng.svinn.services.AuthenticationService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

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


}
