package ntnu.idatt2105.stianlyng.svinn.controllers;

import ntnu.idatt2105.stianlyng.svinn.entities.User;
import ntnu.idatt2105.stianlyng.svinn.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Gets all users by handeling GET requests to /api/user.
     * Calls getAllUsers() method of UserService instance to retrieve all users.
     * 
     * @return ResponseEntity with a list of all users.
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    
    /**
     * Gets the authenticated user by handeling GET requests to /api/user/me.
     * Calls getAuthenticatedUser() method of UserService instance to retrieve the authenticated user.
     * 
     * @return ResponseEntity with the authenticated user.
     */
    @GetMapping("/me")
    public ResponseEntity<User> getAuthenticatedUser() {
        User user = userService.getAuthenticatedUser();
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    
        return ResponseEntity.ok(user);
    }
    
}