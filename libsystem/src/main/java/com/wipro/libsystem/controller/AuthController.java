package com.wipro.libsystem.controller;

import com.wipro.libsystem.entity.Login;
import com.wipro.libsystem.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200") // ✅ allow Angular frontend
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Login login) {
        System.out.println("Login request received: " + login.getUsername());

        boolean isValid = authService.validateStudent(login.getUsername(), login.getPassword());

        Map<String, String> response = new HashMap<>();
        if (isValid) {
            response.put("message", "Login successful");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Invalid username or password");
            return ResponseEntity.status(401).body(response);
        }
    }
}