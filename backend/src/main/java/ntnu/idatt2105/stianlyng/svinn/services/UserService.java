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

/**
 * Service class for managing user-related operations.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

   /**
    * Retrieves all users from the database.
    *
    * @return a list of all User instances
    */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
   /**
    * Retrieves a user by email from the database.
    *
    * @param email the email of the user to be retrieved
    * @return an Optional<User> containing the User instance if found, or an empty Optional otherwise
    */ 
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

   /**
    * Retrieves the currently authenticated user.
    *
    * @return the authenticated User instance, or null if there is no authenticated user
    */
    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }

        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            return userRepository.findByEmail(userDetails.getUsername()).orElse(null);
        }

        return null;
    }
}