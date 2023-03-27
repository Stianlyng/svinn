package ntnu.idatt2105.stianlyng.svinn.services;

import ntnu.idatt2105.stianlyng.svinn.DTO.AuthenticationRequest;
import ntnu.idatt2105.stianlyng.svinn.DTO.AuthenticationResponse;
import ntnu.idatt2105.stianlyng.svinn.DTO.RegisterRequest;
import ntnu.idatt2105.stianlyng.svinn.entities.Role;
import ntnu.idatt2105.stianlyng.svinn.entities.User;
import ntnu.idatt2105.stianlyng.svinn.repositories.TokenRepository;
import ntnu.idatt2105.stianlyng.svinn.repositories.UserRepository;
import ntnu.idatt2105.stianlyng.svinn.token.Token;
import ntnu.idatt2105.stianlyng.svinn.token.TokenType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service class for managing authentication-related operations.
 */
@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository repository;
  private final TokenRepository tokenRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

 /**
  * Registers a new user using the provided RegisterRequest instance.
  *
  * @param request the RegisterRequest instance containing user registration details
  * @return AuthenticationResponse containing the JWT token for the registered user
  */
  public AuthenticationResponse register(RegisterRequest request) {
    var user = User.builder()
        .firstname(request.getFirstname())
        .lastname(request.getLastname())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.USER)
        .build();
    var savedUser = repository.save(user);
    var jwtToken = jwtService.generateToken(user);
    saveUserToken(savedUser, jwtToken);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }
 /**
  * Authenticates a user using the provided AuthenticationRequest instance.
  *
  * @param request the AuthenticationRequest instance containing user authentication details
  * @return AuthenticationResponse containing the JWT token for the authenticated user
  */
  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );
    var user = repository.findByEmail(request.getEmail())
        .orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    revokeAllUserTokens(user);
    saveUserToken(user, jwtToken);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }

 /**
  * Saves a JWT token for a user.
  *
  * @param user the User instance for which the JWT token is to be saved
  * @param jwtToken the JWT token to be saved
  */
  private void saveUserToken(User user, String jwtToken) {
    var token = Token.builder()
        .user(user)
        .token(jwtToken)
        .tokenType(TokenType.BEARER)
        .expired(false)
        .revoked(false)
        .build();
    tokenRepository.save(token);
  }

 /**
  * Revokes all valid JWT tokens for a user.
  *
  * @param user the User instance for which all valid JWT tokens should be revoked
  */
  private void revokeAllUserTokens(User user) {
    var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
    if (validUserTokens.isEmpty())
      return;
    validUserTokens.forEach(token -> {
      token.setExpired(true);
      token.setRevoked(true);
    });
    tokenRepository.saveAll(validUserTokens);
  }
  
 
}
