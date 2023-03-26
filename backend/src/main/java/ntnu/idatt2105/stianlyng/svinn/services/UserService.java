package ntnu.idatt2105.stianlyng.svinn.services;

import ntnu.idatt2105.stianlyng.svinn.entities.User;
import ntnu.idatt2105.stianlyng.svinn.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public User getAuthenticatedUser() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication == null || !authentication.isAuthenticated()) {
        return null;
    }

    Object principal = authentication.getPrincipal();
    if (principal instanceof UserDetails) {
        UserDetails userDetails = (UserDetails) principal;
        return userRepository.findByEmail(userDetails.getUsername())
                .orElse(null);
    }

    return null;
}
}