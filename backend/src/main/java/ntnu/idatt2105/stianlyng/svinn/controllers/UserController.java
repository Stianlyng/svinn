package ntnu.idatt2105.stianlyng.svinn.controllers;

import ntnu.idatt2105.stianlyng.svinn.entities.User;
import ntnu.idatt2105.stianlyng.svinn.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    
    //@GetMapping("/{email}")
    //public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
    //    Optional<User> user = userService.getUserByEmail(email);
    //    return user.map(ResponseEntity::ok)
    //            .orElseGet(() -> ResponseEntity.notFound().build());
    //}
    

    @GetMapping("/me")
    public ResponseEntity<User> getAuthenticatedUser() {
        User user = userService.getAuthenticatedUser();
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    
        return ResponseEntity.ok(user);
    }
    
}