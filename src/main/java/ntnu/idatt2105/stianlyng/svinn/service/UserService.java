package ntnu.idatt2105.stianlyng.svinn.service;

import ntnu.idatt2105.stianlyng.svinn.model.User;
import ntnu.idatt2105.stianlyng.svinn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
}