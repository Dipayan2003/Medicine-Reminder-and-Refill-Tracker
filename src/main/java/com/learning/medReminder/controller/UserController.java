package com.learning.medReminder.controller;

import com.learning.medReminder.dto.MedicineDTO;
import com.learning.medReminder.dto.UserDTO;
import com.learning.medReminder.entity.User;
import com.learning.medReminder.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public User createUser(@RequestBody UserDTO dto) {
        return userService.createUser(dto);
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers().stream()
                .map(user -> new UserDTO(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getMedicines().stream()
                                .map(med -> new MedicineDTO(
                                        med.getName(),
                                        med.getDosage(),
                                        med.getTimes(),
                                        med.getUser().getId()
                                ))
                                .toList()
                )).toList();
    }


    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
}
