package com.learning.medReminder.controller;

import com.learning.medReminder.dto.RegisterRequestDTO;
import com.learning.medReminder.entity.User;
import com.learning.medReminder.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequestDTO dto) {

        if (userRepository.findByUsername(dto.getUsername()).isPresent()) {
            return "Username already exists";
        }

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setRole("USER");

        userRepository.save(user);
        return "User registered successfully";
    }
}

