package com.foodsystem.backend.controller;


import com.foodsystem.backend.dto.LoginRequest;
import com.foodsystem.backend.entity.User;

import com.foodsystem.backend.service.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        System.out.println("Login attempt for: " + loginRequest.getEmail());

        Optional<User> user = userService.login(loginRequest.getEmail(), loginRequest.getPassword());

        if (user.isPresent()) {
            System.out.println("User found in DB!");

            if (user.get().getRole() == null) {
                System.out.println("Error: User role is NULL!");
                return ResponseEntity.status(500).body("User role not assigned in Database");
            }

            Map<String, String> response = new HashMap<>();
            response.put("token", "dummy-token-123");
            response.put("role", user.get().getRole().name());

            return ResponseEntity.ok(response);
        } else {
            System.out.println("User NOT found or Password incorrect!");
            return ResponseEntity.status(401).body("Invalid Email or Password");
        }
    }
}