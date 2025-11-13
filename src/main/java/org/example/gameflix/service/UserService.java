package org.example.gameflix.service;

import org.example.gameflix.model.User;
import org.example.gameflix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public String registerUser(String username, String password) {
        if (userRepository.existsByUsername(username)) {
            return "Username already exists";
        }

        String hashedPassword = passwordEncoder.encode(password);
        User user = new User(username, hashedPassword);
        userRepository.save(user);

        return "User registered successfully";
    }

    public String loginUser(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);

        if (userOptional.isEmpty()) {
            return "Invalid username or password";
        }

        User user = userOptional.get();

        if (passwordEncoder.matches(password, user.getPassword())) {
            return "Login successful";
        } else {
            return "Invalid username or password";
        }
    }
}
