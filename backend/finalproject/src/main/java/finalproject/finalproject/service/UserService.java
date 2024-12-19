package finalproject.finalproject.service;


import finalproject.finalproject.model.User;
import finalproject.finalproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Find a user by email
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Find a user by email and password
    public User findUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    // Save a new user or update an existing one
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Check if a user exists by email
    public boolean existsByEmail(String email) {
        return userRepository.findByEmail(email) != null;
    }

    // Get user by ID
    public Optional<User> findUserById(int userId) {
        return userRepository.findById(userId);
    }

    // Delete user by ID
    public void deleteUserById(int userId) {
        userRepository.deleteById(userId);
    }
}
